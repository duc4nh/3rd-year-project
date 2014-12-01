package database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import object.Behaviour;

public class BehaviourDatabase
{

    private static List<Behaviour> behaviourDatabase = new ArrayList<Behaviour>();

    public static void openDatabase()
    {
        // Wrap all in a try/catch block to trap I/O errors.
        try
        {
            // Open file to read from
            FileInputStream saveFile = new FileInputStream("behaviour.sav");
            // Create an ObjectInputStream to get objects from save file.
            ObjectInputStream restore = new ObjectInputStream(saveFile);
            // restore
            behaviourDatabase = (List<Behaviour>) restore.readObject();
            restore.close();
        } catch (Exception exc)
        {
            exc.printStackTrace(); // If there was an error, print the info.
        }
    }

    public static void printAllDetails()
    {
        int i = 1;
        System.out.println("BEHAVIOUR DATABASE: ");
        for (Behaviour behaviour : behaviourDatabase)
        {
            System.out.println(i + ". " + behaviour.getName() + "\t\t\t"
                    + behaviour.getExcited() + "\t" + behaviour.getFearful()
                    + "\t" + behaviour.getRelieved() + "\t"
                    + behaviour.getAngry());
            i++;
        }
    }

    public static Behaviour get(int id)
    {
        return behaviourDatabase.get(id - 1);
    }

    public static void add(Behaviour beha)
    {
        behaviourDatabase.add(beha);
    }

    public static void delete(int id)
    {
        behaviourDatabase.remove(id - 1);
    }

    public static void close()
    {
        try
        {
            // Open a file to write to
            FileOutputStream saveFile = new FileOutputStream("behaviour.sav");
            // Create an ObjectOutputStream to put objects into save file.
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(behaviourDatabase);
            // Close the file.
            save.close(); // This also closes saveFile.
        } catch (Exception exc)
        {
            exc.printStackTrace(); // If there was an error, print the info.
        }
    }

    public static List<Behaviour> getAll()
    {
        return behaviourDatabase;
    }

}
