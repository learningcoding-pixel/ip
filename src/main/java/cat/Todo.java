package cat;

public class Todo extends Task {

    public Todo(String name){
        super(name);
    }

    @Override
    public String getStatus(){
        String stat=  isDone ? "[X]" : "[ ]";
        return "[T]" + stat + " " + name;
    }


    @Override
    public String getFormat(){
        String d=  isDone ? "1" : "0";
        return "T" + " | " + d + " | " + name;
    }
}
