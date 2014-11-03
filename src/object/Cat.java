package object;

import java.io.Serializable;

public class Cat implements Serializable {

	// maybe ID
	private String name;
	private String breed;
	//private int age; 	// for now: 1 = adult, 0 = baby;
	private Emotion emotion;

	// TODO habits/memory

	public Cat(String name, String breed, Emotion emotion) {
		this.name = name;
		this.breed = breed;
		this.emotion = emotion;
	}

	// GETTERS
	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}
	
	/*
	public int getAge() {
		return age;
	}
	*/
	
	public int[] getEmotion() {
		return emotion.getEmo();
	}
	
	public void setEmotion(int[] emo) {
		emotion.emoChange(emo);
	}

	public void printStatus() {
		int[] emo = emotion.getEmo();
		
		System.out.print("CAT.STATUS: ");	
		System.out.print("Excited:" + emo[0]);
		System.out.print("Fearful:" + emo[1]);
		System.out.print("Relieved:" + emo[2]);
		System.out.println("Angry:" + emo[3]);

	}
}
