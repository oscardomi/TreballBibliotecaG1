package Users;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    protected String userID;
    protected String userName;
    protected String userPassword;
    //todo esborrar userType
    protected static final Scanner sc = new Scanner(System.in);

    //Constructors
    public User() {
        this.userID = "";
        this.userName = "";
        this.userPassword = "";
    }
    public User(String userID, String userName, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    //Getters and setters
    public java.lang.String getUserID() {
        return userID;
    }
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }
    public java.lang.String getUserName() {
        return userName;
    }
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Adds a new user with a predefined Customer user type.
     */
    public static void addCustomer(List<User> userList, String name, String password, String address, boolean membership) {
        userList.add(new Customer(String.valueOf((userList.size() + 1)), name, password, address, membership));
    }

    public static void addAdministrator(List<User> userList, String name, String password, int phoneNumber, String mail) {
        userList.add(new Administrator(String.valueOf((userList.size() + 1)), name, password, phoneNumber, mail));
    }

    public static void addLibrarian(List<User> userList, String name, String password, String schedule, double salary) {
        userList.add(new Librarian(String.valueOf((userList.size() + 1)), name, password, schedule, salary));
    }

    /**
     * Override method that shows a user's information.
     *
     * @return Users.User's information.
     */
    @Override
    public String toString() {
        return "UserID: " + userID +
                "\nUsername= " + userName;
    }

    public void actionMenu(){}

    public void updateUser(String newUserName, String newUserPassword){
        this.setUserName(newUserName);
        this.setUserPassword(newUserPassword);
    }

    //todo probablement innecessari, es pot esborrar i corregir els altres mètodes
    public static boolean userExists(List<User> userList, String userName) {
        for (User currentUser : userList) {
            if (userName.equals(currentUser.getUserName())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Removes a user from the system.
     */
    public void removeUser(List<User> userList, String userToRemove) {
        userList.remove(User.searchUserByName(userList,userToRemove));
        System.out.println("User successfully removed.");
    }
    public static int searchUserByName(List<User> userList, String userName) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName)) {
                return i; // Retorna la posició de l'usuari dins la llista
            }
        }
        return -1;
    }




    public static void actionMenu() {
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

                        userList.get(User.searchUserByName(userList, userToUpdate)).updateUser(userList,newUserName,newUserPassword,newUserType);

                    } else System.out.println("Users.User not found.");
                }

                case 3 -> {
                    System.out.println("What user do you want to remove?");
                    String userToRemove = sc.nextLine();
                    if (User.userExists(userList, userToRemove)) {
                        userList.get(User.searchUserByName(userList,userToRemove)).removeUser(userList, userToRemove);
                    } else System.out.println("Unable to find the user.");
                }

//                case 4 -> {
//                    System.out.println("Which publication do you want to book?");
//                    String publicationToBook = sc.nextLine();
//
//                    userList.get(Users.User.searchUserByName(userList,)).addRent();
//                }

                case 5 -> {
                    System.out.println("Exiting...");
                }
            }
        } while (option != 5);
    }

}