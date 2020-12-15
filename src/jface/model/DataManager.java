package jface.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.internal.Model;


public class DataManager {

    private static final String filepath = "database.txt";

    public static void writeObjectToFile(Person person) {

        try {
            FileWriter tfw = new FileWriter(new File("database.txt").getAbsoluteFile(), true); 
            BufferedWriter tbw = new BufferedWriter(tfw);
            tbw.write(person.getName() + "," + person.getGroup() + "," + person.isSwtDone());
            tbw.newLine();
            tbw.flush();
            tbw.close();
            
            MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Information", "done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void removeObjectFromFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void updateObjectInTheFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static List<Person> readPersons() {

        List<Person> persons = new ArrayList<Person>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            
            while (br.ready()) {
                String text = br.readLine();
                String parts[] = text.split(",");
                Person person = new Person(parts[0],
                    Integer.parseInt(parts[1]),
                    Boolean.parseBoolean(parts[2]));
                persons.add(person);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return persons;
    }
}
