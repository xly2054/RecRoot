/**
 * Partial Main Menu/User interface implementation
 */
import java.util.*;
public class MainMenu {
    public static boolean loginPage(){
        boolean isLoggedIn = false;

        System.out.println("Welcome to RecRoot");
        while(!isLoggedIn){
            System.out.println("Please enter 1 for register new account");
            System.out.println("Please enter 2 to login with existing account");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input == "1") {
                if (signup()) {
                    return true;
                }
            }else if (input == "2") {
                if (login()) {
                    return true;
                }
            }
            System.out.println("Invalid input, please retry");
        }
        return false;
    }

    public static boolean login(){

        return true;
    }

    public static boolean signup(){

        return true;
    }

    public static void menu(){

    }

    public static void main(String[] args){
        if(loginPage()) {
            menu();
        }
    }
}
