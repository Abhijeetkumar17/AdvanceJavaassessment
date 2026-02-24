package com.hospital.App;

import com.hospital.entity.*;
import com.hospital.service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HospitalApplication {

    public static void main(String[] args) {

        System.out.println("Hospital ERP Started...");

        // ----------- CREATE PATIENT + MEDICAL RECORD -----------
        PatientService patientService = new PatientService();

        MedicalRecord record = new MedicalRecord();
        record.setRecordDate(LocalDate.now());
        record.setDiagnosis("Flu");
        record.setNotes("Rest for 3 days");

        Patient patient = new Patient();
        patient.setName("Ali");
        patient.setDob(LocalDate.of(2000, 5, 10));
        patient.setBloodGroup("O+");
        patient.setPhone("9999999999");
        patient.setMedicalRecord(record);

        patientService.savePatient(patient);

        System.out.println("Patient saved successfully!");

        // ----------- CREATE DEPARTMENT + DOCTOR -----------
        DepartmentService departmentService = new DepartmentService();

        Department dept = new Department();
        dept.setName("Cardiology");
        dept.setLocation("Block A");

        Doctor doctor = new Doctor();
        doctor.setName("Dr. Mehta");

        dept.addDoctor(doctor);

        departmentService.saveDepartment(dept);

        System.out.println("Department & Doctor saved successfully!");

        System.out.println("Hospital ERP Finished.");
    }
}