package com.hospital.service;

import com.hospital.entity.Doctor;
import com.hospital.util.JpaUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class DoctorService {

    public void saveDoctor(Doctor doctor) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(doctor);
        em.getTransaction().commit();
        em.close();
    }

    public Doctor findDoctor(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Doctor doctor = em.find(Doctor.class, id);
        em.close();
        return doctor;
    }

    public void updateDoctorName(Long id, String newName) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Doctor doctor = em.find(Doctor.class, id);
        doctor.setName(newName);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteDoctor(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Doctor doctor = em.find(Doctor.class, id);
        em.remove(doctor);
        em.getTransaction().commit();
        em.close();
    }

    // JPQL Example
    public List<Doctor> findBySpecialization(String spec) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Doctor> list = em.createQuery(
                "SELECT d FROM Doctor d WHERE d.specialization = :sp",
                Doctor.class)
                .setParameter("sp", spec)
                .getResultList();
        em.close();
        return list;
    }
}