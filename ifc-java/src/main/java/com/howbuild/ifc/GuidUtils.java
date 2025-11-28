package com.howbuild.ifc;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public final class GuidUtils {
  private GuidUtils() {}

  public static String compress(String uuidHex) {
    if (uuidHex == null) return null;
    uuidHex = uuidHex.replace("-", "");
    if (uuidHex.length() != 32) return uuidHex;
    UUID u =
        new UUID(
            Long.parseUnsignedLong(uuidHex.substring(0, 16), 16),
            Long.parseUnsignedLong(uuidHex.substring(16), 16));
    ByteBuffer bb = ByteBuffer.allocate(16);
    bb.putLong(u.getMostSignificantBits());
    bb.putLong(u.getLeastSignificantBits());
    return Base64.getUrlEncoder().withoutPadding().encodeToString(bb.array());
  }

  public static String expand(String compressed) {
    if (compressed == null) return null;
    if (compressed.length() != 22) return compressed;
    byte[] bytes = Base64.getUrlDecoder().decode(compressed);
    ByteBuffer bb = ByteBuffer.wrap(bytes);
    UUID u = new UUID(bb.getLong(), bb.getLong());
    return u.toString();
  }
}
