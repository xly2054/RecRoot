package LiveChat.Message;

/**
 * Message Decorator interface
 */
public class MessageDecorator implements Message{
    protected String Message;
    protected Message DecoratedMessage;

    public MessageDecorator (Message DecoratedMessage) {
        this.DecoratedMessage = DecoratedMessage;
    }

    public void setMessage(String Message){
        this.Message = Message;
    }
    public String getMessage(){
        return this.Message;
    }
}
