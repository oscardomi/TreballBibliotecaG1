package Main;

import Publication.Publication;
import Users.Administrator;
import Users.Customer;
import Users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    private static final ArrayList<User> userList = new ArrayList<>();
    private static final ArrayList<Publication> publicationList = new ArrayList<>();
    private static final ArrayList<Lending> lendingList = new ArrayList<>();

    public static void main(String[] args) {
        initialiseLists(userList, publicationList);
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
                                System.out.println("abans menú");
                                userList.get(i).actionMenu();
                                System.out.println("després menú");
                            } else System.out.println("Wrong password.");
                        }

                    }
                    if (!userFound) System.out.println("User not found.");
                }
                case 2 -> {
                    //todo posar tot això en un mètode, es repeteix a afegir usuari d'administrador
                    System.out.println("What name do you want to give the new user?");
                    String userName = sc.nextLine();
                    System.out.println("What password do you want to give the new user?");
                    String userPassword = sc.nextLine();
                    System.out.println("What address do you want to give the new user?");
                    String userAddress = sc.nextLine();
                    boolean validOption = false;
                    String membershipAux;
                    boolean membership = false;
                    do {
                        System.out.println("Do you want to be a member? (Y/N)");
                        membershipAux = sc.nextLine();
                        if (membershipAux.equalsIgnoreCase("Y")){
                            validOption=true;
                            membership=true;
                        } else if (membershipAux.equalsIgnoreCase("N")) {
                            validOption= true;
                            membership=false;
                        } else System.out.println("Enter a valid option.");
                    } while(!validOption);

                    User.addCustomer(userList, userName, userPassword, userAddress, membership);
                    userList.getLast().actionMenu();
                }
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Please, insert a valid number.");
            }
        } while (option != 3);


    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    private static void initialiseLists(ArrayList<User> userList, ArrayList<Publication> publicationList) {
        userList.add(new Administrator("0", "admin", "admin", 607352614 , "admin@admin.com"));
        userList.add(new Customer("1", "Andrea", "1234", "c/Major", false));
        userList.add(new Customer("2", "Miquel", "1234", "av. Diagonal", true));
        publicationList.add(new Publication("1" ,"Romeo and Juliet", "Tragedy", "Book", 1));
        publicationList.add(new Publication("2" ,"El Capital", "Economy", "Book", 1));
        publicationList.add(new Publication("3" ,"Shrek 2", "Animation", "Film", 1));
    }
}