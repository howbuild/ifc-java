import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;

public class StepUtils {
  private static final String NULLTOKEN = "$";
  private static final ThreadLocal<DecimalFormat> DF_INTLIKE = ThreadLocal.withInitial(() -> {
    DecimalFormat df = new DecimalFormat("0.0############");
    df.setMaximumFractionDigits(15);
    df.setGroupingUsed(false);
    return df;
  });
  private static final ThreadLocal<DecimalFormat> DF_GENERAL = ThreadLocal.withInitial(() -> {
    DecimalFormat df = new DecimalFormat("0.###############");
    df.setMaximumFractionDigits(15);
    df.setGroupingUsed(false);
    return df;
  });

  public static String toStepValue(ConvertibleToStep x, boolean isSelectOption) {
    if (x == null) {
      return NULLTOKEN;
    }

    return x.toStepValue(isSelectOption);
  }

  public static String toStepValue(ConvertibleToStep x) {
    return toStepValue(x, false);
  }

  public static String toStepValue(String x, boolean isSelectOption) {
    if (x == null) {
      return NULLTOKEN;
    }
    return StepStringUtils.encode(x);
  }

  public static String toStepValue(String x) {
    return toStepValue(x, false);
  }

  public static String toStepValue(Enum x, boolean isSelectOption) {
    if (x == null) {
      return NULLTOKEN;
    }

    if (x instanceof IfcLogicalValue) {
      switch ((IfcLogicalValue) x) {
        case TRUE: return ".T.";
        case FALSE: return ".F.";
        case UNKNOWN: return ".U.";
      }
    }
    return "." + x.name() + ".";
  }

  public static String toStepValue(Enum x) {
    return toStepValue(x, false);
  }

  public static String toStepValue(byte[] x, boolean isSelectOption) {
    if (x == null) {
      return NULLTOKEN;
    }

    return Arrays.toString(x);
  }

  public static String toStepValue(byte[] x) {
    return toStepValue(x, false);
  }

  public static String toStepValue(Integer x, boolean isSelectOption) {
    if (x == null) {
      return NULLTOKEN;
    }
    return x.toString();
  }

  public static String toStepValue(Integer x) {
    return toStepValue(x, false);
  }
  
  public static String toStepValue(Long x, boolean isSelectOption) {
    if (x == null) {
      return NULLTOKEN;
    }
    return x.toString();
  }

  public static String toStepValue(Long x) {
    return toStepValue(x, false);
  }

  public static String toStepValue(Double x, boolean isSelectOption) {
    if (x == null) return NULLTOKEN;
    if (x.isNaN() || x.isInfinite()) throw new IllegalArgumentException("Non-finite value in STEP serialization: " + x);
    boolean isIntLike = Math.rint(x) == x;
    DecimalFormat format = isIntLike ? DF_INTLIKE.get() : DF_GENERAL.get();
    return format.format(x);
  }

  public static String toStepValue(Double x) {
    return toStepValue(x, false);
  }

  public static String toStepValue(Boolean x, boolean isSelectOption) {
    if (x == null) {
      return "$";
    }

    return x ? ".T." : ".F.";
  }

  public static String toStepValue(Boolean x) {
    return toStepValue(x, false);
  }

  public static <T> String toStepValue(Collection<T> xs, boolean isSelectOption) {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    for (T x : xs) {
      if (x instanceof ConvertibleToStep) {
        sb.append(((ConvertibleToStep) x).toStepValue(isSelectOption));
      } else if (x instanceof Integer) {
        sb.append(toStepValue((Integer) x, isSelectOption));
      } else if (x instanceof Double) {
        sb.append(toStepValue((Double) x, isSelectOption));
      } else if (x instanceof Enum) {
        sb.append(toStepValue((Enum) x, isSelectOption));
      } else if (x instanceof Boolean) {
        sb.append(toStepValue((Boolean) x, isSelectOption));
      } else if (x instanceof byte[]) {
        sb.append(toStepValue((byte[]) x, isSelectOption));
      } else if (x instanceof Collection) {
        sb.append(toStepValue((Collection) x, isSelectOption));
      }
      sb.append(",");
    }
    sb.append(")");
    return sb.toString();
  }

  public static <T> String toStepValue(Collection<T> xs) {
    return toStepValue(xs, false);
  }
}
