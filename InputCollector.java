import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public  abstract class  InputCollector {
    public static String nS;
    protected static String mobileS;
    protected static String workS;
    protected static String homeS;
    protected static String formatedM;
    protected static String formatedH;
    protected static String formatedW;
    protected static String cityS;
    protected static String rvContact;
    protected static String udContact;
    protected static String nameS;

    public static String getUserInput() {
        boolean checkValue = false;
        while (checkValue == false) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your option:");
            String nS;
            nS = input.next();
            boolean isNumeric =  nS.matches("[+-]?\\d*(\\.\\d+)?");
            if (nS.equalsIgnoreCase("quit") || nS.equals("5")) {
                System.out.println("Bye!");
                break;
            }
            else if (isNumeric == true) {
                int n ;
                n = Integer.parseInt(nS);
                if (n >= 1 && n <= 5) {
                    //return nS;
                    switch (n) {
                        case (1):
                            ContactList.displayAll();
                            Mainmenu.Mainmenu();
                            break;
                        case (2):
                            optionTwo();
                            break;
                        case (3):
                            optionThree();
                            break;
                        case (4):
                            optionFour();
                            break;
                    }
                }
                else{
                    System.out.println("Invalid Input. Enter number between 1 and 5.");
                }
            }
            else {
                System.out.println("Invalid Input. Enter number between 1 and 5.");
            }
            } return "";
    }
        public static String optionTwo() {
        Scanner input = new Scanner(System.in);
        nameS="";
        mobileS="";
        workS="";
        homeS="";
        cityS="";
        formatedM="";
        formatedW="";
        formatedH="";
        boolean checkEmpty1 = true;
        boolean checkEmpty2 = true;

        while (checkEmpty1 == true) {
            System.out.println("Enter name");
            nameS = input.nextLine();
            if (nameS == null || nameS.isEmpty() || (nameS.length()>0 && (nameS.trim().isEmpty()))) {
                System.out.println("You must enter this field.");
            }
            else {
                checkEmpty1 = false;
            }
        }
       while (checkEmpty2 == true) {
           System.out.println("Enter mobile");
           mobileS = input.nextLine();

           if (mobileS == null || mobileS.isEmpty() || (mobileS.length() > 0 && (mobileS.trim().isEmpty()))) {
               System.out.println("You must enter this field.");
           }
           else if (mobileS.length() != 10 ) {System.out.println("Invalid Input. Enter phone number (10 digits).");}
           else {
               checkEmpty2 = false;
           }
       }
            boolean checkValueW = false;
            while (checkValueW == false) {
                System.out.println("Enter work");
                workS = input.nextLine();
                boolean isNumericW = workS.matches("[+-]?\\d*(\\.\\d+)?");
                if (workS.isEmpty()) {
                    checkValueW = true;
                    break;}
                else if (isNumericW == false) {System.out.println("Invalid Input. Enter Numbers!");}
                else if (workS.length() != 10 ) {System.out.println("Invalid Input. Enter phone number (10 digits).");}
                else {
                    checkValueW = true;
                    break;
                }
            }

            boolean checkValueH = false;
            while (checkValueH == false) {
                System.out.println("Enter home");
                homeS = input.nextLine();
                boolean isNumericH = homeS.matches("[+-]?\\d*(\\.\\d+)?");
                if (homeS.isEmpty()) {
                    checkValueH = true;
                    break;}
                else if (isNumericH == false) {System.out.println("Invalid Input. Enter Numbers!");}
                else if (homeS.length() != 10 ) {System.out.println("Invalid Input. Enter phone number (10 digits).");}
                else {
                    checkValueH = true;
                    break;
                }
            }
        System.out.println("Enter city");
        cityS = input.nextLine();
       ArrayList<String> nameData = new ArrayList<>();
       ArrayList<String> mobileData = new ArrayList<>();
       ArrayList<String> workData = new ArrayList<>();
       ArrayList<String> homeData = new ArrayList<>();
       ArrayList<String> cityData = new ArrayList<>();

       nameData.add(nameS);
       formatedM = mobileS.substring(0, 3) + "-"
                    + mobileS.substring(3, 6) + "-"
                    + mobileS.substring(6, 10);
       mobileData.add(formatedM);
       if (workS.isEmpty()) { formatedW = workS; }
       else {
            formatedW = workS.substring(0, 3) + "-"
                    + workS.substring(3, 6) + "-"
                    + workS.substring(6, 10);}
       workData.add(formatedW);
       if (homeS.isEmpty()) { formatedH = homeS; }
       else {
            formatedH = homeS.substring(0, 3) + "-"
                    +homeS.substring(3, 6) + "-"
                    + homeS.substring(6, 10);}
       homeData.add(formatedH);
       cityData.add(cityS);
       System.out.println("Successfully added a new contact!");
       ContactList ContactList = new ContactList();
       ContactList.addContact();
       Mainmenu.Mainmenu();
       return "";
    }

    public  static String optionOne() {
        //System.out.println("is 1");
        String nS="5";
        return nS;
    }

    public static String optionThree() {
        ContactList.displayAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the index of Contact to remove:");
        rvContact = input.nextLine();
        ContactList ContactList = new ContactList();
        ContactList.removeContact();
        Mainmenu.Mainmenu();
        return "";
    }

    public static String optionFour() {
        ContactList.displayAll();
        ContactList ContactList = new ContactList();
        ContactList.updateContact();
        return "";
    }
}





