package com.howbuild.ifc;

import com.howbuild.ifc.v4.IfcLogicalValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StepParser {
  private final String input;
  private int pos = 0;

  private StepParser(String line) {
    this.input = line;
  }

  public static StepEntity parse(String line) {
    return new StepParser(line).parse();
  }

  private StepEntity parse() {
    String type = parseType();
    List<StepToken> tokens = parseTokens();

    return new StepEntity(type, tokens);
  }

  private String parseType() {
    int startType = pos;
    while (input.charAt(pos) != '(' && input.charAt(pos) != ';') {
      pos++;
    }
    return input.substring(startType, pos).trim();
  }

  private List<StepToken> parseTokens() {
    if ((pos + 1) >= input.length()) {
      return Collections.emptyList();
    }

    List<StepToken> params = new ArrayList<>();
    pos++; // skip the opening bracket
    while (input.charAt(pos) != ')') {
      skipSpaces();
      char c = input.charAt(pos);
      if (c == '(') {
        params.add(new StepToken(StepTokenType.SET, parseTokens()));
      } else if (c == '\'') {
        params.add(parseString());
      } else if (c == '.') {
        if (pos + 1 < input.length() && Character.isDigit(input.charAt(pos + 1))) {
          params.add(parseNumber());
        } else {
          params.add(parseEnum());
        }
      } else if ((c >= '0' && c <= '9')
          || c == '.'
          || c == 'e'
          || c == 'E'
          || c == '-'
          || c == '+') {
        params.add(parseNumber());
      } else if (Character.isAlphabetic(c)) {
        String name = parseType();
        params.add(new StepToken(StepTokenType.ENTITY, name, parseTokens()));
      } else if (c == '$') {
        params.add(new StepToken(StepTokenType.EMPTY));
        pos++;
      } else if (c == '*') {
        params.add(new StepToken(StepTokenType.UNKNOWN));
        pos++;
      } else if (c == '#') {
        params.add(parseRef());
      } else {
        // unknown token
        pos++;
      }

      if (pos >= input.length()) {
        break;
      }

      if (input.charAt(pos) == ',') {
        pos++; // skip the comma
      }

      skipSpaces();
    }
    pos++; // skip the closing bracket
    return params;
  }

  private StepToken parseRef() {
    pos++; // skip the #
    int startPos = pos;

    // find the end of the number
    while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
      pos++;
    }

    String refString = input.substring(startPos, pos);
    int refNum = Integer.parseInt(refString);

    // Here we simply use "REFERENCE" as type, and refNum as value.
    // In actual implementation, we may look up the referenced entity based on refNum.
    return new StepToken(StepTokenType.REF, refNum);
  }

  private StepToken parseEnum() {
    pos++; // skip the beginning period
    int startPos = pos;

    // find the ending period
    while (input.charAt(pos) != '.') {
      pos++;
    }

    String enumString = input.substring(startPos, pos);
    pos++; // skip the ending period

    if (enumString.equals("T")) {
      return new StepToken(StepTokenType.LOGICAL, IfcLogicalValue.TRUE);
    } else if (enumString.equals("F")) {
      return new StepToken(StepTokenType.LOGICAL, IfcLogicalValue.FALSE);
    } else if (enumString.equals("U")) {
      return new StepToken(StepTokenType.LOGICAL, IfcLogicalValue.UNKNOWN);
    }

    // Here we simply use enumString as both type and value, as we do not know the concrete enum
    // types.
    // In actual implementation, enumString will be mapped to specific enum type and value.
    return new StepToken(StepTokenType.ENUM, enumString);
  }

  private StepToken parseNumber() {
    String number = "";
    char c = input.charAt(pos); // get the first character

    while ((c >= '0' && c <= '9') || c == '.' || c == 'e' || c == 'E' || c == '-' || c == '+') {
      number += c; // add the character to the number string
      pos++; // advance to the next character
      if (pos < input.length()) { // check if not at the end of the string
        c = input.charAt(pos);
      } else {
        break; // break the loop if at the end
      }
    }

    // Determine token type
    if (number.contains(".") || number.toLowerCase().contains("e")) {
      return new StepToken(StepTokenType.REAL, Double.parseDouble(number));
    } else {
      return new StepToken(StepTokenType.INTEGER, Long.parseLong(number));
    }
  }

  private void skipSpaces() {
    while (Character.isWhitespace(input.charAt(pos))) {
      pos++;
    }
  }

  private StepToken parseString() {
    int startPos = ++pos; // skip the starting single quote
    int len = input.length();
    char stopSign = '\'';
    int i = startPos;
    while (i < len) {
      pos = i;
      char cur = input.charAt(i);
      char next = input.charAt(i + 1);
      if (cur == stopSign && next == stopSign) {
        i += 2;
        continue;
      }

      if (cur == stopSign) break;

      i += 1;
    }

    String result = input.substring(startPos, pos);
    pos++; // skip the closing single quote
    StringDecoder decoder = new StringDecoder(result);
    String decoded = decoder.decode();
    return new StepToken(StepTokenType.STRING, decoded);
  }
}
