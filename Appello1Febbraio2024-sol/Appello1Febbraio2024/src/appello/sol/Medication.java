package appello.sol;

public class Medication {

	private final String name;
	private final double dosagePerKilo;

	public Medication(String name, double dosage) {
		this.name = name;
		this.dosagePerKilo = dosage;
	}
	
	public String getName() {
		return name;
	}

	public double getDosagePerKilo() {
		return dosagePerKilo;
	}

}
