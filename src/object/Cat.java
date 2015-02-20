package object;

import java.io.Serializable;

/**
 * A cat
 *
 * @author DucAnh
 */
public class Cat implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String breed;
	// private int age;
	private Emotion emotion;

	// TODO habits/memory

	public Cat(String name, String breed, Emotion emotion) {
		this.name = name;
		this.breed = breed;
		this.emotion = emotion;
	}

	// GETTERS
	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public int[] getEmotion() {
		return emotion.getEmo();
	}

	public void updateEmotion(int[] emo) {
		emotion.updateEmo(emo);
	}

	public void setEmotion(int a, int b, int c, int d) {
		emotion.setEmo(a, b, c, d);
	}

	public void printStatusTest() {
		int[] emo = emotion.getEmo();

		System.out.print("CAT.STATUS: ");
		System.out.print("Excited:" + emo[0]);
		System.out.print("Fearful:" + emo[1]);
		System.out.print("Relieved:" + emo[2]);
		System.out.println("Angry:" + emo[3]);
	}

	public void printStatus() {
		System.out.println("-------------------------------");
		System.out.println("CURRENT CAT STATUS:");
		System.out.println("Name: " + getName());
		System.out.println("Breed: " + getBreed());
		System.out.println("Emotion: ");

		int[] emo = getEmotion();
		if (emo[0] < 4 && emo[0] > -4 && emo[1] < 4 && emo[1] > -4 && emo[2] < 4 && emo[2] > -4 && emo[3] < 4 && emo[3] > -4) {
			System.out.println("The cat's emotion is neutral");
		} else {
			for (int i = 0; i < 4; i++) {
				String emoType;
				switch (i) {
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
				if (emo[i] < -7) {
					System.out.println("The cat does not feel " + emoType + " at all!! (" + emo[i] + ")");
				} else if (emo[i] < -3) {
					System.out.println("The cat is not " + emoType + "...(" + emo[i] + ")");
				} else if (emo[i] > 3 && emo[i] < 8) {
					System.out.println("The cat feels little " + emoType + "...(" + emo[i] + ")");
				} else if (emo[i] > 7) {
					System.out.println("The cat feels extremely " + emoType + "!! (" + emo[i] + ")");
				}
			}
		}
	}

	public String printStatusGUI() {
		String s = "";
		s += "Name: " + getName() + "\n" + "Breed: " + getBreed() + "\nEmotion:\n";

		int[] emo = getEmotion();
		if (emo[0] < 4 && emo[0] > -4 && emo[1] < 4 && emo[1] > -4 && emo[2] < 4 && emo[2] > -4 && emo[3] < 4 && emo[3] > -4) {
			s += "The cat's emotion is neutral\n";
		}
		s += statusDisplay("Excited", emo[0]);
		s += statusDisplay("Fearful", emo[1]);
		s += statusDisplay("Relieved", emo[2]);
		s += statusDisplay("Angry", emo[3]);
		return s;
	}

	private String statusDisplay(String name, int n) {
		String s = name + ":\t|";
		for (int i = -5; i <= 5; i++) {
			if (i <= n)
				s += "*";
		}
		s += "\n";
		return s;
	}

	public int getImageNo() {
		int[] emo = getEmotion();
		if (emo[0] < 4 && emo[0] > -4 && emo[1] < 4 && emo[1] > -4 && emo[2] < 4 && emo[2] > -4 && emo[3] < 4 && emo[3] > -4) {
			return 0;
		}

		int[][] picScore = {{}, {2, 1, 1, 1}, {1, 2, 1, 1}, {1, 3, 0, 1}, {1, 1, 2, 1}, {1, 1, 1, 2}, {1, 2, 0, 2}, {0, 1, 1, 3}, {0, 2, 0, 2}};
		int picID = 0;
		int maxScore = -2147483648;
		for (int i = 1; i < picScore.length; i++) {
			int score = picScore[i][0] * emo[0] + picScore[i][1] * emo[1] + picScore[i][2] * emo[2] + picScore[i][3] * emo[3];
			if (score > maxScore) {
				picID = i;
				maxScore = score;
			}
		}

		return picID;
	}
}
