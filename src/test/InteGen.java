package test;

import object.Interaction;
import object.InteractionCategory;
import database.EnvironmentDatabase;
import database.InteractionDatabase;

public class InteGen
{

    public static void main(String[] args)
    {
        //InteractionDatabase.openDatabase();

        Interaction[] inte = new Interaction[20];
        inte[0] = new Interaction(1, "Big angry dog", InteractionCategory.ANIMAL, -2, 4 ,-4, 3);
        inte[1] = new Interaction(2, "Mouse", InteractionCategory.ANIMAL, 3,-1,1,-1);
        inte[2] = new Interaction(3, "Gecko", InteractionCategory.ANIMAL, -1,2,-1,2);
        inte[3] = new Interaction(4, "Cockroach", InteractionCategory.ANIMAL, 2,1,-1,-1);
        inte[4] = new Interaction(5, "Fish with Rice", InteractionCategory.FOOD, 3,-1,2,-2);
        inte[5] = new Interaction(6, "Milk", InteractionCategory.FOOD, 2,-1,2,-1);
        inte[6] = new Interaction(7, "His owner", InteractionCategory.HUMAN, 3,-1,3,-1);
        inte[7] = new Interaction(8, "Stranger", InteractionCategory.HUMAN, -1,2,0,2);
        inte[8] = new Interaction(9, "Wool ball", InteractionCategory.OBJECT, 3,-3,4,-2);
        inte[9] = new Interaction(10, "Cat Scratcher", InteractionCategory.OBJECT, 4,-2,3,0);
        inte[10] = new Interaction(11, "Sofa", InteractionCategory.OBJECT, 1,-1,2,-2);
        inte[11] = new Interaction(12, "Nylon Bag", InteractionCategory.OBJECT, 3,-2,3,-1);
        inte[12] = new Interaction(13, "Vegetable", InteractionCategory.FOOD, -1,1,0,2);
        inte[13] = new Interaction(14, "Meat", InteractionCategory.FOOD, 1,0,2,-2);
        inte[14] = new Interaction(15, "Whiskas (cat food)", InteractionCategory.FOOD, 2,-1,1,-2);
        inte[15] = new Interaction(16, "Laptop", InteractionCategory.OBJECT, -2,-2,1,0);
        inte[16] = new Interaction(17, "Bag", InteractionCategory.OBJECT, -2,1,-1,0);
        inte[17] = new Interaction(18, "Little dog", InteractionCategory.ANIMAL, -1,2,-2,1);
        inte[18] = new Interaction(19, "Little kitten", InteractionCategory.ANIMAL, 2,1,2,1);
        inte[19] = new Interaction(20, "Fox", InteractionCategory.ANIMAL, 2,2,-2,2);

        for (Interaction bh : inte)
        {
            InteractionDatabase.add(bh);
        }

        InteractionDatabase.printAllDetails();
        System.out.println("Size: " + InteractionDatabase.getSize());
        InteractionDatabase.save();
    }
}