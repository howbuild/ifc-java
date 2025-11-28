package com.howbuild.ifc;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.Map;

public class StringDecoder {
  private static final Map<Character, String> alphabets = new HashMap<>();

  static {
    for (int i = 0; i < 9; i++) {
      alphabets.put((char) ('A' + i), "ISO-8859-" + (char) ('1' + i));
    }
  }

  private final StringBuilder decoded = new StringBuilder();
  private final String encoded;
  private final int end;
  private String alphabet;
  private int pos = 0;

  public StringDecoder(String encoded) {
    alphabet = alphabets.get('A');
    this.encoded = encoded;
    this.end = encoded.length();
  }

  public String decode() throws IfcDeserializeException {
    int nextBackslash;
    while ((nextBackslash = nextPos('\\')) > -1) {
      decoded.append(encoded, pos, nextBackslash);
      setPos(nextBackslash);
      readDirective();
      next();
    }
    decoded.append(encoded, pos, end);
    return decoded.toString().replace("''", "'");
  }

  private void readDirective() throws IfcDeserializeException {
    switch (next()) {
      case '\\':
        decoded.append('\\');
        break;
      case 'S':
        readPageDirective();
        break;
      case 'P':
        readAlphabetDirective();
        break;
      case 'X':
        readHexDirective();
        break;
      default:
        throw new IfcDeserializeException(
            "dangling \\, cannot decode directive or escaped backslash");
    }
  }

  private void readPageDirective() throws IfcDeserializeException {
    if (next() != '\\') {
      throw new IfcDeserializeException("\\S directive not closed with \\");
    }
    ByteBuffer b = ByteBuffer.wrap(new byte[] {(byte) (next() + 128)});
    decoded.append(Charset.forName(alphabet).decode(b));
  }

  private void readAlphabetDirective() throws IfcDeserializeException {
    alphabet = alphabets.get(next());
    if (alphabet == null) {
      throw new IfcDeserializeException("\\P invalid identifier in alphabet directive");
    }
    if (next() != '\\') {
      throw new IfcDeserializeException("\\P alphabet directive not closed with \\");
    }
  }

  private void readHexDirective() throws IfcDeserializeException {
    switch (next()) {
      case '2':
        readHex2Directive();
        break;
      case '4':
        readHex4Directive();
        break;
      case '\\':
        readHexArbitrary();
        break;
      default:
        throw new IfcDeserializeException("dangling \\X, cannot decode hex directive ");
    }
  }

  private void readHexArbitrary() {
    int code = Integer.parseInt(new String(new char[] {next(), next()}), 16);
    ByteBuffer b = ByteBuffer.wrap(new byte[] {(byte) (code)});
    decoded.append(StandardCharsets.ISO_8859_1.decode(b));
  }

  private void readHex2Directive() throws IfcDeserializeException {
    if (next() != '\\') {
      throw new IfcDeserializeException("\\X2 directive not closed with \\");
    }
    pos++;
    int indexOfEnd = nextPos("\\X0\\");
    if (indexOfEnd == -1) {
      throw new IfcDeserializeException("\\X4\\ not closed with \\X0\\");
    }
    if ((indexOfEnd - pos) % 4 != 0) {
      throw new IfcDeserializeException(
          "Number of hex chars in \\X4\\ definition not divisible by 8");
    }
    byte[] bytes = decodeHex(encoded.substring(pos, indexOfEnd));
    ByteBuffer buffer = ByteBuffer.wrap(bytes);
    decoded.append(StandardCharsets.UTF_16BE.decode(buffer));
    setPos(indexOfEnd + 3);
  }

  private void readHex4Directive() throws IfcDeserializeException {
    if (next() != '\\') {
      throw new IfcDeserializeException("\\X4 directive not closed with \\");
    }
    pos++;
    int indexOfEnd = nextPos("\\X0\\");
    if (indexOfEnd == -1) {
      throw new IfcDeserializeException("\\X4\\ not closed with \\X0\\");
    }
    if ((indexOfEnd - pos) % 8 != 0) {
      throw new IfcDeserializeException(
          "Number of hex chars in \\X4\\ definition not divisible by 8");
    }
    byte[] bytes = decodeHex(encoded.substring(pos, indexOfEnd));
    try {
      ByteBuffer buffer = ByteBuffer.wrap(bytes);
      decoded.append(Charset.forName("UTF-32").decode(buffer));
    } catch (UnsupportedCharsetException e) {
      throw new IfcDeserializeException("UTF-32 is not supported on your system", e);
    }
    setPos(indexOfEnd + 3);
  }

  private byte[] decodeHex(String hex) throws IfcDeserializeException {
    int len = hex.length();
    if ((len & 1) != 0) throw new IfcDeserializeException("Odd length hex sequence");
    byte[] out = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
      int hi = Character.digit(hex.charAt(i), 16);
      int lo = Character.digit(hex.charAt(i + 1), 16);
      if (hi == -1 || lo == -1) throw new IfcDeserializeException("Invalid hex digit");
      out[i / 2] = (byte) ((hi << 4) + lo);
    }
    return out;
  }

  private void setPos(int i) {
    if (i >= 0 && i <= end) {
      pos = i;
    } else {
      throw new IllegalArgumentException();
    }
  }

  private char next() {
    if (pos < end - 1) {
      pos++;
      return encoded.charAt(pos);
    } else {
      pos = end;
      return '\uffff'; // Stolen from StringCharacterIterator
    }
  }

  private int nextPos(String c) {
    return encoded.indexOf(c, pos);
  }

  private int nextPos(char c) {
    return encoded.indexOf(c, pos);
  }
}
