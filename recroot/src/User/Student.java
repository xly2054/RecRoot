package User;
import LiveChat.Message.Message;

/**
 * Student class, student is a subclass of user
 */
public class Student extends User {
    public double GPA;

    public Student(String Name,String SSN,String Username, String Password, String Email, double GPA) {
        super(Name,SSN,Username,Password,Email);
        this.GPA = GPA;
    }

    public double getGPA(){
        return this.GPA;
    }

    public void receiveMessage(Message message){
        System.out.println(message.getMessage());
    }
}
