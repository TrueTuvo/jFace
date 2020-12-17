package jface.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author SZabara model provider basis on two things: the list of persons and text file
 */
public enum ModelProvider {
    INSTANCE;

    private List<Person> persons;

    private static final String filepath = "database.txt";

    private ModelProvider() {
        persons = readPersonsFromFile();
    }

    public List<Person> getPersons() {
        return persons;
    }

    private List<Person> readPersonsFromFile() {

        List<Person> persons = new ArrayList<Person>();
        File file = new File(filepath);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while (br.ready()) {
                String text = br.readLine();
                String parts[] = text.split(",");
                Person person = new Person(parts[0], Integer.parseInt(parts[1]), Boolean.parseBoolean(parts[2]));
                persons.add(person);
            }
        } catch (Exception ex) {

        }
        return persons;
    }
}