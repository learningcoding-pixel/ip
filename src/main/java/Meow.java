import java.util.Scanner;  // Import the Scanner class

public class Meow {

    public static void printAll(Task[] tasks, int counter){
        for (int i = 0; i < counter; i++) {
            System.out.println((i + 1) + ". " + tasks[i].getStatus());
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Task[] tasks = new Task[100]; //Create fixed sized array of 100 to store items
        int counter = 0;
        char last;
        int num;
        String name;
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

            last = userInput.charAt(userInput.length() - 1);
            num = last - '0';


            if (userInput.equals("list")) {
                printAll(tasks,counter);
            }else if(userInput.contains("unmark")) {
                tasks[num - 1].setUnDone();
                printAll(tasks,counter);
            }else if(userInput.contains("mark")){
                tasks[num - 1].setDone();
                printAll(tasks,counter);
            }else if(userInput.contains("todo")) {
                name = userInput.substring(5);
                Todo todo = new Todo(name);
                tasks[counter] = todo;
                counter += 1;
                printAll(tasks, counter);
            }else if(userInput.contains("deadline")) {
                int index = userInput.indexOf('/');
                name = userInput.substring(9, index);
                String endDate = userInput.substring(index + 1);
                Deadline deadline = new Deadline(name, endDate);
                tasks[counter] = deadline;
                counter += 1;
                printAll(tasks, counter);
            } else if(userInput.contains("event")){
                int index = userInput.indexOf('/');
                int lastIndex = userInput.lastIndexOf('/');
                name =  userInput.substring(5,index);
                String startDate = userInput.substring(index + 1,lastIndex);
                String endDate = userInput.substring(lastIndex + 1);
                Event event = new Event(name,startDate,endDate);
                tasks[counter] = event;
                counter += 1;
                printAll(tasks,counter);
            }else{
                System.out.println("Recorded: " + userInput);
                Task task = new Task(userInput);
                tasks[counter] = task;
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
