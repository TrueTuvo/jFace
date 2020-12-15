package jface.model;

import java.util.List;

/**
 * 
 * @author SZabara
 * model provider basis on the list of persons
 */
public enum ModelProvider {
    INSTANCE;

    private List<Person> persons;

    private ModelProvider() {
        persons = DataManager.readPersons();
    }
    
    public List<Person> getPersons() {
        return persons;
    }

}
