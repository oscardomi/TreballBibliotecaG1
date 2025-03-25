import java.util.Scanner;
import java.util.ArrayList;

public class Publications {

    private String ID;
    private String name;
    private String genre; // Cambio de gender a genre
    private String type;
    private int quantity;

    private static ArrayList<Publications> publicationsList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in); // Scanner compartido

    // Constructors
    public Publications(String ID, String name, String genre, String type, int quantity) {
        this.ID = ID;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.quantity = quantity;
    }

    public Publications() {
        this.ID = "";
        this.name = "";
        this.genre = "";
        this.type = "";
        this.quantity = 1;
    }

    // Getters and Setters
    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGenre() { return genre; } // Cambio de gender a genre
    public void setGenre(String genre) { this.genre = genre; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Methods
    public static void addPublication(Publications pub) {
        System.out.println("Write the ID of the publication you want to add: ");
        String ID = sc.nextLine();
        pub.setID(ID); // Set the ID for the current publication

        System.out.println("Write the name of the publication: ");
        String name = sc.nextLine();
        pub.setName(name); // Set the name for the current publication

        System.out.println("Write the genre of the publication: ");
        String genre = sc.nextLine();
        pub.setGenre(genre); // Set the genre for the current publication

        System.out.println("Write the type of the publication: ");
        String type = sc.nextLine();
        pub.setType(type); // Set the type for the current publication

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
}
