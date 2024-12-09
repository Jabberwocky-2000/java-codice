package appello.ex;

public class Patient {

	private final String name;
	private final int age;
	private final double weight;
	private final double height;

	public Patient(String name, int age, double weight, double height) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}

	public double getHeight() {
		return height;
	}

	// da implementare: il BMI è uguale a peso diviso altezza al quadrato
	public double computeBMI() {
		return 0.0;
	}
	
}
