package object;

import java.io.Serializable;

public class Cat implements Serializable {

	// TODO maybe ID
	// TODO breeds
	private String name;
	// for now: 1 = adult, 0 = baby;
	private int age;
	private Emotion emotion;

	// TODO habits/memory

	public Cat(String nam0, int age, Emotion emotion) {
		this.name = name;
		this.age = age;
		this.emotion = emotion;
	}

	// GETTERS
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

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
