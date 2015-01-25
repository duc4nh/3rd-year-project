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
		this.excited = this.fearful = this.relieved = this.angry = 0;
	}

	public void updateEmo(int[] emo) {
		this.excited += emo[0];
		this.fearful += emo[1];
		this.relieved += emo[2];
		this.angry += emo[3];

		// set range -10 to 10
		if (this.excited < -10)
			this.excited = -10;
		if (this.fearful < -10)
			this.fearful = -10;
		if (this.relieved < -10)
			this.relieved = -10;
		if (this.angry < -10)
			this.angry = -10;
		if (this.excited > 10)
			this.excited = 10;
		if (this.fearful > 10)
			this.fearful = 10;
		if (this.relieved > 10)
			this.relieved = 10;
		if (this.angry > 10)
			this.angry = 10;

	}

	public void setEmo(int a, int b, int c, int d) {
		this.excited = a;
		this.fearful = b;
		this.relieved = c;
		this.angry = d;

		// set range -10 to 10
		if (this.excited < -10)
			this.excited = -10;
		if (this.fearful < -10)
			this.fearful = -10;
		if (this.relieved < -10)
			this.relieved = -10;
		if (this.angry < -10)
			this.angry = -10;
		if (this.excited > 10)
			this.excited = 10;
		if (this.fearful > 10)
			this.fearful = 10;
		if (this.relieved > 10)
			this.relieved = 10;
		if (this.angry > 10)
			this.angry = 10;
	}

	public int[] getEmo() {
		int[] emo = {excited, fearful, relieved, angry};
		return emo;
	}
}