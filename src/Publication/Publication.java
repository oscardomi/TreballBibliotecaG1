package Publication;

import java.util.List;
import java.util.Scanner;

public class Publication {

    private String ID;
    private String name;
    private String genre;
    private String type;
    private int quantity;
    private static Scanner sc = new Scanner(System.in); // Shared scanner

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
    } //
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
    public static void addPublication(List<Publication> publicationList) {
        System.out.println("Write the ID of the publication you want to add: ");
        String ID = sc.nextLine();


        System.out.println("Write the name of the publication: ");
        String name = sc.nextLine();


        System.out.println("Write the genre of the publication: ");
        String genre = sc.nextLine();


        System.out.println("Write the type of the publication: ");
        String type = sc.nextLine();


        publicationList.add(new Publication(ID, name, genre, type, 1));
        System.out.println("Publication.Publication added successfully!");
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

    public static boolean publicationExists(List<Publication> publicationList, String publicationName){
        for (Publication publication : publicationList) {
            if (publicationName.equals(publication.getID())){
                return true;
            }
        }
        return false;
    }

    public static Publication searchPublicationByID(List<Publication> publicationList, String publicationID){
        for (Publication publication : publicationList) {
            if (publication.getID().equals(publicationID)) {
                return publication;
            }
        }
        return null;
    }

    public static Publication searchPublicationByName(List<Publication> publicationList, String publicationName){
        Publication vPublication = new Publication();
        for (Publication publication : publicationList) {
            if (publication.getName().equals(publicationName)) {
                return publication;
            }
        }
        return null;
    }

}