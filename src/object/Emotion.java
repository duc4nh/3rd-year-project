package object;

/*
 public enum Emotion {
 HAPPY, ANXIOUS, FEARFUL, FRUSTRATED, FOCUSED, RELIEVED, ANGRY, NEUTRAL
 } 

 public enum Emotion {
 EXCITED, FEARFUL, RELIEVED, ANGRY, NEUTRAL
 }
 */

public class Emotion {
	private int excited;
	private int fearful;
	private int relieved;
	private int angry;

	public Emotion(int excited_, int fearful_, int relieved_, int angry_) {
		excited = excited_;
		fearful = fearful_;
		relieved = relieved_;
		angry = angry_;
	}

	public void emoChange(int excited_, int fearful_, int relieved_, int angry_) {
		excited += excited_;
		fearful += fearful_;
		relieved += relieved_;
		angry += angry_;

		if (excited < -5)
			excited = -5;
		if (fearful < -5)
			fearful = -5;
		if (relieved < -5)
			relieved = -5;
		if (angry < -5)
			angry = -5;
		if (excited > 5)
			excited = 5;
		if (fearful > 5)
			fearful = 5;
		if (relieved > 5)
			relieved = 5;
		if (angry > 5)
			angry = 5;

	}

	public int[] getEmo() {
		int[] emo = { excited, fearful, relieved, angry };
		return emo;
	}
}