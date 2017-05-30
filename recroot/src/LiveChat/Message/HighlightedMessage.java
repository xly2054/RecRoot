package LiveChat.Message;

/**
 * One of message decorate, highlighting message
 */
public class HighlightedMessage extends MessageDecorator {
    public HighlightedMessage (Message MessageDecorator) {
        super(MessageDecorator);
    }

    @Override
    public String getMessage() {
        return hightlightMessage();
    }

    private String hightlightMessage() {
        return "[Highlighted]" + super.getMessage() + "[Highlighted]";
    }
}
