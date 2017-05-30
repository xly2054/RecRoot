package LiveChat;
import User.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * LiveChat interface class, LiveChat is one of the mediator that handles communication between different types of users
 */
public class LiveChatPage {
    String SessionID;

    public LiveChatPage(){
        this.SessionID = setSessionID();
    }

    public LiveChat createNewChat(String targetUserGroup){
        if(targetUserGroup == null){
            return null;
        }
        if(targetUserGroup.equalsIgnoreCase("PROFESSOR")) {
            return new LiveChatWithProf();
        }
        else if(targetUserGroup.equalsIgnoreCase("ADVISER")){
            return new LiveChatWithAdviser();
        }
        return null;
    }

    private String setSessionID(){
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getSessionID(){
        return SessionID;
    }
}
