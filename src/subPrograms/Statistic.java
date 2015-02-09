package subPrograms;

import database.BehaviourDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;
import object.Behaviour;
import object.Cat;
import object.Emotion;
import simulator.Simulator;

import java.util.Random;

/**
 * Print probabilities that each behaviour is performed. Not for user.
 *
 * @author DucAnh
 */
public class Statistic {
	private static int random() {
		Random random = new Random();
		return random.nextInt(21) - 10; // return -10 -> 10
	}

	public static void main(String[] args) {
		EnvironmentDatabase.openDatabase();
		InteractionDatabase.openDatabase();
		BehaviourDatabase.openDatabase();

		System.out.println("START");

		int[] list = new int[580];
		int count = 0;
		int iteration = 1000;

		// for (int i=0; i<100; i++) System.out.println(random());
		// System.out.println(EnvironmentDatabase.getSize());
		// System.out.println(InteractionDatabase.getSize());

		for (int cc = 0; cc < iteration; cc++) {
			int a = random();
			int b = random();
			int c = random();
			int d = random();

			for (int i = 1; i <= EnvironmentDatabase.getSize(); i++)
				for (int j = 1; j <= InteractionDatabase.getSize(); j++) {
					Cat cat = new Cat("Tom", "Common Domestic Cat", new Emotion(a, b, c, d));
					int[] emoChange = Simulator.simulationEmo(EnvironmentDatabase.get(i), InteractionDatabase.get(j));
					cat.updateEmotion(emoChange);
					Behaviour act = Simulator.chooseBehaviour(cat, InteractionDatabase.get(j));
					list[act.getId()]++;
					count++;
				}
		}

		for (int i = 1; i <= 58; i++) {
			double por = (double) list[i - 1] / count * 100;
			System.out.println(i + ". " + por + "% " + BehaviourDatabase.get(i).getName());
		}

		System.out.println("END - " + count);
	}
}