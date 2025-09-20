package cat;

public class Parser {

    public static String analyse(String userInput){

        try {
            String output = "";

            assert userInput != null : "User input cannot be null";
            Exception.checkEmptyInput(userInput);
            //output += Ui.showInput(userInput);

            int last = userInput.charAt(userInput.length() - 1);
            int num = last - '0';

            String[] parts = userInput.split("/");

            if (userInput.equals("list")) {
                output += Meow.printAll();
            } else if (userInput.equals("bye")) {
                output += Ui.showBye();
            }
            else if(userInput.contains("unmark")) {
                Meow.tasks.get(num - 1).setUnDone();
                output += Meow.printAll();
            }else if(userInput.contains("mark")) {
                Meow.tasks.get(num - 1).setDone();
                output += Meow.printAll();
            }else if(userInput.contains("delete")){
                Meow.tasks.remove(num - 1);
                output += Meow.printAll();
            }else if(userInput.contains("todo")) {
                String name = userInput.substring(4).trim();
                Todo todo = new Todo(name);
                Meow.tasks.add(todo);
                output += Meow.printAll();
            }else if(userInput.contains("deadline")) {
                String name = parts[0].substring(8).trim();
                String endDate = parts[1].trim();
                Deadline deadline = new Deadline(name, endDate);
                Meow.tasks.add(deadline);
                output += Meow.printAll();
            } else if(userInput.contains("event")) {
                String name = parts[0].substring(5).trim();
                String startDate = parts[1].trim();
                String endDate = parts[2].trim();
                Event event = new Event(name, startDate, endDate);
                Meow.tasks.add(event);
                output += Meow.printAll();
            }else if(userInput.contains("find")) {
                String keyword = userInput.substring(4).trim();
                output += Meow.find(keyword);
            } else{
                output += Ui.inValidInput();
            }

            return output;


        } catch (Exception e) {
            //System.out.println("OOPS! " + e.getMessage());
            //String exc = "OOPS! " + e.getMessage();
            return "OOPS! " + e.getMessage();
        }

    }

}
