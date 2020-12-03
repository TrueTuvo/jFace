package jface.model;

import java.util.ArrayList;
import java.util.List;

public enum ModelProvider {
    INSTANCE;

    private List<Person> persons;

    private ModelProvider() {
        persons = new ArrayList<Person>();
        // Image here some fancy database access to read the persons and to
        // put them into the model
        persons.add(new Person("Вася", 1, true));
        persons.add(new Person("Петя", 2, false));
        persons.add(new Person("Толик", 2, false));

    }

    public List<Person> getPersons() {
        return persons;
    }

}
