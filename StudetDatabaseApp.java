import java.security.Principal;

/**
 * StudetDatabaseApp
 */
public class StudetDatabaseApp {

    public static void main(String args[]) {
        Student s1 = new Student("Arun", "9854346231");
        s1.setUserID();
        s1.enroll("IOC101");
        s1.enroll("TIC101");
        s1.enroll("MOP101");
        s1.setPhone("789859XXXX");
        s1.setCity("Dehradun");
        s1.setState("Uttarakhand");        

        s1.showCourses();
        s1.checkBalance();
        s1.pay(600);
        s1.checkBalance();

        System.out.println(s1.toString());
    }
}

class Student{
    private static int iD = 100;
    private String name;
    private String email;
    private String SSN;
    private String userID;
    private String courses = "";
    private double balance = 0;
    private String phone;
    private String city;
    private String state;
    private static final int costOfCourse = 800;
    
    Student(String name, String SSN) {
        iD++; //*
        this.name = name;
        this.SSN = SSN;
        setEmail();
        setUserID();
    }

    public void setEmail() {
        email = name.toLowerCase() + "." + iD + "@gmail.com"; //toLowercase() *
        System.out.println("Your emmail: " + email); //*
    }

    public void setUserID() {
        int random = (int)(Math.random() * (9000-1000+1)+1000);
        this.userID = iD + "" + random + "" + SSN.substring(SSN.length() - 4) + "";
        System.out.println("Your Account Number: " + userID);
    }

    public void enroll(String course) {
        this.courses = this.courses + "\n" + course;
        balance += costOfCourse;
    }

    public void checkBalance() {
        System.out.printf("Your Balance is " + balance+ " INR \n");
    }

    public void showCourses() {
        System.out.println(courses);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void pay(int amount) {
        System.out.println("You are requested to pay " + amount + " rupees");
        balance -= amount;
        // enroll();
    }

    @Override
    public String toString() {
        return "{\n\t[Name: " + name + "]\n\t" + "[Courses: " + courses + "]\n\t" + "[Balance: " + balance + "]\n}";
    }
}