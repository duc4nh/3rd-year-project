package object;

import java.io.Serializable;

public class Cat implements Serializable
{

    private String name;
    private String breed;
    // private int age;
    private Emotion emotion;

    // TODO habits/memory

    public Cat(String name, String breed, Emotion emotion)
    {
        this.name = name;
        this.breed = breed;
        this.emotion = emotion;
    }

    // GETTERS
    public String getName()
    {
        return name;
    }

    public String getBreed()
    {
        return breed;
    }

    /*
     * public int getAge() { return age; }
     */

    public int[] getEmotion()
    {
        return emotion.getEmo();
    }

    public void setEmotion(int[] emo)
    {
        emotion.setEmo(emo);
    }

    public void printStatusTest()
    {
        int[] emo = emotion.getEmo();

        System.out.print("CAT.STATUS: ");
        System.out.print("Excited:" + emo[0]);
        System.out.print("Fearful:" + emo[1]);
        System.out.print("Relieved:" + emo[2]);
        System.out.println("Angry:" + emo[3]);
    }

    public void printStatus()
    {
        System.out.println("-------------------------------");
        System.out.println("CURRENT CAT STATUS:");
        System.out.println("Name: " + getName());
        System.out.println("Breed: " + getBreed());
        System.out.println("Emotion: ");

        int[] emo = getEmotion();
        if (emo[0] < 4 && emo[0] > -4 && emo[1] < 4 && emo[1] > -4
                && emo[2] < 4 && emo[2] > -4 && emo[3] < 4 && emo[3] > -4)
        {
            System.out.println("The cat's emotion is neutral");
        } else
        {
            for (int i = 0; i < 4; i++)
            {
                String emoType;
                switch (i)
                {
                    case 0:
                        emoType = "excited";
                        break;
                    case 1:
                        emoType = "fearful";
                        break;
                    case 2:
                        emoType = "relieved";
                        break;
                    default:
                        emoType = "angry";
                        break;
                }
                // [-10 -8] [-7 -4] [-3 0 3] [4 7] [8 10]
                if (emo[i] < -7)
                {
                    System.out.println("The cat does not feel " + emoType
                            + " at all!! (" + emo[i] + ")");
                } else if (emo[i] < -3)
                {
                    System.out.println("The cat is not " + emoType + "...("
                            + emo[i] + ")");
                } else if (emo[i] > 3 && emo[i] < 8)
                {
                    System.out.println("The cat feels little " + emoType
                            + "...(" + emo[i] + ")");
                } else if (emo[i] > 7)
                {
                    System.out.println("The cat feels extremely " + emoType
                            + "!! (" + emo[i] + ")");
                }
            }
        }
    }

    public String printStatusGUI()
    {
        String s = "";

        s += "Name: " + getName() + "\n" + "Breed: " + getBreed()
                + "\nEmotion:\n";

        int[] emo = getEmotion();
        if (emo[0] < 4 && emo[0] > -4 && emo[1] < 4 && emo[1] > -4
                && emo[2] < 4 && emo[2] > -4 && emo[3] < 4 && emo[3] > -4)
        {
            s += "The cat's emotion is neutral";
        } else
        {
            for (int i = 0; i < 4; i++)
            {
                String emoType;
                switch (i)
                {
                    case 0:
                        emoType = "excited";
                        break;
                    case 1:
                        emoType = "fearful";
                        break;
                    case 2:
                        emoType = "relieved";
                        break;
                    default:
                        emoType = "angry";
                        break;
                }
                // [-10 -8] [-7 -4] [-3 0 3] [4 7] [8 10]
                if (emo[i] < -7)
                {
                    s += "The cat does not feel " + emoType + " at all!! ("
                            + emo[i] + ")\n";
                } else if (emo[i] < -3)
                {
                    s += "The cat is not " + emoType + "...(" + emo[i] + ")\n";
                } else if (emo[i] > 3 && emo[i] < 8)
                {
                    s += "The cat feels little " + emoType + "...(" + emo[i]
                            + ")\n";
                } else if (emo[i] > 7)
                {
                    s += "The cat feels extremely " + emoType + "!! (" + emo[i]
                            + ")\n";
                }
            }
        }

        return s;
    }
}
