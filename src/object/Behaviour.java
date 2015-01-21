package object;

import java.io.Serializable;

public class Behaviour implements Serializable
{
	/**
	 * 
	 */
    private static final long serialVersionUID = 5404601626573927512L;
	private int id;
    private String name;
    private InteractionCategory category;
    // factors: how likely cat'll do this with his current emotions: -5 to 5
    private int excited;
    private int fearful;
    private int relieved;
    private int angry;

    public Behaviour(int id, String name, InteractionCategory category, int excited,
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

    public int getScore(int[] emo)
    {
        return excited * emo[0] + fearful * emo[1] + relieved * emo[2] + angry
                * emo[3];
    }

}
