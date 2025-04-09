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


    /**
     * Asks for a user ID to update the user's details.
     */
    public void updateUser(ArrayList<User> userList, String newName, String newPassword) {
        if (User.userExists(userList, userName)) {
            userList.get(User.searchUserByName(userList, userName)).setUserName(newName);
            userList.get(User.searchUserByName(userList, userName)).setUserPassword(newPassword);
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
                        System.out.println("Enter the address:");
                        String address = sc.nextLine();
                        boolean validOption = false;
                        String membershipAux;
                        boolean membership = false;
                        do {
                            System.out.println("Will the new user be a member? (Y/N)");
                            membershipAux = sc.nextLine();
                            if (membershipAux.equalsIgnoreCase("Y")){
                                validOption=true;
                                membership=true;
                            } else if (membershipAux.equalsIgnoreCase("N")) {
                                validOption= true;
                                membership=false;
                            } else System.out.println("Enter a valid option.");
                        } while(!validOption);
                        User.addCustomer(Application.getUserList(), name, password, address, membership);

                    } else if (userType.equalsIgnoreCase("Administrator")){
                        //todo comprovar que el telèfon i mail siguin vàlids
                        System.out.println("Enter a phone number: ");
                        int phoneNumber = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter a mail:");
                        String mail = sc.nextLine();
                        User.addAdministrator(Application.getUserList(), name, password, phoneNumber,mail);

                    } else {
                        System.out.println("Enter the shift: ");
                        String shift = sc.nextLine();
                        System.out.println("Enter the salary: ");
                        double salary = Double.parseDouble(sc.nextLine());
                        User.addLibrarian(Application.getUserList(), name, password, shift, salary);
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

                        Application.getUserList().get(User.searchUserByName(Application.getUserList(), userToUpdate)).updateUser(newUserName,newUserPassword);

                    } else System.out.println("User not found.");
                }

                case 3 -> {
                    System.out.println("What user do you want to remove?");
                    String userToRemove = sc.nextLine();
                    if (User.userExists(Application.getUserList(), userToRemove)) {
                        Application.getUserList().get(User.searchUserByName(Application.getUserList(),userToRemove)).removeUser(Application.getUserList(), userToRemove);
                    } else System.out.println("Unable to find the user.");
                }

                case 4 -> {
                    System.out.println("Exiting...");
                }
            }
        } while (option != 5);
    }

}
