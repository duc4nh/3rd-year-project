package Tests;

import database.CatDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;
import object.Cat;
import object.Emotion;
import object.Interaction;
import object.InteractionCategory;
import simulator.Simulator;

public class InteGen
{

    public static void main(String[] args)
    {
        Emotion emo = new Emotion(-10, 5, 7, 8);
        Cat cat = new Cat("Tom", "Common Domestic Cat", emo);
        // cat.printStatus();
        InteractionDatabase.openDatabase();

        Interaction[] inte = new Interaction[11];
        inte[0] = new Interaction("Wool Ball", InteractionCategory.OBJECT, 1,
                -1, 2, -1);
        inte[1] = new Interaction("Angry dog", InteractionCategory.ANIMAL, -2,
                2, -2, 2);
        inte[2] = new Interaction("His owner", InteractionCategory.OBJECT, 0,
                0, 0, 0);
        inte[3] = new Interaction("The Stranger", InteractionCategory.OBJECT,
                0, 0, 0, 0);
        inte[4] = new Interaction("Mouse", InteractionCategory.ANIMAL, 0, 0, 0,
                0);

        inte[5] = new Interaction("Cat Scratcher", InteractionCategory.OBJECT,
                0, 0, 0, 0);
        inte[6] = new Interaction("The Sofa", InteractionCategory.OBJECT, 0, 0,
                0, 0);
        inte[7] = new Interaction("Gecko", InteractionCategory.ANIMAL, 0, 0, 0,
                0);
        inte[8] = new Interaction("Cockroach", InteractionCategory.ANIMAL, 0,
                0, 0, 0);
        inte[9] = new Interaction("Fish with Rice", InteractionCategory.FOOD,
                0, 0, 0, 0);
        inte[10] = new Interaction("Milk", InteractionCategory.FOOD, 0, 0, 0, 0);

        for (Interaction bh : inte)
        {
            InteractionDatabase.add(bh);
        }

        // InteractionDatabase.close();
        InteractionDatabase.printAllDetails();
    }
}