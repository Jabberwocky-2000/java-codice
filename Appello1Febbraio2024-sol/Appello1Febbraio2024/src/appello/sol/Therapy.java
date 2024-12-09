package appello.sol;

import java.util.List;

public interface Therapy {


	public void addMedication(Medication medication, Patient patient);
	
	public void removeMedication(String medication);
	
	public List<Pair<Medication, Double>> getMedications();
	
	public boolean isMedicationPresent(Medication medication);

	public double getDosageForMedication(String med);

}
