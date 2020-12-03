package jface.model;

public class Person {
    private String name;
    private int group;
    private boolean swtDone;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        this.group = group;
    }
    public boolean isSwtDone() {
        return swtDone;
    }
    public void setSwtDone(boolean swtDone) {
        this.swtDone = swtDone;
    }
    public Person(String name, int group, boolean swtDone) {
        super();
        this.name = name;
        this.group = group;
        this.swtDone = swtDone;
    }
    
    

}
