package object;

import java.io.Serializable;

public class Environment implements Serializable {
	
	// maybe ID
	private String name;
	private int temperature; //-5 = very hot; 5 = very cold
	private int humidity; //-5 = very humid; 5 = very dry
	private int light; //-5 to 5 = light
	private int noise; //-5 to 5 = noisy
	
	public Environment(String name, int temperature, int humidity, int light, int noise) {
		this.name = name;
		this.temperature = temperature;
		this.humidity = humidity;
		this.light = light;
		this.noise = noise;
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
