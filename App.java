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
  }
}