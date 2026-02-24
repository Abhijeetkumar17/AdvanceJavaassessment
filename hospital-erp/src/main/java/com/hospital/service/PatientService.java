package com.hospital.service;

import com.hospital.entity.Patient;
import com.hospital.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class PatientService {

    public void savePatient(Patient patient) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
        em.close();
    }

    public Patient findPatient(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Patient patient = em.find(Patient.class, id);
        em.close();
        return patient;
    }

    public void deletePatient(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Patient patient = em.find(Patient.class, id);
        em.remove(patient);
        em.getTransaction().commit();
        em.close();
    }
}