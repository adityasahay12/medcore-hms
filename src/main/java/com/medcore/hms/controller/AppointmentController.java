package com.medcore.hms.controller;

import com.medcore.hms.entity.Appointment;
import com.medcore.hms.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    // Create appointment
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Update appointment
    @PutMapping("/{id}")
    public Appointment updateAppointment(
            @PathVariable Long id,
            @RequestBody Appointment appointmentDetails) {

        Appointment appointment = appointmentRepository.findById(id).orElse(null);

        if (appointment == null) {
            return null;
        }

        appointment.setAppointmentDate(
                appointmentDetails.getAppointmentDate());

        appointment.setReason(
                appointmentDetails.getReason());

        appointment.setStatus(
                appointmentDetails.getStatus());

        appointment.setPatient(
                appointmentDetails.getPatient());

        appointment.setDoctor(
                appointmentDetails.getDoctor());

        return appointmentRepository.save(appointment);
    }

    // Delete appointment
    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {

        if (!appointmentRepository.existsById(id)) {
            return "Appointment not found";
        }

        appointmentRepository.deleteById(id);

        return "Appointment deleted successfully";
    }
}