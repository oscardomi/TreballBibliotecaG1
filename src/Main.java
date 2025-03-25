//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User.addUser();
        System.out.println(User.userList.get(0).getUserName());
        User.userList.get(0).removeUser();
        System.out.println(User.userList.get(0).getUserName());

        User u1 = new User("2", "Josefina", "Administrator");
        System.out.println(u1.getUserName());
        u1.removeUser();
        System.out.println(u1.getUserName());

    }
}