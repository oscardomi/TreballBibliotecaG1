package Publication;

public class Magazine extends Publication{
    private int pageNumber;
    private String editorial;

    //Constructors
    public Magazine(String ID, String name, String genre, String type, int quantity, int pageNumber, String editorial) {
        super(ID, name, genre, type, quantity);
        this.pageNumber = pageNumber;
        this.editorial = editorial;
    }

    public Magazine(int pageNumber, String editorial) {
        this.pageNumber = pageNumber;
        this.editorial = editorial;
    }


    //Getters & Setters
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
