package Users;

import Main.Application;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    private int phoneNumber;
    private String mail;


    public Administrator(String userID, String userName, String userPassword, int phoneNumber, String mail) {
        super(userID, userName, userPassword);
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public Administrator(String userID, String userName, String userPassword, String userType, int phoneNumber, String mail) {
        super(userID, userName, userPassword, userType);
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public static void addUser(List<User> userList, String name, String password, String userType,  int phoneNumber, String mail) {
        if (userType.equalsIgnoreCase("Customer")){
            userList.add(new Customer(String.valueOf((userList.size() + 1)), name, password));
        } else if (userType.equalsIgnoreCase("Administrator")){
            userList.add(new Administrator(String.valueOf((userList.size() + 1)), name, password, phoneNumber, mail));

        }
    }

    /**
     * Asks for a user ID to update the user's details.
     */
    public void updateUser(ArrayList<User> userList, String newName, String newPassword, String newUserType) {
        if (User.userExists(userList, userName)) {
            userList.get(User.searchUserByName(userList, userName)).setUserName(newName);
            userList.get(User.searchUserByName(userList, userName)).setUserPassword(newPassword);
            userList.get(User.searchUserByName(userList, userName)).setUserType(newUserType);
            System.out.println("User successfully updated.");
        }
    }

    /**
     * Removes a user from the system.
     */
    public void removeUser(List<User> userList, String userToRemove) {
        userList.remove(User.searchUserByName(userList,userToRemove));
        System.out.println("User successfully removed.");
    }

    @Override
    public void actionMenu() {
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
                    //todo
                    if (userType.equalsIgnoreCase("Customer")){
                        Administrator.addCustomer(Application.getUserList(), name, password, userType);
                    } else if (userType.equalsIgnoreCase("Administrator")){
                        Administrator.addUser(Application.getUserList(), name, password, userType);
                    } else {
                        Administrator.addLibrarian(Application.getUserList(), name, password, userType);
                    }
                }

                case 2 -> {
                    System.out.println("Enter the name of the user that you want to update: ");
                    String userToUpdate = sc.nextLine();

                    if (User.userExists(Application.getUserList(),userToUpdate)){
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

                        Application.getUserList().get(User.searchUserByName(Application.getUserList(), userToUpdate)).updateUser(newUserName,newUserPassword,newUserType);

                    } else System.out.println("User not found.");
                }

                case 3 -> {
                    System.out.println("What user do you want to remove?");
                    String userToRemove = sc.nextLine();
                    if (User.userExists(Application.getUserList(), userToRemove)) {
                        Application.getUserList().get(User.searchUserByName(Application.getUserList(),userToRemove)).removeUser(Application.getUserList(), userToRemove);
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
