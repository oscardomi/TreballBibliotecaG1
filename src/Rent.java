import java.util.Date;

public class Rent {
    private String ID;
    private User rentUser;
    private Date rentDate;
    private Date returnDate;


    //Constructor
    public Rent(String ID, User rentUser, Date rentDate, Date returnDate) {
        this.ID = ID;
        this.rentUser = rentUser;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Rent() {
        this.ID = "";
        this.rentUser = null;
        this.rentDate = null;
        this.returnDate = null;
    }


    //Getters
    public String getID() {
        return ID;
    }

    public User getRentUser() {
        return rentUser;
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

    public void setRentUser(User rentUser) {
        this.rentUser = rentUser;
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
                " User: '" + rentUser.getUserName() + '\n' +
                "--------------------\n" +
                " Rent date: " + rentDate + '\n' +
                "--------------------\n" +
                " Return date: " + returnDate + '\n' +
                "--------------------\n";
    }
}
