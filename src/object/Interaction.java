package object;

import java.io.Serializable;

public class Interaction implements Serializable {

	// TODO maybe ID
	private String name;
	private InteractionCategory category;
	// how cat's emotions are likely to be affected by this interaction: -5 to 5
	private int excited; 
	private int fearful;
	private int relieved;
	private int angry;

	public Interaction(String name, InteractionCategory category, int excited, int fearful, int relieved,
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

	public int getExcited() {
		return excited;
	}

	public int getFearful() {
		return fearful;
	}

	public int getRelieved() {
		return relieved;
	}

	public int getAngry() {
		return angry;
	}
	
	public InteractionCategory getCate() {
		return category;
	}

}
