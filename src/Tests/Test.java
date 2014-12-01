package Tests;

import java.util.Random;

import object.Cat;
import object.Emotion;
import simulator.Simulator;
import database.BehaviourDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;

public class Test
{

    public static void main(String[] args)
    {
        /*
         * Random random = new Random(); System.out.print(random.nextInt(3));
         */
     
        /*
        // open all database
        EnvironmentDatabase.openDatabase();
        InteractionDatabase.openDatabase();
        BehaviourDatabase.openDatabase();
        
        Cat cat = new Cat("Tom", "Common Domestic Cat", new Emotion(0, 0,
                0, 0));
        int enviID = 1;
        int inteID = 1;
        
        String[] s = Simulator.simulationResultGUI(cat,
                EnvironmentDatabase.get(enviID),
                InteractionDatabase.get(inteID));

        System.out.print(s[0] + s[1] + s[2]);
        */
    }
}
