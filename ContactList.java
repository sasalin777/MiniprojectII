import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public  class  ContactList  extends InputCollector  {

    protected static List<ContactList> contactListList = new ArrayList(Arrays.asList(
            new ContactList("Allen Henrie", "230-333-7777", "236-012-2337", "237-777-7777", "Victoria"),
            new ContactList("Berry Morrie", "237-000-7878"),
            new ContactList("Cherry Terry", "277-111-8888", "266-123-1233"),
            new ContactList("Dedien Alexi", "333-111-0707", "203-788-8877", "250-011-1238", "Vancouver"),
            new ContactList("Kevin Connie", "333-100-0707", "273-788-8077", "257-018-1688", "Tokyo")
    ));

    private String nameContact;
    private String mobileContact;
    private String workContact;
    private String homeContact;
    private String cityContact;
    public String rvContact;

    public ContactList() {
        this.nameContact = super.nameS;
        this.mobileContact = super.formatedM;
        this.workContact = super.formatedW;
        this.homeContact = super.formatedH;
        this.cityContact = super.cityS;
    }

    public ContactList(String nameContact, String mobileContact, String workContact, String homeContact, String cityContact) {
        this.nameContact = nameContact;
        this.mobileContact = mobileContact;
        this.workContact = workContact;
        this.homeContact = homeContact;
        this.cityContact = cityContact;
    }

    public ContactList(String nameContact, String mobileContact) {
        this.nameContact = nameContact;
        this.mobileContact = mobileContact;
        this.homeContact = "";
        this.workContact = "";
        this.cityContact = "";
    }

    public ContactList(String nameContact, String mobileContact, String workContact) {
        this.nameContact = nameContact;
        this.mobileContact = mobileContact;
        this.workContact = workContact;
        this.homeContact = "";
        this.cityContact = "";
    }

    public  String getNameContact() {
        return nameContact;
    }

    public void setNameContact(String nameContact) {
        this.nameContact = nameContact;
    }

    public String getMobileContact() {
        return mobileContact;
    }

    public void setMobileContact(String mobileContact) {
        this.mobileContact = mobileContact;
    }

    public String getWorkContact() {
        return workContact;
    }

    public void setWorkContact(String workContact) {
        this.workContact = workContact;
    }

    public String getHomeContact() {
        return homeContact;
    }

    public void setHomeContact(String homeContact) {
        this.homeContact = homeContact;
    }

    public String getCityContact() {
        return cityContact;
    }

    public void setCityContact(String cityContact) {
        this.cityContact = cityContact;
    }

    @Override
    public String toString() {
        return ". <" + getNameContact() + "> (mobile=" + getMobileContact()
                + ((getWorkContact() != "" & getWorkContact() != null & !(getWorkContact().isEmpty())) ? ", work=" + getWorkContact() : "")
                + ((getHomeContact() != "" & getHomeContact() != null & !(getHomeContact().isEmpty())) ? ", home=" + getHomeContact() : "")
                + ((getCityContact() != "" & getCityContact() != null & !(getCityContact().isEmpty())) ? ", city=" + getCityContact() : "")
                + ")";
    }

    public void addContact() {
        contactListList.add(new ContactList());
    }
    public void removeContact() {
        int removeInt = Integer.valueOf(super.rvContact);
        ContactList arr = contactListList.get(removeInt);
        System.out.printf("Successfully remove %s\n",arr.getNameContact());
        contactListList.remove(removeInt);
    }
    public void updateContact() {
        boolean checkValue = false;
        while (checkValue == false) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the index of Contact to update:");
            udContact = input.nextLine();
            int i = Integer.valueOf(udContact);
            if (i < 0 || i > contactListList.size()) {
                System.out.printf("Invalid Input. Enter number between 0 to %d.", (contactListList.size() - 1));
            }
            else {
                boolean checkEmpty1 = true;
                boolean checkEmpty2 = true;
                while (checkEmpty1 == true) {
                    System.out.println("Enter name:");
                    nameS = input.nextLine();
                    if (nameS == null || nameS.isEmpty() || (nameS.length()>0 && (nameS.trim().isEmpty()))) {
                        System.out.println("You must enter this field.");
                    } else {
                        checkEmpty1 = false;
                    }
                }
                while (checkEmpty2 == true) {
                    System.out.println("Enter mobile");
                    mobileS = input.nextLine();
                    boolean isNumericM = mobileS.matches("[+-]?\\d*(\\.\\d+)?");
                    if (mobileS == null || mobileS.isEmpty() || (mobileS.length() > 0 && (mobileS.trim().isEmpty()))) {
                        System.out.println("You must enter this field.");
                    }
                    else if (isNumericM == false) {System.out.println("Invalid Input. Enter Numbers!");}
                    else {
                        checkEmpty2 = false;
                    }
                }
                System.out.println("Enter work");
                workS = input.nextLine();
                System.out.println("Enter home");
                homeS = input.nextLine();
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
                contactListList.set (i, new ContactList(nameS,formatedM,formatedW,formatedH,cityS));
                Mainmenu.Mainmenu();
                getUserInput();
            }
        }
    }

    public static void displayAll() {
        int i;
            for (i = 0; i < contactListList.size(); i++) {
                System.out.printf("%d", i);
                contactListList.get(i);
                System.out.println(contactListList.get(i));
            }
        }
}

