package LiveChat;
import java.util.*;
import User.*;

/**
 * Implementation of LiveChat, each instance represents a liveChat session
 * This is also the implementation of Mediator
 */
public class LiveChat extends LiveChatPage {
    public String sessionID;
    public String ChatName;
    public ArrayList<User> Users;

    public LiveChat(String ChatName,String sessionID ){
        this.ChatName = ChatName;
        this.sessionID = sessionID;
    }

    public void postMessage(String senderName,Message message) {
        for (User user : Users) {
            if (user.Username != senderName) {
                user.receiveMessage(message);
            }
        }
    }

    public ArrayList<User> getUsers(){
        return this.Users;
    }

    public LiveChat createNewChat(String chatName, String sessionID, User user){
        LiveChat chat = new LiveChat(chatName,sessionID);
        chat.addUser(user);
        return chat;
    }

    public ArrayList<LiveChat> listChats(){
        ArrayList<LiveChat> chatList = new ArrayList<LiveChat>();
        return chatList;
    }

    public LiveChat getLiveChat(String ChatName){
        LiveChat chat = new LiveChat(ChatName,sessionID);
        return chat;
    }

    public LiveChat joinLiveChat(User user){
        LiveChat chat = getLiveChat(sessionID);
        chat.addUser(user);
        return chat;
    }

    public void addUser(User user){
        Users.add(user);
    }

    public void leaveSession(User user){
        Users.remove(user);
    }

}
