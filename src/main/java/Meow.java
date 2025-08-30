import java.util.Scanner;  // Import the Scanner class

public class Meow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String greet = "Hello! I am Meow. ᓚᘏᗢ\n"
                     + "What can I do for you?\n";
        String ask = "Enter your input for me to Miaow back or enter bye to leave: ";
        String bye = "Bye. Hope to see you again soon with Chicken Cat Treats ᓚᘏᗢ\n";

        System.out.println(greet);
        System.out.println(ask);
        String userInput = scanner.nextLine();  // Read user input

        while(!userInput.equals("bye")){
            System.out.println(userInput);
            System.out.println(ask);
            userInput = scanner.nextLine();
        }

        scanner.close();//close scanner
        System.out.println(bye);
    }
}
