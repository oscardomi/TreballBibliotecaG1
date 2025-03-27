import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Rent r = new Rent();




        User.addUser();
        Publications.addPublication();

        System.out.println(User.userList.get(0));
        System.out.println(Publications.publicationsList.get(0));

    }
}