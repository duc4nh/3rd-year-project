package object;

import java.io.Serializable;

public class InteractionObject implements Serializable {

	// TODO maybe ID
	private String name;
	private int excited;
	private int fearful;
	private int relieved;
	private int angry;

	public InteractionObject(String name_, int excited_, int fearful_,
			int relieved_, int angry_) {
		name = name_;
		excited = excited_;
		fearful = fearful_;
		relieved = relieved_;
		angry = angry_;
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
	
}
