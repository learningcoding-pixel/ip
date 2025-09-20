package cat;

public class Ui {
    public static String showWelcome() {
        return "Hello! I am your neighbourhood stray cat.\n"
                + "What can I do for you?\n";
    }

    public static String showAsk() {
        return "Enter your meows for me to record down\n"
                + "or <list> to show all your recorded inputs\n"
                + "or <find><inputkey> to find Tasks with inputkey \n"
                + "or <bye> to exit.";
    }

    public static String showBye() {
        return "Bye. Hope to see you again soon with Chicken Cat Treats\n";
    }

    public static String showInput(String userInput){
        return "You have Meowed: " + userInput + "\n";
    }

    public static String inValidInput(){
        return "Invalid Input\n";
    }


}
