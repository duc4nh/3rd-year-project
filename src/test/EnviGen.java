package test;

import database.EnvironmentDatabase;
import object.Environment;

public class EnviGen
{
    public static void main(String[] args)
    {
        //EnvironmentDatabase.openDatabase();

        Environment[] envi = new Environment[10];
        envi[0] = new Environment(1, "Neutral environment", 0, 0, 0, 0);
        envi[1] = new Environment(2, "Very Cold & Dark room", -4, 0, -5, -3);
        envi[2] = new Environment(3, "Warm comfort place", 3, 2, 3 ,1);
        envi[3] = new Environment(4, "Construction Area", -2, 3 ,4, 5);
        envi[4] = new Environment(5, "Summer yard", 4, 3, 3, 2);
        envi[5] = new Environment(6, "Winter yard", -5, -2, 3, 2);
        envi[6] = new Environment(7, "Kitchen", 3, 3, 2, 0);
        envi[7] = new Environment(8, "On the balcony", -1, -1, 4, 3);
        envi[8] = new Environment(9, "On rooftop", -2, 1, 4, 2);
        envi[9] = new Environment(10, "Next to fireplace", 3, -2, 3, 0);

        for (Environment bh : envi)
        {
            EnvironmentDatabase.add(bh);
        }
        
        EnvironmentDatabase.printAllDetails();
        System.out.println("Size: " + EnvironmentDatabase.getSize());
        EnvironmentDatabase.save();
    }
}