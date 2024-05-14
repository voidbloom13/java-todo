import java.util.ArrayList;

public class Main {
  static ArrayList<User> users = new ArrayList<>();

  public static void main(String[] args) {
    User.createUser();
    System.out.println(users);
  }
}