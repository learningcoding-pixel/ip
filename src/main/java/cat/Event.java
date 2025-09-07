package cat;

/**
 * Represents an Event task, which is a type of Deadline with a specific start and end date.
 * Inherits from the Deadline class.
 */
public class Event extends Deadline{

    /** The start date of the event as a string. */
    protected String startDate;


    /**
     * Creates a new Event task with the given name, start date, and end date.
     *
     * @param name The name or description of the Event task.
     * @param startDate The start date of the event as a string (format as needed for display).
     * @param endDate The end date of the event as a string in the format "d/M/yyyy HHmm".
     */
    public Event(String name, String startDate, String endDate){
        super(name,endDate);
        this.startDate = startDate;
    }


    /**
     * Returns the status of the Event task as a formatted string.
     * Format: [E][status] name (Start: startDate) (End: endDate)
     * Example: [E][X] Meeting (Start: 01/09/2025 1400) (End: 01/09/2025 1600)
     *
     * @return A string representing the task's completion status along with start and end dates.
     */
    @Override
    public String getStatus(){
        String stat=  isDone ? "[X]" : "[ ]";
        return "[E]" + stat + " " + name + " " + "(Start: " + startDate + ") " + "(End:" + endDate + ")" ;
    }

    /**
     * Returns a formatted string for storing or saving the Event task.
     * Format: D | status | name | startDate | endDate
     * Status: "1" if done, "0" if not done
     *
     * @return A string representing the formatted Event task for storage.
     */
    @Override
    public String getFormat(){
        String d=  isDone ? "1" : "0";
        return "D" + " | " + d + " | " + name + " | " + startDate + " | " + endDate;
    }
}
