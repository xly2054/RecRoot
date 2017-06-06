package webinar;

/**
 * Default session when session started by host
 */
public class chatSession implements Session {

    public chatSession(){}

    @Override
    public void displayWebinar(final Webinar context, final String host) {

        System.out.println("In Chat Session");
        if (context.isPresenting){
            context.setState(new presentationSession());
        }
        return;
    }
}
