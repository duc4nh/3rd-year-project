package subPrograms;

import database.BehaviourDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;
import object.Behaviour;
import object.Cat;
import object.Emotion;
import simulator.Simulator;

public class Statistic
{
    public static void main(String[] args)
    {
        EnvironmentDatabase.openDatabase();
        InteractionDatabase.openDatabase();
        BehaviourDatabase.openDatabase();
        
        System.out.println("START");
        
        int[] list = new int[58];
        int count = 0;
        int iteration = 1;
        
        for (int cc = 0; cc<iteration; cc++)
            for (int i = 1; i<=EnvironmentDatabase.getSize(); i++)
                for (int j = 1; j<=InteractionDatabase.getSize(); j++)
                {
                    Cat cat = new Cat("Tom", "Common Domestic Cat", new Emotion(0, 0, 0, 0));
                    int[] emoChange = Simulator.simulationEmo(EnvironmentDatabase.get(i), InteractionDatabase.get(j));

                    cat.setEmotion(emoChange);
                    Behaviour act = Simulator.chooseBehaviour(cat, InteractionDatabase.get(j));
                    System.out.println(BehaviourDatabase.get(i).getName());
                    list[act.getId()]++;
                    count++;
                }
        
        for (int i = 1; i <= 58; i++)
        {
            double por = list[i]/count*100;
            System.out.println(i + ". " + BehaviourDatabase.get(i).getName() + " : " + por + "%");
        }
        
        System.out.println("END");
    }
}
