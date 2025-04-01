import Users.User;

import java.util.Date;

public class Rent {
    private String ID;
    private User rentUser;
    private Publication rentPublication;

    //todo fer que la data siguin Strings
    private Date rentDate;
    private Date returnDate;


    //Constructor
    public Rent(String ID, User rentUser, Publication rentPublication, Date rentDate, Date returnDate) {
        this.ID = ID;
        this.rentUser = rentUser;
        this.rentPublication = rentPublication;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Rent() {
        this.ID = "";
        this.rentUser = null;
        this.rentPublication = null;
        this.rentDate = null;
        this.returnDate = null;
    }


    //Getters and setters
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
    public Publication getRentPublication() {
        return rentPublication;
    }
    public void setRentPublication(Publication rentPublication) {
        this.rentPublication = rentPublication;
    }

    //Override Method that shows the Rent Information
    @Override
    public String toString() {
        return "===== Rent =====\n" +
                " ID: '" + ID + '\n' +
                "--------------------\n" +
                " Users.User: '" + rentUser.getUserName() + '\n' +
                "--------------------\n" +
                " Publication: '" + rentPublication.getName() + '\n' +
                "--------------------\n" +
                " Rent date: " + rentDate + '\n' +
                "--------------------\n" +
                " Return date: " + returnDate + '\n' +
                "--------------------\n";
    }
}
