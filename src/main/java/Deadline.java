public class Deadline extends Todo{

    protected String endDate;

    public Deadline(String name,String endDate){
        super(name);
        this.endDate = endDate;
    }

    @Override
    public String getStatus(){
        String stat=  isDone ? "[X]" : "[ ]";
        return "[D]" + stat + " " + name + " " + endDate;
    }

    @Override
    public String getFormat(){
        String d=  isDone ? "1" : "0";
        return "D" + " | " + d + " | " + name + " | " + endDate;
    }

}
