import static java.lang.System.exit;

public class App {
  public static void main(String args[]) {
    if (args.length == 0) {
      System.out.println("An argument required");
      System.exit(1);
    }

    System.out.println(args[0] + "=" + calculate(args[0]));

  }

  public static int calculate(String formula) {
    // TODO
    String num = "0123456789";
    String op = "+-";
    boolean canNext = false;
    char nextOp = '+';
    int total = 0;
    int n = 0;
    char[] charArr = formula.toCharArray();
    for (int i = 0; i < charArr.length; i++) {
      char c = charArr[i];
      if (op.contains(String.valueOf(c))) {
        if (!canNext) {
          System.out.println("invalid input");
          System.exit(1);
        }
        switch (nextOp) {
          case '+':
            total += n;
            break;
          case '-':
            total -= n;
            break;
        }
        canNext = false;
        nextOp = c;
        n = 0;
      } else if (num.contains(String.valueOf(c))) {
        if (!canNext && (int) c == 0) {
          System.out.println("invalid input");
          System.exit(1);
        }
        n = n * 10 + Character.getNumericValue(c);
        canNext = true;
      } else {
        System.out.println("invalid input");
        System.exit(1);
      }
    }
    if (canNext) {
      switch (nextOp) {
        case '+':
          total += n;
          break;
        case '-':
          total -= n;
          break;
      }
    }
    return total;
  }
}