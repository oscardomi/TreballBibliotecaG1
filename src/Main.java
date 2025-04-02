import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final ArrayList<User> userList = new ArrayList<>();
    private static final ArrayList<Publication> publicationList = new ArrayList<>();
    private static final ArrayList<Rent> rentList = new ArrayList<>();

    public static void main(String[] args) {
        userList.add(new User("0", "admin", "admin", "Administrator"));

        //initialiseLists();

        logMenu();

    }

    public static void logMenu() {
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
                    System.out.print("Insert username: ");
                    String userName = sc.nextLine();
                    boolean userFound = false;

                    for (int i = 0; i < userList.size(); i++) {
                        if (userName.equals(userList.get(i).getUserName())) {
                            userFound = true;
                            System.out.println("User found. Insert password: ");
                            String userPassword = sc.nextLine();
                            if (userPassword.equals(userList.get(i).getUserPassword())) {
                                if (userList.get(i).isAdmin()) {
                                    actionMenu();
                                } else if (userList.get(i).isLibrarian()){
                                    actionMenu();
                                } else actionMenu();
                            } else System.out.println("Wrong passwor    d.");
                        }

                    }
                    if (!userFound) System.out.println("User not found.");
                }
                case 2 -> {
                    System.out.println("What name do you want to give the new user?");
                    String userName = sc.nextLine();
                    System.out.println("What password do you want to give the new user?");
                    String userPassword = sc.nextLine();
                    User.addUser(userList, userName, userPassword);
                    adminActionMenu();
                }
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Please, insert a valid number.");
            }
        } while (option != 3);


    }

    private static void adminActionMenu() {
        int option;

        do {
            System.out.println("Insert an option: ");
            System.out.println("1. Add user");
            System.out.println("2. Update user");
            System.out.println("3. Remove user");
            System.out.println("4. Borrow publication");
            System.out.println("5. Exit");
            System.out.println("=========================");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.println("What name do you want to give the new user?");
                    String name = sc.nextLine();
                    System.out.println("What password do you want to give the new user?");
                    String password = sc.nextLine();

                    //todo crear mètode per desduplicar codi
                    boolean validUserType = false;
                    String userType;
                    do {
                        System.out.println("Enter the new user type: ");
                        userType = sc.nextLine();
                        if (userType.equalsIgnoreCase("Customer") || userType.equalsIgnoreCase("Administrator") || userType.equalsIgnoreCase("Librarian")) {
                            validUserType = true;
                        } else {
                            System.out.println("Invalid user type. Users can only be 'Customer', 'Administrator' or 'Librarian'.");
                        }

                    } while (!validUserType);
                    User.addUser(userList, name, password, userType);
                }

                case 2 -> {
                    System.out.println("Enter the name of the user that you want to update: ");
                    String userToUpdate = sc.nextLine();

                    if (User.userExists(userList,userToUpdate)){
                        System.out.println("Enter the new name: ");
                        String newUserName = sc.nextLine();
                        System.out.println("Enter the new password: ");
                        String newUserPassword = sc.nextLine();

                        //todo crear mètode per desduplicar codi
                        String newUserType;
                        boolean validUserType = false;
                        do {
                            System.out.println("Enter the new user type: ");
                            newUserType = sc.nextLine();
                            if (newUserType.equalsIgnoreCase("Customer") || newUserType.equalsIgnoreCase("Administrator") || newUserType.equalsIgnoreCase("Librarian")) {
                                validUserType = true;
                            } else {
                                System.out.println("Invalid user type. Users can only be 'Customer', 'Administrator' or 'Librarian'.");
                            }

                        } while (!validUserType);

                        userList.get(User.searchUserByName(userList, userToUpdate))
                                .updateUser(userList,newUserName,newUserPassword,newUserType);

                    } else System.out.println("User not found.");
                }

                case 3 -> {
                    System.out.println("What user do you want to remove?");
                    String userToRemove = sc.nextLine();
                    if (User.userExists(userList, userToRemove)) {
                        userList.get(User.searchUserByName(userList,userToRemove))
                                .removeUser(userList, userToRemove);
                    } else System.out.println("Unable to find the user.");
                }

//                case 4 -> {
//                    System.out.println("Which publication do you want to book?");
//                    String publicationToBook = sc.nextLine();
//
//                    userList.get(User.searchUserByName(userList,)).addRent();
//                }

                case 5 -> {
                    System.out.println("Exiting...");
                }
            }
        } while (option != 5);
    }
}