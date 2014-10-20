package object;

import java.io.Serializable;

public class Environment implements Serializable {
	
	//TODO maybe ID
	private String name;
	//for now: 1 = hot, 0 = neutral, -1 = cold;
	private int temperature;
	//for now: 1 = humid, 0 = dry;
	private int humidity;
	//for now: 1 = dark, 0 = light;
	private int light;
	//for now: 1 = noisy, 0 = normal;
	private int noise;
	
	public Environment(String name0, int temperature0, int humidity0, int light0, int noise0) {
		name = name0;
		temperature = temperature0;
		humidity = humidity0;
		light = light0;
		noise = noise0;
	}
	
	//GETTERS
	public String getName() {
		return name;
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public int getHumidity() {
		return humidity;
	}
	
	public int getLight() {
		return light;
	}
	
	public int getNoise() {
		return noise;
	}
	
}
