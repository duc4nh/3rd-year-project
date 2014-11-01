package object;

import java.io.Serializable;

public class Behaviour implements Serializable {

	// TODO maybe ID
	private String name;
	private InteractionCategory category;
	// factors: how likely cat'll do this with his current emotions
	private double excited; 
	private double fearful;
	private double relieved;
	private double angry;

	public Behaviour(String name, InteractionCategory category, int excited, int fearful, int relieved,
			int angry) {
		this.name = name;
		this.category = category;
		this.excited = excited;
		this.fearful = fearful;
		this.relieved = relieved;
		this.angry = angry;
	}

	// GETTERS
	public String getName() {
		return name;
	}
	
	public InteractionCategory getCate() {
		return category;
	}
	
	public double getScore(int[] emo) {
		return excited * emo[0] + fearful * emo[1] + relieved * emo[2] + angry * emo[3];
	}
	
	public void printStatus() {
		System.out.print("BEHAVIOUR.STATUS: ");
		System.out.print("Name:" + name);
		System.out.print("Excited:" + excited);
		System.out.print("Fearful:" + fearful);
		System.out.print("Relieved:" + relieved);
		System.out.println("Angry:" + angry);
	}
}
