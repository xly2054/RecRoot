/**
 * Partial Main Menu/User interface implementation
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import Registration.*;
import Database.H2DbConnection;
import Database.dao.UserDAO;
import Discussion.*;
import LiveChat.LiveChat;
import LiveChat.LiveChatPage;
import User.*;
import LiveChat.Message.*;


public class MainMenu {
    public static boolean loginPage(){
        boolean isLoggedIn = false;

        System.out.println("Welcome to RecRoot");
        while(!isLoggedIn){
            System.out.println("Please enter 1 for register new account");
            System.out.println("Please enter 2 to login with existing account");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input == "1") {
                if (signup()) {
                    return true;
                }
            }else if (input == "2") {
                if (login()) {
                    return true;
                }
            }
            System.out.println("Invalid input, please retry");
        }
        return false;
    }

    public static boolean login(){

        return true;
    }

    public static boolean signup(){

        return true;
    }

    public static void menu(){

    }

    public static void main(String[] args){

        //Creating new students for testing
        //If student declared here has missing information, it will be prompted for console input
        Student s1 = new Student("TestUser1","123-321-111","TestUser1","12345678","abc@123.com",1.0);
        Student s2 = new Student("TestUser2","123-321-112","TestUser2","12345678","abc@123.com",2.0);
        Student s3 = new Student("TestUser3","123-321-113","TestUser3","12345678","abc@123.com",3.0);
        Student s4 = new Student("TestUser4","123-321-114","TestUser4","12345678","abc@123.com",4.0);

        //register students, if all information checked out ok, they will be stored to database
        registration r1 = new registration(s1);
        r1.addUser();
        registration r2 = new registration(s2);
        r2.addUser();
        registration r3 = new registration(s3);
        r3.addUser();
        registration r4 = new registration(s4);
        r4.addUser();

        //populate in-memory database
        try {
            H2DbConnection.populate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //print all students
        /*
        try {
            new UserDAO(H2DbConnection.dbConnection).getStudents().stream()
                    .forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        //search for student Jack
        try {
            Student s = new UserDAO(H2DbConnection.dbConnection).getStudent("TestUser1");
            System.out.println("Student found: " + s.getName() + " " + s.getEmail() + " " + s.getGPA());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        Usage for previous assignment

        if(loginPage()) {
            menu();
        }

        //Creating new student for testing
        Student s = new Student("TestUser","123","tu","123","abc@123.com",3.0);

        //Calling Singleton static method to retrieve discussion board instance
        DiscussionBoard db = DiscussionBoard.getInstance();

        String Topic = "test Topic";
        String ThreadSubject = "test Thread";
        String Body = "test Body";

        db.newThread(Topic,ThreadSubject,s.Username,Body);
        //implementation of reply Thread adapted prototype design pattern
        db.replyThread(Topic,ThreadSubject,"Adviser A","Welcome!");

        //verify topics
        db.listThread();

        //verify threads
        Discussion d = db.getDiscussion(Topic);
        Threads t = d.getThread(ThreadSubject);
        t.printThread();

        //Connecting current Student to a chat session with Professor via factor design pattern
        LiveChatPage lcp = new LiveChatPage();
        LiveChat lc = lcp.createNewChat("PROFESSOR");
        lc.addUser(s);
        lc.connectUser();

        //Validate chat
        lc.PrintChat();

        //Sending Message with Decorator design pattern
        String Message = "Hello World";
        Message m = new SimpleMessage();
        m.setMessage(Message);
        System.out.println(m.getMessage());

        //Validating decorators
        m = new HighlightedMessage(m);
        m.setMessage(Message);
        System.out.println(m.getMessage());

        m = new ColoredMessage(m);
        m.setMessage(Message);
        System.out.println(m.getMessage());
*/
    }
}
