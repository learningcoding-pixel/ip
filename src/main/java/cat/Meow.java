package cat;

import java.util.ArrayList;

public class Meow {

    public static ArrayList<Task> tasks = new ArrayList<>();

    public static String printAll() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(tasks.get(i).getStatus())
                    .append("\n");
        }
        return sb.toString();
    }

    public static String find(String keyword) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).name.contains(keyword)) {
                counter++;
                sb.append(counter)
                        .append(". ")
                        .append(tasks.get(i).getStatus())
                        .append("\n");
            }
        }
        return sb.toString();
    }


    public static String main(String userInput) {
        String output = "";
        Dataloader dataloader = new Dataloader();  // Create a dataloader object
        TaskSaver tasksaver = new TaskSaver();
        tasks = dataloader.getTasks();

        if (!userInput.equals("bye") && !userInput.trim().isEmpty()) {
            output += Parser.analyse(userInput);
        }
        tasksaver.save(tasks);

        output += Ui.showAsk();
        return output;
    }




}
