package LiveChat;
import java.util.*;

import LiveChat.Message.Message;
import User.*;

/**
 * Implementation of LiveChat factory
 */
public abstract class LiveChat extends LiveChatPage {
    public String ChatName;
    public ArrayList<User> Users = new ArrayList<User>();

    public void postMessage(String senderName,Message message) {
        for (User user : Users) {
            if (user.Username != senderName) {
                user.receiveMessage(message);
            }
        }
    }

    public void addUser(User User){
        Users.add(User);
    }

    public String getChatName(){
        return ChatName;
    }

    public void PrintChat(){
        System.out.println("Current Chat: " + getChatName());
        for (User u: Users) {
            System.out.println("Current User: " + u.getName());
        }
    }

    public abstract void connectUser();
}
