package Registration;
import Database.H2DbConnection;
import User.*;
import java.util.Scanner;

/**
 * registration class to register new user
 */

public class registration {

    private User State;
    private String type;
    private Double GPA;
    private String Department;

    public registration(Student student){
        this.State = student;
        this.type = "student";
        this.GPA = student.GPA;
    }

    public registration(Professor professor){
        this.State = professor;
        this.type = "professor";
        this.Department = professor.Department;
    }

    public registration(Adviser adviser){
        this.State = adviser;
        this.type = "adviser";
        this.Department = adviser.Department;
    }

    public void addUser(){
        Scanner scanner = new Scanner(System.in);

        if(this.type.equals("")) {
            System.out.println("Please enter user type, student, professor, or adviser");
            String type = scanner.nextLine();
        }

        if(State.Username.equals("")) {
            System.out.println("Please create a username");
            State.Username = scanner.nextLine();
        }

        if(State.Password.equals("")) {
            System.out.println("Please create a password longer than 8 characters");
            State.Password = scanner.nextLine();
        }

        if(State.Name.equals("")) {
            System.out.println("Please enter your name");
            State.Name = scanner.nextLine();
        }

        if(State.Email.equals("")) {
            System.out.println("Please enter your Email");
            State.Email = scanner.nextLine();
        }

        if(type.equals("student")){
            if(GPA==0) {
                System.out.println("Please enter your GPA");
                this.GPA = Double.parseDouble(scanner.nextLine());
            }
            Student u = new Student(State.Name,State.SSN,State.Username,State.Password,State.Email,GPA);
            this.State = u;
            registrationMemento memento = saveUserToMemento();
            if(validateUser()){
                H2DbConnection.addStudents(u);
                System.out.println("Validation passed, registered successfully");
            }else{
                restoreFromMemento(memento);
                retry();
            }
        }else if(type.equals("professor")){
            if(this.Department.equals("")) {
                System.out.println("Please enter your department");
                this.Department = scanner.nextLine();
            }
            Professor u = new Professor(State.Name,State.SSN,State.Username,State.Password,State.Email,Department);
            this.State = u;
            registrationMemento memento = saveUserToMemento();
            if(validateUser()){

            }else{
                restoreFromMemento(memento);
                retry();
            }
        }else if(type.equals("adviser")){
            if(this.Department.equals("")) {
                System.out.println("Please enter your department");
                this.Department = scanner.nextLine();
            }
            Adviser u = new Adviser(State.Name, State.SSN, State.Username, State.Password, State.Email, Department);
            this.State = u;
            registrationMemento memento = saveUserToMemento();
            if(validateUser()){

            }else{
                restoreFromMemento(memento);
                retry();
            }
        }else{
            retry();
        }
        return;
    }

    private boolean validateUser(){
        if(this.State.Password.length() <8){
            this.State.Password = "";
            saveUserToMemento();
            return false;
        }
        return true;
    }

    public registrationMemento saveUserToMemento() {
        //System.out.println("Saving to Memento.");
        return new registrationMemento(this.State);
    }

    public void restoreFromMemento(registrationMemento memento) {
        this.State = memento.getSavedState();
    }

    public void retry(){
        System.out.println("Validation failed, please retry");
        addUser();
    }
}

