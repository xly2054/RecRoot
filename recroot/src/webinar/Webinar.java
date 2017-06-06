package webinar;

/**
 * Webinar is the context object in the State pattern, where is have 3 different states
 */
public class Webinar {
    public String host;
    public boolean isPresenting = false;
    private Session SessionState;

    /**
     * Start session without host
     */
    Webinar() {
        setState(new waitSession());
    }

    /**
     * Start session by host
     */
    Webinar(String host){
        setState(new chatSession());
    }

    /**
     * Setter method for the state.
     */
    void setState(final Session newState) {
        SessionState = newState;
    }

    public void displaySession(final String name) {
        SessionState.displayWebinar(this, name);
    }

    /**
     * Trigger to change state
     */
    public void startPresenting(){
        this.isPresenting = true;
    }

    /**
     *  Trigger to change state
     */
    public void stopPresenting(){
        this.isPresenting = false;
    }
}
