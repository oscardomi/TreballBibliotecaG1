package Publication;

public class Album extends Publication {
    private int songNumber;
    private String artist;
    private int duration;
    private String distributor;


    //Constructors
    public Album(String ID, String name, String genre, String type, int quantity, int songNumber, String artist, int duration, String distributor) {
        super(ID, name, genre, type, quantity);
        this.songNumber = songNumber;
        this.artist = artist;
        this.duration = duration;
        this.distributor = distributor;
    }

    public Album(int songNumber, String artist, int duration, String distributor) {
        this.songNumber = songNumber;
        this.artist = artist;
        this.duration = duration;
        this.distributor = distributor;
    }


    //Getters & Setters
    public int getSongNumber() {
        return songNumber;
    }

    public void setSongNumber(int songNumber) {
        this.songNumber = songNumber;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }
}
