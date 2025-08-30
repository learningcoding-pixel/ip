import java.util.Scanner;  // Import the Scanner class

public class Meow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String[] userInputs = new String[100]; //Create fixed sized array of 100 to store items
        int counter = 0;
        String greet = "Hello! I am Meow. ᓚᘏᗢ\n"
                     + "What can I do for you?\n";
        String ask = "Enter any input for me to record down\n"
                   + "or <list> to show all your recorded inputs\n"
                   + "or <bye> to exit.";
        String bye = "Bye. Hope to see you again soon with Chicken Cat Treats ᓚᘏᗢ\n";

        System.out.println(greet);
        System.out.println(ask);
        String userInput = scanner.nextLine();  // Read user input

        while(!userInput.equals("bye")){

            if (userInput.equals("list")){
                for(int i = 0; i < counter; i++){
                    System.out.println((i + 1) + ": " + userInputs[i]);
                }
            }else{
                System.out.println("Recorded: " + userInput);
                userInputs[counter] = userInput;
                counter += 1;
            }

            System.out.println();
            System.out.println(ask);
            userInput = scanner.nextLine();
        }

        scanner.close();//close scanner
        System.out.println(bye);
    }
}
