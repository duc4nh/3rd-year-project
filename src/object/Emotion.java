package object;

/**
 * Each cat will have 'an Emotion'
 *
 * @author DucAnh
 */
public class Emotion {
	// Emotion figures of the cat: -10 to 10
	private int excited;
	private int fearful;
	private int relieved;
	private int angry;

	public Emotion(int excited, int fearful, int relieved, int angry) {
		this.excited = excited;
		this.fearful = fearful;
		this.relieved = relieved;
		this.angry = angry;
	}

	public Emotion() {
		excited = fearful = relieved = angry = 0;
	}

	public void updateEmo(int[] emo) {
		excited += emo[0];
		fearful += emo[1];
		relieved += emo[2];
		angry += emo[3];

		// set range -10 to 10
		if (excited < -10)
			excited = -10;
		if (fearful < -10)
			fearful = -10;
		if (relieved < -10)
			relieved = -10;
		if (angry < -10)
			angry = -10;
		if (excited > 10)
			excited = 10;
		if (fearful > 10)
			fearful = 10;
		if (relieved > 10)
			relieved = 10;
		if (angry > 10)
			angry = 10;

	}

	public void setEmo(int a, int b, int c, int d) {
		excited = a;
		fearful = b;
		relieved = c;
		angry = d;

		// set range -10 to 10
		if (excited < -10)
			excited = -10;
		if (fearful < -10)
			fearful = -10;
		if (relieved < -10)
			relieved = -10;
		if (angry < -10)
			angry = -10;
		if (excited > 10)
			excited = 10;
		if (fearful > 10)
			fearful = 10;
		if (relieved > 10)
			relieved = 10;
		if (angry > 10)
			angry = 10;
	}

	public int[] getEmo() {
		return new int[]{excited, fearful, relieved, angry};
	}
}