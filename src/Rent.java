import java.util.Date;

public class Rent {
    private String ID;
    private String userID;
    private Date rentDate;
    private Date returnDate;


    //Constructor
    public Rent(String ID, String userID, Date rentDate, Date returnDate) {
        this.ID = ID;
        this.userID = userID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }


    //Getters
    public String getID() {
        return ID;
    }

    public String getUserID() {
        return userID;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }


    //Setters
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }


    //Override Method that shows the Rent Information
    @Override
    public String toString() {
        return "===== Rent =====\n" +
                " ID: '" + ID + '\n' +
                "--------------------\n" +
                " User ID: '" + userID + '\n' +
                "--------------------\n" +
                " Rent date: " + rentDate + '\n' +
                "--------------------\n" +
                " Return date: " + returnDate + '\n' +
                "--------------------\n";
    }
}
