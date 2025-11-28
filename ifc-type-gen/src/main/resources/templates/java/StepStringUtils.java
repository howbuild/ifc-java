import java.nio.charset.StandardCharsets;

/**
 * STEP string encoder/decoder utilities (ISO-10303-21).
 */
public final class StepStringUtils {
    private StepStringUtils() {}

    /**
     * Encode a Java string into a STEP string literal:
     * - Quotes are doubled.
     * - If all characters are 7-bit ASCII, returns '...'.
     * - Otherwise uses {@code \\X2\\<UTF-16BE hex>\\X0\\} wrapper.
     */
    public static String encode(String value) {
        if (value == null) return "$";
        boolean ascii = value.chars().allMatch(c -> c >= 0x20 && c <= 0x7E);
        if (ascii) {
            String escaped = value.replace("'", "''");
            return "'" + escaped + "'";
        }

        byte[] bytes = value.getBytes(StandardCharsets.UTF_16BE);
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(String.format("%02X", b));
        }
        return "'\\X2\\" + hex + "\\X0\\'";
    }

    /**
     * Decode a STEP string literal (minimal support for \X2\...\X0\).
     * Assumes surrounding quotes already removed.
     */
    public static String decode(String stepLiteral) {
        if (stepLiteral == null || stepLiteral.equals("$")) return null;
        String s = stepLiteral;
        // Strip surrounding quotes if present
        if (s.length() >= 2 && s.startsWith("'") && s.endsWith("'")) {
            s = s.substring(1, s.length() - 1);
        }
        s = s.replace("''", "'");
        if (s.startsWith("\\X2\\") && s.endsWith("\\X0\\")) {
            String hex = s.substring(4, s.length() - 4);
            int len = hex.length();
            byte[] bytes = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                bytes[i / 2] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
            }
            String decoded = new String(bytes, StandardCharsets.UTF_16BE);
            return decoded.replace("''", "'");
        }
        return s.replace("''", "'");
    }
}
