package Main;

import Publication.Publication;
import Users.User;

import java.util.Date;

public class Lending {
    private String ID;
    private User lendingUser;
    private Publication lendingPublication;

    //todo fer que la data siguin Strings
    private Date lendingDate;
    private Date returnDate;


    //Constructor
    public Lending(String ID, User lendingUser, Publication lendingPublication, Date lendingDate, Date returnDate) {
        this.ID = ID;
        this.lendingUser = lendingUser;
        this.lendingPublication = lendingPublication;
        this.lendingDate = lendingDate;
        this.returnDate = returnDate;
    }
    public Lending() {
        this.ID = "";
        this.lendingUser = null;
        this.lendingPublication = null;
        this.lendingDate = null;
        this.returnDate = null;
    }

    //Getters and setters
    public String getID() {
        return ID;
    }
    public User getLendingUser() {
        return lendingUser;
    }
    public Date getLendingDate() {
        return lendingDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setLendingUser(User lendingUser) {
        this.lendingUser = lendingUser;
    }
    public void setLendingDate(Date lendingDate) {
        this.lendingDate = lendingDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public Publication getLendingPublication() {
        return lendingPublication;
    }
    public void setLendingPublication(Publication lendingPublication) {
        this.lendingPublication = lendingPublication;
    }

    //Override Method that shows the Main.Rent Information
    @Override
    public String toString() {
        Application.getUserList();
        return "===== Lending =====\n" +
                " ID: '" + ID + '\n' +
                "--------------------\n" +
                " User: '" + lendingUser.getUserName() + '\n' +
                "--------------------\n" +
                " Publication: '" + lendingPublication.getName() + '\n' +
                "--------------------\n" +
                " Lending date: " + lendingDate + '\n' +
                "--------------------\n" +
                " Return date: " + returnDate + '\n' +
                "--------------------\n";
    }
}
