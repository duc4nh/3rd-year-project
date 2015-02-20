package object;

/**
 * Each cat will have 'an Emotion'
 *
 * @author DucAnh
 */
public class Emotion {
	// Emotion figures of the cat: MIN to MAX
	private int excited;
	private int fearful;
	private int relieved;
	private int angry;
	private final int MAX = 10;
	private final int MIN = -10;

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

		// set range MIN to MAX
		if (excited < MIN)
			excited = MIN;
		if (fearful < MIN)
			fearful = MIN;
		if (relieved < MIN)
			relieved = MIN;
		if (angry < MIN)
			angry = MIN;
		if (excited > MAX)
			excited = MAX;
		if (fearful > MAX)
			fearful = MAX;
		if (relieved > MAX)
			relieved = MAX;
		if (angry > MAX)
			angry = MAX;

	}

	public void setEmo(int a, int b, int c, int d) {
		excited = a;
		fearful = b;
		relieved = c;
		angry = d;

		// set range MIN to MAX
		if (excited < MIN)
			excited = MIN;
		if (fearful < MIN)
			fearful = MIN;
		if (relieved < MIN)
			relieved = MIN;
		if (angry < MIN)
			angry = MIN;
		if (excited > MAX)
			excited = MAX;
		if (fearful > MAX)
			fearful = MAX;
		if (relieved > MAX)
			relieved = MAX;
		if (angry > MAX)
			angry = MAX;
	}

	public int[] getEmo() {
		return new int[]{excited, fearful, relieved, angry};
	}
}