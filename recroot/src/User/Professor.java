package User;

import LiveChat.Message.Message;

/**
 * Professor user type
 */
public class Professor extends User {
    public String Department;

    public Professor(String Name, String SSN, String Username, String Password, String Email, String Department) {
        super(Name,SSN,Username,Password,Email);
        this.Department = Department;
    }

    public String getDepartment(){
        return this.Department;
    }

    public void receiveMessage(Message message){
        System.out.println(message.getMessage());
    }
}
