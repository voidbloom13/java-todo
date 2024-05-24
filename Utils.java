import java.util.Scanner;
import java.util.regex.*;

public class Utils {
  static Scanner scan = new Scanner(System.in);

  public static String validateUsername() {
    System.out.println("\nCreate your username: ");
    String username = scan.nextLine();
    for (User user : Main.users) {
      if (user.username.equals(username)) {
        System.out.println("\nThis username already exists. \nPlease choose a different username.");
        validateUsername();
      }
      break;
    }
    return username;
  }

  public static String validateEmail() {
    System.out.println("\nEnter your email address:");
    String email = scan.nextLine().toLowerCase();
    if (!email.contains("@")) {
      System.out.println("\nPlease enter a valid email address.");
      validateEmail();
    }
    for (User user : Main.users) {
      if (user.email.equals(email)) {
        System.out.println("\nThis email already exists in our system. \nPlease enter a different email.");
        validateEmail();
      }
      break;
    }
    return email;
  }

  public static String validatePassword() {
    System.out.println("\nPlease create a secure password. Must contain the following:");
    System.out.println("\t\u2023At Least 8 Characters");
    System.out.println("\t\u2023Upper Case Character");
    System.out.println("\t\u2023Lower Case Character");
    System.out.println("\t\u2023Number");
    System.out.println("\t\u2023Special Character: !@#$%&*");
    String password = scan.nextLine();

    String regex = "^(?=.*[0-9])" // contains a number
      + "(?=.*[a-z])(?=.*[A-Z])" // contains a-z, A-Z
      + "(?=.*[!@#$%&*])" // contains a special character
      + "(?=\\S+$).{8,20}$"; // contains no white spaces, between 8-20 characters in length

    Pattern pattern = Pattern.compile(regex); // sets the regex pattern
    Matcher matcher = pattern.matcher(password); // checks the pattern against the param
    if (!matcher.matches()) {
      System.out.println("\nPassword does not meet the criteria.");
      validatePassword();
    }
    System.out.println("\tpassword = " + password);

    // Current bug: If the initial password fails validation, re-enter password portion
    // repeats twice and then fails. password variable is reset as default invalid password. Need to research why.
    System.out.println("\nRe-enter your password: ");
    String passwordCheck = scan.nextLine();
    System.out.println("\tpasswordCheck = " + passwordCheck);

    if (!password.equals(passwordCheck)) {
      System.out.println("Passwords do not match.");
      validatePassword();
    }
    return password;
  }
}