package Publication;

public class Book extends Publication{
    private int pageNumber;
    private String author;
    private int edition;

    //Constructors
    public Book(String ID, String name, String genre, String type, int quantity, int pageNumber, String author, int edition) {
        super(ID, name, genre, type, quantity);
        this.pageNumber = pageNumber;
        this.author = author;
        this.edition = edition;
    }

    public Book(int pageNumber, String author, int edition) {
        this.pageNumber = pageNumber;
        this.author = author;
        this.edition = edition;
    }


    //Getters & Setters
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
}
