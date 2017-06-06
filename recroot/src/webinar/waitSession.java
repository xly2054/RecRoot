package webinar;

/**
 * State of wait session while host is not yet available
 */
public class waitSession implements Session {

    public waitSession(){}

    @Override
    public void displayWebinar(final Webinar context, final String host) {
        System.out.println("In waiting session, host has not started the webinar yet");

        while(!WebinarPage.isHostJoined(host)){
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        context.setState(new chatSession());
    }
}
