package cat;

public class Event extends Deadline{

    protected String startDate;

    public Event(String name, String startDate, String endDate){
        super(name,endDate);
        this.startDate = startDate;
    }

    @Override
    public String getStatus(){
        String stat=  isDone ? "[X]" : "[ ]";
        return "[E]" + stat + " " + name + " " + "(Start: " + startDate + ") " + "(End:" + endDate + ")" ;
    }

    @Override
    public String getFormat(){
        String d=  isDone ? "1" : "0";
        return "D" + " | " + d + " | " + name + " | " + startDate + " | " + endDate;
    }
}
