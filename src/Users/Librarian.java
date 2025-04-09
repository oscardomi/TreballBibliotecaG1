package Users;

public class Librarian extends User{
    private String schedule;
    private double salary;

    public Librarian(String userID, String userName, String userPassword, String schedule, double salary) {
        super(userID, userName, userPassword);
        this.schedule = schedule;
        this.salary = salary;
    }

}
