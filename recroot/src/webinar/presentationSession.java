package webinar;

/**
 * Presentation Session when host started to screen share
 */
public class presentationSession implements Session {

    public presentationSession(){}

    @Override
    public void displayWebinar(final Webinar context, final String host) {
        System.out.println("In Presentation Session");
        if (context.isPresenting){
            context.setState(new chatSession());
        }
        return;
    }
}
