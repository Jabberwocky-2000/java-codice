package appello.sol;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PharmacyImpl implements Pharmacy{
	
    private Map<Patient, Therapy> patientTherapiesMap;

    public PharmacyImpl() {
        this.patientTherapiesMap = new HashMap<>();
    }

    public void registerPatient(Patient patient, Therapy therapies) {
         patientTherapiesMap.put(patient, therapies);
    }

    public Set<String> getMedicationsToBuy() {
        return patientTherapiesMap.values().stream()
                .flatMap(therapy -> therapy.getMedications().stream())
                .map(medicationEntry -> medicationEntry.get1().getName())
                .collect(Collectors.toSet());
    }
}
