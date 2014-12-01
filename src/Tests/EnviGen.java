package Tests;

import database.CatDatabase;
import database.EnvironmentDatabase;
import database.EnvironmentDatabase;
import object.Cat;
import object.Emotion;
import object.Environment;
import simulator.Simulator;

public class EnviGen
{

    public static void main(String[] args)
    {
        EnvironmentDatabase.openDatabase();

        Environment[] envi = new Environment[7];
        envi[0] = new Environment("Neutral environment", 0, 0, 0, 0);
        envi[1] = new Environment("Very Cold & Dark room", 0, 0, 0, 0);
        envi[2] = new Environment("Warm comfort place", 0, 0, 0, 0);
        envi[3] = new Environment("Construction Area", 0, 0, 0, 0);
        envi[4] = new Environment("Summer yard", 0, 0, 0, 0);
        envi[5] = new Environment("Winter yard", 0, 0, 0, 0);
        envi[6] = new Environment("Kitchen", 0, 0, 0, 0);

        for (Environment bh : envi)
        {
            EnvironmentDatabase.add(bh);
        }

        //EnvironmentDatabase.close();
        EnvironmentDatabase.printAllDetails();
    }
}