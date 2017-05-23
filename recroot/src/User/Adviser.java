package User;

import LiveChat.Message;

/**
 * Adviser class, Adviosr is a subclass of user
 */
public class Adviser extends User {
    public String Department;

    public Adviser(String Name, String SSN, String Username, String Password, String Email, String Department) {
        super(Name,SSN,Username,Password,Email);
        this.Department = Department;
    }

    public String getDepartment(){
        return this.Department;
    }

    public void receiveMessage(Message message){
        System.out.println(message.MessageBody);
    }
}
