package cat;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;


public class TaskSaver {


    String fileName = "meow.txt";

    public void save(ArrayList<Task> tasks) {

        try (FileWriter writer = new FileWriter(fileName)) {
            for (Task t : tasks) {
                writer.write(t.getFormat());
                writer.write("\n");
            }
            System.out.println("Tasks saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
