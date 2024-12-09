package appello.sol;

import java.util.ArrayList;
import java.util.List;

public class TherapyImpl implements Therapy{

	private static final int BMI_THRESHOLD = 35;
	
	private List<Pair<Medication, Double>> medications;

	public TherapyImpl() {
		this.medications = new ArrayList<>();
	}

	public void addMedication(Medication medication, Patient patient) {
		// Consider patient characteristics before adding medication
		if (!isMedicationPresent(medication) && patient.computeBMI() < BMI_THRESHOLD) {
			medications.add(new Pair<>(medication, patient.getWeight() * medication.getDosagePerKilo()));
		} else {
			throw new IllegalArgumentException("Duplicate medication or patient data may contain errors");
		}
	}
	
	public void removeMedication(String medication) {
		this.medications = medications.stream()
			.filter(m -> !m.get1().getName().equals(medication))
			.toList();
	}

	public List<Pair<Medication, Double>> getMedications() {
		return medications;
	}
	
	public boolean isMedicationPresent(Medication medication) {
		return medications.stream()
		        .anyMatch(m -> m.get1().getName().equals(medication.getName()));
	}

	public double getDosageForMedication(String med) {
		return medications.stream()
	            .filter(m -> m.get1().getName().equals(med))
	            .mapToDouble(Pair::get2)
	            .findFirst()
	            .orElse(0.0); 
	}

}
