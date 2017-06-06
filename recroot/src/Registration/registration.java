package Registration;
import User.*;
import java.util.Scanner;

/**
 * registration class to register new user
 */

public class registration {

    private User State;

    public registration(Student student){
        this.State = student;
    }

    public registration(Professor professor){
        this.State = professor;
    }

    public registration(Adviser adviser){
        this.State = adviser;
    }

    public void addUser(){
        Scanner scanner = new Scanner(System.in);
        if(State.Username != "") {
            System.out.println("Please create a username");
            State.Username = scanner.nextLine();
        }

        if(State.Password != "") {
            System.out.println("Please create a password");
            State.Password = scanner.nextLine();
        }

        if(State.Name != "") {
            System.out.println("Please enter your name");
            State.Name = scanner.nextLine();
        }

        if(State.Email != "") {
            System.out.println("Please enter your age");
            State.Email = scanner.nextLine();
        }

        return;
    }

    public boolean validateUser(){
        if(this.State.Password.length() <=8){
            this.State.Password = "";
            saveUserToMemento();
            return false;
        }
        return true;
    }

    public registrationMemento saveUserToMemento() {
        System.out.println("Saving to Memento.");
        return new registrationMemento(this.State);
    }

    public void restoreFromMemento(registrationMemento memento) {
        this.State = memento.getSavedState();
    }
}

