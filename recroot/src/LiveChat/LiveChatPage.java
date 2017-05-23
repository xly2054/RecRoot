package LiveChat;
import User.*;
import java.util.*;

/**
 * LiveChat interface class, LiveChat is one of the mediator that handles communication between different types of users
 */
public abstract class LiveChatPage {
    ArrayList<LiveChat> chatList;

    public ArrayList<LiveChat> listChats(){
        return chatList;
    }

    public abstract LiveChat createNewChat(String chatName, String sessionID, User user);

    public abstract LiveChat joinLiveChat(User user);

    public abstract void leaveSession(User user);
}
