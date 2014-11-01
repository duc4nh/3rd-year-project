package simulator;

import java.util.List;
import java.util.Random;

import database.BehaviourDatabase;
import object.Behaviour;
import object.Cat;
import object.Environment;
import object.Interaction;

public class Simulator {

	//
	public static int random() {
		Random random = new Random();
		return random.nextInt(3) - 1; //return -1, 0 or 1
	}

	public static void simulation(Cat cat, Environment environment,
			Interaction interaction) {

		// run simulation
		int[] emoChange = simulationEmo(environment, interaction);
		// new emotion set
		cat.setEmotion(emoChange);
		// appropriate behaviour chosen
		Behaviour act = simulationBeha(cat, interaction);

		// OUTPUT EMOTION RESULT
		System.out.println("-------------------------------");
		System.out.println("RESULT: When \"" + cat.getName() + "\" see \""
				+ interaction.getName() + "\" in \"" + environment.getName()
				+ "\"...");
		simulationEmoResult(emoChange);

		// OUTPUT BEHAVIOUR
		System.out.println("-------------------------------");
		System.out.println("BEHAVIOUR: " + act.getName());
	}

	public static int[] simulationEmo(Environment environment,
			Interaction interaction) {
		// emotion change figures
				int excited = 0;
				int fearful = 0;
				int relieved = 0;
				int angry = 0;

				// FROM ENVIRONTMENT
					// temperature
				if (environment.getTemperature() > 1) { // hot and warm
					excited += random();
					fearful += random();
					relieved += random() + 1;
					angry += random();
				} else if (environment.getTemperature() > -3) { // normal or a bit cold
					excited += random();
					fearful += random();
					relieved += random();
					angry += random();
				} else { // too cold
					excited += random() - 1;
					fearful += random() + 1;
					relieved += random() - 1;
					angry += random() + 1;
				}
				
				// humidity
				if (environment.getHumidity() > 2) { // too humid
					excited += random() - 1;
					fearful += random() + 1;
					relieved += random() - 1;
					angry += random() + 1;
				} else { // normal or dry
					excited += random();
					fearful += random();
					relieved += random();
					angry += random();
				}
				
				//light: it seems that cat is not affected much whether its dark or light
				
				//noise
				if (environment.getNoise() > 2) { // too noisy
					excited += random() - 1;
					fearful += random() + 1;
					relieved += random() - 1;
					angry += random() + 1;
				} else { // normal or quite
					excited += random();
					fearful += random();
					relieved += random() + 1;
					angry += random();
				}

				// FROM INTERACTION interaction
				excited += random() + interaction.getExcited();
				fearful += random() + interaction.getFearful();
				relieved += random() + interaction.getRelieved();
				angry += random() + interaction.getAngry();

				int[] emoChange = { excited, fearful, relieved, angry };
				
				return emoChange;
	}
	
	// PRINT EMOTION RESULT
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
	
	public static Behaviour simulationBeha(Cat cat,	Interaction interaction) {
		int[] emo = cat.getEmotion();
		List<Behaviour> behaviourDatabase = BehaviourDatabase.getList();
		Behaviour[] candidates = new Behaviour[3];
		double[] candidateScores = {-80, -80, -80}; // -80 is minimum score
		
		// choose 3 best appropriate behaviours
		for (Behaviour behaviour : behaviourDatabase) {
			if (behaviour.getCate() == interaction.getCate()) {
				if (behaviour.getScore(emo) > candidateScores[0]) {
					candidateScores[2] = candidateScores[1];
					candidates[2] = candidates[1];
					candidateScores[1] = candidateScores[0];
					candidates[1] = candidates[0];
					candidateScores[0] = behaviour.getScore(emo);
					candidates[0] = behaviour;
				}
				else if (behaviour.getScore(emo) > candidateScores[1]) {
					candidateScores[2] = candidateScores[1];
					candidates[2] = candidates[1];
					candidateScores[1] = behaviour.getScore(emo);
					candidates[1] = behaviour;
				}
				else if (behaviour.getScore(emo) > candidateScores[2]) {
					candidateScores[2] = behaviour.getScore(emo);
					candidates[2] = behaviour;
				}
			}
		}
		
		// 1 behaviour is chosen by probability: 50% 30% 20%
		Behaviour chosenBehaviour;
		double random = Math.random();
		if (random < 0.6) chosenBehaviour = candidates[0];
		else if (random < 0.9) chosenBehaviour = candidates[1];
		else chosenBehaviour = candidates[2];
		
		return chosenBehaviour;
	}

	public static void printStatus(Cat cat) {
		System.out.println("-------------------------------");
		System.out.println("CURRENT CAT STATUS:");
		System.out.println(cat.getName() + ", Age: " + cat.getAge());
		System.out.println("Emotion: ");

		int[] emo = cat.getEmotion();
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
