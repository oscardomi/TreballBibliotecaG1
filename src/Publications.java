import java.util.Scanner;

public class Publications {

        private String ID;
        private String name;
        private String gender;
        private String type;
        private int quantity;


        //Constructors

        public Publications(String ID, String name, String gender, String type, int quantity) {
            this.ID = ID;
            this.name = name;
            this.gender = gender;
            this.type = type;
            this.quantity = 1;
        }

        public Publications(){
            this.ID = ID;
            this.name = name;
            this.gender = gender;
            this.type = type;
            this.quantity = 1;
        }

        //Getters and Setters


        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        //Metods

        public static Publications addPublication(){
            Scanner sc = new Scanner(System.in);

            System.out.println("Write the name of the publication u want to add: ");
            String ID = sc.nextLine();

            System.out.println("Write the name of the publication ");
            String name = sc.nextLine();

            System.out.println("Write the gender of the publication ");
            String gender = sc.nextLine();

            System.out.println("Write the type of the publication: ");
            String type = sc.nextLine();

            return new Publications(ID, name, gender, type);
        }

        @Override
        public String toString() {
            return "Publication " +
                    "ID='" + ID + '\'' +
                    ", name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", type='" + type + '\'';
        }
    }
