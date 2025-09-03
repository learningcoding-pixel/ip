package cat;

import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;

public class Meow {

    public static void printAll(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getStatus());
        }
    }


    public static void main(String[] args) {

        Dataloader dataloader = new Dataloader();  // Create a dataloader object
        TaskSaver tasksaver = new TaskSaver();
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object


        ArrayList<Task> tasks = new ArrayList<>();
        tasks = dataloader.getTasks();


        Ui.showWelcome();
        Ui.showAsk();
        String userInput = scanner.nextLine();  // Read user input





        while(!userInput.equals("bye")){

            char last;
            int num;
            String name;

            try {
                Exception.checkEmptyInput(userInput);
                System.out.println("You entered: " + userInput);

                last = userInput.charAt(userInput.length() - 1);
                num = last - '0';


                if (userInput.equals("list")) {
                    printAll(tasks);
                }else if(userInput.contains("unmark")) {
                    tasks.get(num - 1).setUnDone();
                    printAll(tasks);
                }else if(userInput.contains("mark")) {
                    tasks.get(num - 1).setDone();
                    printAll(tasks);
                }else if(userInput.contains("delete")){
                    tasks.remove(num - 1);
                    printAll(tasks);
                }else if(userInput.contains("todo")) {
                    name = userInput.substring(5);
                    Todo todo = new Todo(name);
                    tasks.add(todo);
                    printAll(tasks);
                }else if(userInput.contains("deadline")) {
                    int index = userInput.indexOf('/');
                    name = userInput.substring(9, index);
                    String endDate = userInput.substring(index + 1);
                    Deadline deadline = new Deadline(name, endDate);
                    tasks.add(deadline);
                    printAll(tasks);
                } else if(userInput.contains("event")){
                    int index = userInput.indexOf('/');
                    int lastIndex = userInput.lastIndexOf('/');
                    name =  userInput.substring(5,index);
                    String startDate = userInput.substring(index + 1,lastIndex);
                    String endDate = userInput.substring(lastIndex + 1);
                    Event event = new Event(name,startDate,endDate);
                    tasks.add(event);
                    printAll(tasks);
                }else{
                    System.out.println("Recorded: " + userInput);
                    Task task = new Task(userInput);
                    tasks.add(task);
                }


            } catch (Exception e) {
                System.out.println("OOPS! " + e.getMessage());
            }

            tasksaver.save(tasks);

            System.out.println();
            Ui.showAsk();
            userInput = scanner.nextLine();
        }

        scanner.close();//close scanner
        Ui.showBye();
    }




}
