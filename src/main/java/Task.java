public class Task {

    protected String name;
    protected Boolean isDone;

    public Task(String name){
        this.name = name;
        this.isDone = false;
    }

    public void setDone(){
        this.isDone = true;
    }

    public void setUnDone(){
        this.isDone = false;
    }

    public String getStatus(){
        return isDone ? "[X]" : "[ ]";
    }

    public String getFormat(){
        return "@Override";
    }

}
