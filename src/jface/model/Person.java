package jface.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
    private String name;
    private int group;
    private boolean swtDone;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
            this);
    
    public void addPropertyChangeListener(String propertyName,
            PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        propertyChangeSupport.firePropertyChange("name", this.name,
                this.name = name);
    }
    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        propertyChangeSupport.firePropertyChange("group", this.group,
                this.group = group);
    }
    public boolean isSwtDone() {
        return swtDone;
    }
    public void setSwtDone(boolean swtDone) {
        propertyChangeSupport.firePropertyChange("swtDone", this.swtDone,
                this.swtDone = swtDone);
    }
    public Person(String name, int group, boolean swtDone) {
        super();
        this.name = name;
        this.group = group;
        this.swtDone = swtDone;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + group;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (swtDone ? 1231 : 1237);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (group != other.group)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (swtDone != other.swtDone)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", group=" + group + ", swtDone=" + swtDone + "]";
    }
    
    

}
