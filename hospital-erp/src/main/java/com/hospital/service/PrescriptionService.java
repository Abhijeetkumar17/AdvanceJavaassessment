package com.hospital.service;

import com.hospital.entity.Prescription;
import com.hospital.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class PrescriptionService {

    public void savePrescription(Prescription prescription) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(prescription);
        em.getTransaction().commit();
        em.close();
    }

    public Prescription findPrescription(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Prescription prescription = em.find(Prescription.class, id);
        em.close();
        return prescription;
    }

    public void deletePrescription(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Prescription prescription = em.find(Prescription.class, id);
        em.remove(prescription);
        em.getTransaction().commit();
        em.close();
    }
}