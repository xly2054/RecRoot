package Registration;

import User.User;

/**
 * registratoin memento to save registration state
 */
public class registrationMemento {
    private final User state;

    public registrationMemento(User stateToSave) {
        state = stateToSave;
    }

    public User getSavedState() {
        return state;
    }
}