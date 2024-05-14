import java.util.Scanner;

public class User {
  static Scanner input = new Scanner(System.in);

  private String firstName, lastName, username, password, email;
  private static boolean isActive;
  // ToDo todos = new ToDo[20];
  
  public User(String firstName, String lastName, String username, String password, String email) {
    firstName = this.firstName;
    lastName = this.lastName;
    username = this.username;
    password = this.password;
    email = this.email;
  }

  private static void setIsActive(String username) {
    for (User user : Main.users) {
      if (username.equals(user.username)) {
        user.isActive = true;
      } else {
        user.isActive = false;
      }    
    }
  }
  
  private static String checkUsername() {
    System.out.print("Username: ");
    String username = input.nextLine();
    for (User user : Main.users) {
      if (username.equals(user.username)) {
        System.out.println("\nUsername already exists in our system. Please choose a new username or log in.");
        checkUsername();
      }
    }
    return username;
  }

  private static String checkEmail() {
    System.out.print("Email: ");
    String email = input.nextLine();
    for (User user : Main.users) {
      if (email.equals(user.email)) {
        System.out.println("\nEmail already exists in our system. Please choose a new email or log in.");
        checkEmail();
      } 
    }
    return email;
  }

  static void createUser() {
    String firstName;
    String lastName;
    String username;
    String password;
    String email;

    System.out.print("First Name: ");
    firstName = input.nextLine();

    System.out.print("Last Name: ");
    lastName = input.nextLine();

    username = checkUsername();

    System.out.print("Password: ");
    password = input.nextLine(); // Add validation later. 8 Chars, Upper, Lower, Number, Special Char

    email = checkEmail();
    setIsActive(username);

    User newUser = new User(firstName, lastName, username, password, email);
    Main.users.add(newUser);
  }
}