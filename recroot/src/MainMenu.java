/**
 * Partial Main Menu/User interface implementation
 */
import java.util.Scanner;

import Discussion.*;
import LiveChat.LiveChat;
import LiveChat.LiveChatPage;
import LiveChat.Message.*;
import User.*;


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
        /*
        if(loginPage()) {
            menu();
        }*/

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

    }
}
