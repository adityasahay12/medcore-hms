
package com.medcore.hms.controller;

import com.medcore.hms.entity.MedicalRecord;
import com.medcore.hms.repository.MedicalRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordController(
            MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @GetMapping
    public List<MedicalRecord> getAllRecords() {
        return medicalRecordRepository.findAll();
    }

    @GetMapping("/{id}")
    public MedicalRecord getRecordById(@PathVariable Long id) {
        return medicalRecordRepository.findById(id).orElse(null);
    }

    @PostMapping
    public MedicalRecord createRecord(
            @RequestBody MedicalRecord record) {
        return medicalRecordRepository.save(record);
    }

    @PutMapping("/{id}")
    public MedicalRecord updateRecord(
            @PathVariable Long id,
            @RequestBody MedicalRecord details) {

        MedicalRecord record = medicalRecordRepository.findById(id).orElse(null);

        if (record == null) {
            return null;
        }

        record.setDiagnosis(details.getDiagnosis());
        record.setSymptoms(details.getSymptoms());
        record.setTreatment(details.getTreatment());
        record.setPrescription(details.getPrescription());
        record.setPatient(details.getPatient());
        record.setDoctor(details.getDoctor());

        return medicalRecordRepository.save(record);
    }

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        if (!medicalRecordRepository.existsById(id)) {
            return "Medical record not found";
        }

        medicalRecordRepository.deleteById(id);
        return "Medical record deleted successfully";
    }
}
