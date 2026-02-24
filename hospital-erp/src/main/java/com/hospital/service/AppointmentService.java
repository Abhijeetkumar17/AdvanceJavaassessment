package com.hospital.service;

import com.hospital.entity.Appointment;
import com.hospital.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class AppointmentService {

    public void saveAppointment(Appointment appointment) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(appointment);
        em.getTransaction().commit();
        em.close();
    }

    public Appointment findAppointment(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Appointment appt = em.find(Appointment.class, id);
        em.close();
        return appt;
    }

    public void updateStatus(Long id, String newStatus) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Appointment appt = em.find(Appointment.class, id);
        appt.setStatus(newStatus);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAppointment(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Appointment appt = em.find(Appointment.class, id);
        em.remove(appt);
        em.getTransaction().commit();
        em.close();
    }
}