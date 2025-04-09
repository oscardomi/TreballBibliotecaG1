package Users;

public class Librarian extends User{
    private String shift;
    private double salary;

    public Librarian(String userID, String userName, String userPassword, String shift, double salary) {
        super(userID, userName, userPassword);
        this.shift = shift;
        this.salary = salary;
    }

}
