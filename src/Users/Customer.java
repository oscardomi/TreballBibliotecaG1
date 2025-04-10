package Users;

public class Customer extends User {
    private String address;
    private boolean membership;

    public Customer(String userID, String userName, String userPassword, String address, boolean membership) {
        super(userID, userName, userPassword);
        this.address = address;
        this.membership = membership;
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

                }
            }
        } while (option != 5);
    }
    //public void addLending(List<Lending> lendingList) {
    //todo fer servir publicationExists() i searchPublicationBy()
    // demanar opcions i nom des d'aquí o des del main
    // data hauria de ser un String, buscar com es fa
//        Publication.Publication publication = Publication.Publication.searchPublication();
//        rentList.add(new Main.Rent(rentList.size() + 1, this.Users.User, publication, Date.from(), Date.from() + 30));
//    }
}
