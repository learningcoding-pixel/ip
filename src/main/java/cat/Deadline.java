package cat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Deadline extends Todo{

    protected LocalDateTime endDate; // converted date-time object



    public Deadline(String name,String endDate){
        super(name);

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        LocalDateTime localdatetime = LocalDateTime.parse(endDate, inputFormatter);

        this.endDate = localdatetime;

    }

    @Override
    public String getStatus(){
        String stat=  isDone ? "[X]" : "[ ]";
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        return "[D]" + stat + " " + name + " " + endDate.format(outputFormatter);
    }

    @Override
    public String getFormat(){
        String d=  isDone ? "1" : "0";
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        return "D" + " | " + d + " | " + name + " | " + endDate.format(outputFormatter);
    }

}
