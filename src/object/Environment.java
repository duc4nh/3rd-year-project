package object;

import java.io.Serializable;

/**
 * An environment
 *
 * @author DucAnh
 */
public class Environment implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -6670912949099871588L;
	// -5-4 -3-2 -101 23 45
	private int id;
	private String name;
	private int temperature; // -5 = very hot; 5 = very cold
	private int humidity; // -5 = very humid; 5 = very dry
	private int light; // -5 to 5 = light
	private int noise; // -5 to 5 = noisy

	public Environment(int id, String name, int temperature, int humidity, int light, int noise) {
		this.id = id;
		this.name = name;
		this.temperature = temperature;
		this.humidity = humidity;
		this.light = light;
		this.noise = noise;
	}

	// GETTERS
	public int getId() {
		return id;
	}

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

	public String getInfo() {
		String s = "";
		s += statusDisplay("Temperature", temperature);
		s += statusDisplay("Humidity", humidity);
		s += statusDisplay("Light", light);
		s += statusDisplay("Noise", noise);
		return s;
	}
	
	private String statusDisplay(String name, int n) {
		String s = name + ":\t|";
		for (int i=-5; i<=5; i++) {
			//if (i==0) s+="|";
			if (i<=n) s+="*";
			//else s+="[-]";
		}
		s += "\n";
		
		return s;
	}
}