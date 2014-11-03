package object;

import java.io.Serializable;

public class Behaviour implements Serializable {

	// maybe ID
	private String name;
	private InteractionCategory category;
	// factors: how likely cat'll do this with his current emotions: -1 to 1
	private double excited; 
	private double fearful;
	private double relieved;
	private double angry;

	public Behaviour(String name, InteractionCategory category, double excited, double fearful, double relieved,
			double angry) {
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
	
	public double getExcited() {
		return excited;
	}

	public double getFearful() {
		return fearful;
	}

	public double getRelieved() {
		return relieved;
	}

	public double getAngry() {
		return angry;
	}
	
	public InteractionCategory getCate() {
		return category;
	}
	
	public double getScore(int[] emo) {
		return excited * emo[0] + fearful * emo[1] + relieved * emo[2] + angry * emo[3];
	}

}
