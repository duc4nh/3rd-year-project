package object;

import java.io.Serializable;

public class Interaction implements Serializable
{

    private int id;
    private String name;
    private InteractionCategory category;
    // how cat's emotions are likely to be affected by this interaction: -5 to 5
    private int excited;
    private int fearful;
    private int relieved;
    private int angry;

    public Interaction(int id, String name, InteractionCategory category, int excited,
            int fearful, int relieved, int angry)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.excited = excited;
        this.fearful = fearful;
        this.relieved = relieved;
        this.angry = angry;
    }

    // GETTERS
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }

    public int getExcited()
    {
        return excited;
    }

    public int getFearful()
    {
        return fearful;
    }

    public int getRelieved()
    {
        return relieved;
    }

    public int getAngry()
    {
        return angry;
    }

    public InteractionCategory getCate()
    {
        return category;
    }

    public String infoGUI()
    {
        String s = "";
        s += "Name : " + name + "\nType : " + category + "\nExicted : "
                + excited + "\nFearful : " + fearful + "\nRelieved : "
                + relieved + "\nAngry : " + angry;
        return s;
    }

}
