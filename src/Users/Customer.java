package Users;

import Main.Application;
import Main.Lending;

import java.awt.print.Book;
import java.util.List;

public class Customer extends User {
    private String address;
    private boolean membership;

    public Customer(String userID, String userName, String userPassword, String address, boolean membership) {
        super(userID, userName, userPassword);
        this.address = address;
        this.membership = membership;
    }

    public void actionMenu() {
        int option;

        do {
            System.out.println("Insert an option: ");
            System.out.println("1. Add lending");
            System.out.println("2. Return lending");
            System.out.println("3. Show lendings");
            System.out.println("4. Exit");
            System.out.println("=========================");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.println("Which publication do you want to book?");
                    String bookPublication = sc.nextLine();
                    //addLending(Application.getLendingList(), bookPublication);
                }

                case 2 -> {
                    //returnLending();
                }
                case 3 -> {
                    //showLendings();
                }

                case 4 -> {
                    System.out.println("Exiting..");
                }

            }
        } while (option != 4);
    }
//    public void addLending(List<Lending> lendingList, String publication) {
//    //todo fer servir publicationExists() i searchPublicationBy()
//    // demanar opcions i nom des d'aquí o des del main
//    // data hauria de ser un String, buscar com es fa
////        Publication.Publication publication = Publication.Publication.searchPublication();
////        rentList.add(new Main.Rent(rentList.size() + 1, this.Users.User, publication, Date.from(), Date.from() + 30));
//        for (int i = 0; i < Application.getPublicationList().size(); i++) {
//            if (Application.getPublicationList().get(i).getName().equalsIgnoreCase(publication)){
//                lendingList.add(new Lending())
//            }
//        }
//  }
}
