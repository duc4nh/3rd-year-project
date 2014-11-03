package Tests;

import database.CatDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;
import object.Cat;
import object.Emotion;
import simulator.Simulator;

public class Objectgen {

	public static void main(String[] args) {
		Emotion emo = new Emotion(-10, 5, 7, 8);
		Cat cat = new Cat("Tom", "Common Domestic Cat", emo);
		Simulator.printStatus(cat);
	}
}