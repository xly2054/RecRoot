package User;
import Database.*;
import LiveChat.*;

/**
 * User class, basic user type. All other different types of user are subclass of this
 */
public abstract class User {
    public String Name;
    public String SSN;
    public String Username;
    public String Password;
    public String Email;

    private LiveChat liveChat;

    public User(String Name, String SSN, String Username, String Password, String Email){
        this.Name = Name;
        this.SSN = SSN;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
    }

    public String getName(){
        return this.Name;
    }

    public String getSSN(){
        return this.SSN;
    }

    public String getEmail(){
        return this.Email;
    }

    public User getUser(String username){
        return this;
    }

    public Boolean isExisted(){
        return Database.checkUser(this.Username);
    }

    public void sendMessage(Message message) {
        liveChat.postMessage(this.Username,message);
    }

    public LiveChat getLiveChat() {return liveChat;}

    public abstract void receiveMessage(Message message);
}
