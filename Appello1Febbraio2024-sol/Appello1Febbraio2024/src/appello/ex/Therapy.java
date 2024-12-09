package appello.ex;

import java.util.List;

public interface Therapy {

	
	/**
     * Adds a medication to a patient's therapy.
     * Once adding the medication, also its dosage must be defined and associated with the medication.
     *
     * @param medication The medication to be added.
     * @param patient    The patient to whom the medication is prescribed.
     */
	public void addMedication(Medication medication, Patient patient);
	
	
	/**
     * Removes a medication from the therapy based on its name.
     *
     * @param medication The name of the medication to be removed.
     */
	public void removeMedication(String medication);
	
	
	/**
     * Retrieves a collection of medications along with their dosages in the therapy.
     *
     * @return The collection containing medications and their corresponding dosages.
     */
	//public Collection<> getMedications();
	
	/**
	 * The method states if a specific medication is included in the therapy
	 * 
	 * @return True if the medication is part of the therapy, false otherwise.
	 */
	public boolean isMedicationPresent(Medication medication);
	
	
	/**
     * Retrieves the dosage for a specific medication.
     *
     * @param med The name of the medication for which the dosage is requested.
     * @return The dosage of the specified medication.
     */
	public double getDosageForMedication(String med);

}
