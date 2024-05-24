import java.util.Scanner;
import java.util.ArrayList;

public class User {
  public String firstName, lastName, username, email, password;
  public static boolean isActive;

  static ArrayList<ToDo> todos = new ArrayList<>();

  public User() {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter your first name:");
    String firstName = scan.nextLine();

    System.out.println("\nEnter your last name:");
    String lastName = scan.nextLine();

    username = Utils.validateUsername();
    email = Utils.validateEmail();
    password = Utils.validatePassword();
  }

  public static void createUser() {
    User newUser = new User();
    Main.users.add(newUser);
  }
}