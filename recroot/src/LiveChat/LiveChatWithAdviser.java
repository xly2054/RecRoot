package LiveChat;

import User.Adviser;

/**
 * Chat type with Adviser for factory
 */
public class LiveChatWithAdviser extends LiveChat {
    public void connectUser(){
        Adviser adv = getAvailableAdviser();
        Users.add(adv);
        ChatName = "Chat with " + adv.Name;
    }

    /**
     * This method should poll database to retrieve all available Advisers
     * However we assigned one here in the absence of backend.
     * @return an available Adviser
     */
    public Adviser getAvailableAdviser(){
        Adviser adv = new Adviser("Adviser Demo","132","pd","123","123","test");
        return adv;
    }
}
