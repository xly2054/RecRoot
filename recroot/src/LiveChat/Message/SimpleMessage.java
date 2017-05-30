package LiveChat.Message;

/**
 * Simple Message with no decorate
 */
public class SimpleMessage implements Message {

    private String Message = "";

    public void setMessage(String Message){
        this.Message = Message;
    }
    public String getMessage(){
        return this.Message;
    }
}
