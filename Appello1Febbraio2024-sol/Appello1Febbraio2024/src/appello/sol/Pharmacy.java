package appello.sol;

import java.util.Set;

public interface Pharmacy {

	/**
	 * Registers a new patient and associates them with a therapy.
	 *
	 * @param patient   The patient to be registered.
	 * @param therapies The therapy to be associated with the patient.
	 */
    public void registerPatient(Patient patient, Therapy therapies);

    /**
     * Retrieves the names of the medications that need to be purchased.
     *
     * @return A set of strings representing the medications to be bought.
     */
    public Set<String> getMedicationsToBuy();
}
