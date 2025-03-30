import java.util.Scanner;
import java.util.ArrayList;

public class Publication {

    private String ID;
    private String name;
    private String genre;
    private String type;
    private int quantity;

    public static ArrayList<Publication> publicationList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in); // Scanner compartido

    // Constructors
    public Publication(String ID, String name, String genre, String type, int quantity) {
        this.ID = ID;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.quantity = quantity;
    }

    public Publication() {
        this.ID = "";
        this.name = "";
        this.genre = "";
        this.type = "";
        this.quantity = 1;
    }

    // Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    } // Cambio de gender a genre

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Methods
    public static void addPublication() {
        System.out.println("Write the ID of the publication you want to add: ");
        String ID = sc.nextLine();


        System.out.println("Write the name of the publication: ");
        String name = sc.nextLine();


        System.out.println("Write the genre of the publication: ");
        String genre = sc.nextLine();


        System.out.println("Write the type of the publication: ");
        String type = sc.nextLine();


        publicationList.add(new Publication(ID, name, genre, type, 1));
        System.out.println("Publication added successfully!");
    }

    @Override
    public String toString() {
        return "Publication " +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity;
    }

    public static Publication searchPublication() {

        System.out.println("Com vols buscar la publicacio?" +
                "By ID: 1" +
                "By name: 2");

        int option = Integer.parseInt(sc.nextLine());

        do {
            switch (option) {
                case 1 -> {
                    System.out.println("Digues l'ID de la publicacio que vols buscar: ");
                    String searchId = sc.nextLine();

                    for (int i = 0; i < publicationList.size(); i++) {
                        if (publicationList.get(i).getID().equals(searchId)) {
                            return publicationList.get(i);
                        }
                    }
                    System.out.println("Not in our database");
                }
                case 2 -> {
                    System.out.println("Digues el nom de la publicacio que vols buscar: ");
                    String searchName = sc.nextLine();

                    for (int i = 0; i < publicationList.size(); i++) {
                        if (publicationList.get(i).getName().equals(searchName)) {
                            return publicationList.get(i);
                        }
                    }
                    System.out.println("Not in our batabase");
                }
            }


        } while (option != 1 || option != 2);
    }
}