import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public void mainMenu(){
        int option;

        do {
            System.out.println("\n--- WELCOME ---");
            System.out.println("1. Log in");
            System.out.println("2. Sign in");
            System.out.println("3. Exit");
            System.out.println("=========================");
            System.out.print("Insert an option: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.print("Insert User name: ");
                    String userName = sc.nextLine();
                    for (int i = 0; i < User.userList.size(); i++) {
                        userName.equals(User.userList);
                    }
                }
                case 2 -> System.out.println("Sign in");
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Please, insert a valid number.");
            }
        } while (option != 3);




    }
}