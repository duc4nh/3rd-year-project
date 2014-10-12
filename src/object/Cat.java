package object;

import java.io.Serializable;

public class Cat implements Serializable {
	
	//TODO maybe ID
	//TODO breeds
	private String name;
	//for now: 1 = adult, 0 = baby;
	private int age;
	private Emotion emotion;
	//TODO habits/memory
	
	public Cat(String name0, int age0, Emotion emotion0) {
		name = name0;
		age = age0;
		emotion = emotion0;
	}
	
	//GETTERS
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public Emotion getEmotion() {
		return emotion;
	}

}
