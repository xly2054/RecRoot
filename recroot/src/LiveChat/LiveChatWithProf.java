package LiveChat;

import User.*;


/**
 * One of the live chat type for factory
 */
public class LiveChatWithProf extends LiveChat {

    public void connectUser(){
        Professor p = getAvailableProfessor();
        Users.add(p);
        ChatName = "Chat with " + p.Name;
    }

    /**
     * This method should poll database to retrieve all available professors
     * However we assigned one here in the absence of backend.
     * @return an available professor
     */
    public Professor getAvailableProfessor(){
        Professor p = new Professor("Prof. Demo","132","pd","123","123","test");
        return p;
    }
}
