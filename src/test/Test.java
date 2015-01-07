package test;

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
        String selected = "1. klsfhsdalkfhdsa";

        String[] a = selected.split("\\.");
        
        System.out.println(a[0]);
        //System.out.println(Integer.parseInt (selected.split(".")[1]));
    }
}
