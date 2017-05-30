package LiveChat.Message;

/**
 * One of message decorate, coloring message
 */
public class ColoredMessage extends MessageDecorator {
    public ColoredMessage (Message MessageDecorator) {
        super(MessageDecorator);
    }

    @Override
    public String getMessage() {
        return coloredMessage();
    }

    private String coloredMessage() {
        return "[Colored]" + super.getMessage() + "[Colored]";
    }
}
