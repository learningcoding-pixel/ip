import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;


public class TaskSaver {


    String fileName = "meow.txt";
//    private ArrayList<Task> tasks;
//
//    public TaskSaver(ArrayList<Task> tasks){
//        this.tasks = new ArrayList<>();
//    }



    public void save(ArrayList<Task> tasks) {

//        for (Task t : tasks) {
//            if (t instanceof Todo) {
//                System.out.println("Todo: " + t.getStatus());
//            } else if (t instanceof Deadline) {
//                System.out.println("Deadline: " + t.getStatus());
//            } else if (t instanceof Event) {
//                System.out.println("Event: " + t.getStatus());
//            }
//        }
//        for (Task t : tasks) {
//            if (t instanceof Event) {
//                System.out.println("This is an Event: " + t.getStatus());
//            } else if (t instanceof Deadline) {
//                System.out.println("This is a Deadline: " + t.getStatus());
//            } else if (t instanceof Todo) {
//                System.out.println("This is a Todo: " + t.getStatus());
//            }
//        }

        try (FileWriter writer = new FileWriter(fileName)) {
            for (Task t : tasks) {
                writer.write(t.getFormat());
                writer.write("\n");
            }
            System.out.println("Characters saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
