package com.jface.zabara.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jface.zabara.app.Utils;

/**
 * 
 * @author SZabara model provider basis on two things: the list of persons and text file
 */
public enum ModelProvider {
    INSTANCE;

    private List<Person> persons;

    private ModelProvider() {
        persons = readPersonsFromFile();
    }

    public List<Person> getPersons() {
        return persons;
    }

    private List<Person> readPersonsFromFile() {

        List<Person> persons = new ArrayList<Person>();
        File file = new File(Utils.FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Failed to create the DATABASE file");
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while (br.ready()) {
                String text = br.readLine();
                String parts[] = text.split(",");
                Person person = new Person(parts[0], Integer.parseInt(parts[1]), Boolean.parseBoolean(parts[2]));
                persons.add(person);
            }
        } catch (FileNotFoundException exception) {
            System.err.println("Сould not find the DATABASE file");
        } catch (IOException e) {
            System.err.println("Сould not read the DATABASE file");
        }
        return persons;
    }
}
