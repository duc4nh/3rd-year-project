package simulator;

import java.util.Random;

import object.Cat;
import object.Environment;
import object.InteractionObject;

public class Simulator {

	public static int random() {
		Random random = new Random();
		return random.nextInt(3) - 1;
	}

	public static void simulation(Cat cat, Environment environment,
			InteractionObject object) {

		// emotion change figures
		int excited = 0;
		int fearful = 0;
		int relieved = 0;
		int angry = 0;

		// FROM ENVIRONTMENT
		if (environment.getTemperature() == 1) { // hot
			angry += random() + 1;
			excited += random() - 1;
			relieved += random() - 1;
		} else if (environment.getTemperature() == -1) { // cold
			excited += random() - 2;
		} else { // neutral
			excited += random() + 1;
			relieved += random() + 1;
		}
		if (environment.getHumidity() == 1) { // humid
			relieved += random() - 1;
		} else { // dry
			relieved += random() + 1;
		}
		if (environment.getNoise() == 1) { // noisy
			angry += random();
			excited -= random();
		} else { // normal
			relieved += random();
			angry -= random();
		}

		// FROM INTERACTION OBJECT
		excited += random() + object.getExcited();
		fearful += random() + object.getFearful();
		relieved += random() + object.getRelieved();
		angry += random() + object.getAngry();

		// new emotion set
		cat.getEmotion().emoChange(excited, fearful, relieved, angry);

		// OUTPUT RESULT
		System.out.println("-------------------------------");
		System.out.println("RESULT: When \"" + cat.getName() + "\" see \""
				+ object.getName() + "\" in \"" + environment.getName()
				+ "\"...");
		int[] emoChange = { excited, fearful, relieved, angry };
		simulationEmoResult(emoChange);
		printStatus(cat);
	}

	// EMOTION RESULT
	public static void simulationEmoResult(int[] emo) {

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
			// -3] [-2 -1] 0 [1 2] [3
			if (emo[i] < -2)
				System.out.println("It feels much less " + emoType + " ("
						+ emo[i] + ")");
			else if (emo[i] < 0)
				System.out.println("It feels a bit less " + emoType + " ("
						+ emo[i] + ")");
			else if (emo[i] != 0 && emo[i] < 3)
				System.out.println("It feels a bit more " + emoType + " ("
						+ emo[i] + ")");
			else if (emo[i] > 2)
				System.out.println("It feels much more " + emoType + " ("
						+ emo[i] + ")");
		}

	}
	
	public static void simulationActResult() {
		
	}

	public static void printStatus(Cat cat) {
		System.out.println("-------------------------------");
		System.out.println("CURRENT CAT STATUS:");
		System.out.println(cat.getName() + ", Age: " + cat.getAge());
		System.out.println("Emotion: ");

		int[] emo = cat.getEmotion().getEmo();
		if (emo[0] < 2 && emo[1] < 2 && emo[2] < 2 && emo[3] < 2) {
			System.out
					.println("The cat's emotion is neutral, it doesnt feel anything.");
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
				// [-5 -4] [-3 -2] [-1 0 1] [2 3] [4 5]
				if (emo[i] < -3) {
					System.out.println("The cat does not feel " + emoType
							+ " at all!! (" + emo[i] + ")");
				} else if (emo[i] < -1) {
					System.out.println("The cat is not " + emoType + "...("
							+ emo[i] + ")");
				} else if (emo[i] > 1 && emo[i] < 4) {
					System.out.println("The cat feels little " + emoType
							+ "...(" + emo[i] + ")");
				} else if (emo[i] > 3) {
					System.out.println("The cat feels extremely " + emoType
							+ "!! (" + emo[i] + ")");
				}
			}
		}
	}

}
