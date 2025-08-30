public class Todo extends Task {

    public Todo(String name){
        super(name);
    }

    @Override
    public String getStatus(){
        String stat=  isDone ? "[X]" : "[ ]";
        return "[T]" + stat + " " + name;
    }
}
