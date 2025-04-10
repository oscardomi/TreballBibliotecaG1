package Publication;

public class Film extends Publication{
    private int duration;
    private String description;
    private String director;

    //Constructors
    public Film(String ID, String name, String genre, String type, int quantity, int duration, String description, String director) {
        super(ID, name, genre, type, quantity);
        this.duration = duration;
        this.description = description;
        this.director = director;
    }

    public Film(int duration, String description, String director) {
        this.duration = duration;
        this.description = description;
        this.director = director;
    }


    //Getters & Setters
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
