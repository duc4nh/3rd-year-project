package Tests;


import database.BehaviourDatabase;

public class BehaviourGen {

	public static void main(String[] args) {
		//CatDatabase.openDatabase();
		//EnvironmentDatabase.openDatabase();
		//InteractionDatabase.openDatabase();
		BehaviourDatabase.openDatabase();
		
		System.out.println("Welcome to Cat Simulator!");

		//CatDatabase.printAll();
		
		//Emotion emo = new Emotion(0, 0, 0, 0);
		/*Cat cat = new Cat("Common Domestic Cat", emo);
		Simulator.printStatus(cat);
		*/
		//Library.ViewLibrary();
		
		/*
		Behaviour[] beha = new Behaviour[29];
		beha[0] = new Behaviour("starts to play with", InteractionCategory.OBJECT, 1, -0.5, 0.5, -1);
		beha[1] = new Behaviour("starts to pounce", InteractionCategory.OBJECT, 1, -1, 0.5, -0.5);
		beha[2] = new Behaviour("starts to scratch", InteractionCategory.OBJECT, 1, -1, 0.5, -0.5);
		beha[3] = new Behaviour("starts to rub his body at", InteractionCategory.OBJECT, 1, -1, 0.5, -0.5);
		beha[4] = new Behaviour("is not interested, he just ignores", InteractionCategory.OBJECT, -1, 0.5, -0.5, 1);
		
		beha[5] = new Behaviour("is trying to hide", InteractionCategory.HUMAN, -1, 1, -0.5, 0.5);
		beha[6] = new Behaviour("is scratching", InteractionCategory.HUMAN, -1, 1, -1, 1);
		beha[7] = new Behaviour("bites", InteractionCategory.HUMAN, -1, 1, -1, 1);
		beha[8] = new Behaviour("licks", InteractionCategory.HUMAN, 1, -0.5, 1, -0.5);
		beha[9] = new Behaviour("is trying to stalk", InteractionCategory.HUMAN, 0.5, 0.5, -1, 0);
		beha[10] = new Behaviour("is not interested, he just ignores", InteractionCategory.HUMAN, -1, 0.5, -0.5, 1);
		beha[11] = new Behaviour("is purring simultaneously to greet", InteractionCategory.HUMAN, 1, -1, 1, -1);
		beha[12] = new Behaviour("is meowing to ge attention from", InteractionCategory.HUMAN, 0.5, -0.5, 0.5, -0.5);
		beha[13] = new Behaviour("starts a low meows that goes up and comes back down, he is happy when seeing", InteractionCategory.HUMAN, 1, -1, 1, -1);
		
		beha[14] = new Behaviour("licks", InteractionCategory.FOOD, 0.5, 0.5, -1, 0);
		beha[15] = new Behaviour("eats", InteractionCategory.FOOD, 0.5, -0.5, 0, 0);
		beha[16] = new Behaviour("drinks", InteractionCategory.FOOD, 0.5, -0.5, 0, 0);
		beha[17] = new Behaviour("tastes", InteractionCategory.FOOD, 0.5, 0.5, -1, 0);
		
		beha[18] = new Behaviour("is scratching panickly", InteractionCategory.ANIMAL, -1, 1, -1, 1);
		beha[19] = new Behaviour("is playing with", InteractionCategory.ANIMAL, 1, -1, 0.5, -0.5);
		beha[20] = new Behaviour("is chasing", InteractionCategory.ANIMAL, 1, -1, 0.5, 0);
		beha[21] = new Behaviour("is frolicing", InteractionCategory.ANIMAL, 1, -1, 1, -1);
		beha[22] = new Behaviour("is trying to hide", InteractionCategory.ANIMAL, -1, 1, -0.5, -0.5);
		beha[23] = new Behaviour("is wrestling with", InteractionCategory.ANIMAL, 0.5, -1, -0.5, 1);
		beha[24] = new Behaviour("is trying to flee", InteractionCategory.ANIMAL, -1, 1, -1, 0.5);
		beha[25] = new Behaviour("is cautiously watching", InteractionCategory.ANIMAL, -0.5, 1, -0.5, 0);
		beha[26] = new Behaviour("is stalking", InteractionCategory.ANIMAL, 0.5, 0.5, -1, 0);
		beha[27] = new Behaviour("is sprinting away from", InteractionCategory.ANIMAL, -1, 1, -1, 1);
		beha[28] = new Behaviour("is not interested, he just ignores", InteractionCategory.ANIMAL, -1, 0.5, -0.5, 1);
		
		for (Behaviour bh : beha) {
			BehaviourDatabase.add(bh);
		}
		//System.out.println("SCORE: " + BehaviourDatabase.get(1).getScore(emo.getEmo()));
*/
		//InteractionDatabase.printAll();
		//EnvironmentDatabase.printAll();
		BehaviourDatabase.printAllDetails();
		
		//InteractionDatabase.close();
		//EnvironmentDatabase.close();
		BehaviourDatabase.close();
	}
	
	//private static reader.close();
}