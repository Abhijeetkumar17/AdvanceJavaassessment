package com.hospital.service;

import com.hospital.entity.Department;
import com.hospital.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class DepartmentService {

    public void saveDepartment(Department dept) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(dept);
        em.getTransaction().commit();
        em.close();
    }

    public Department findDepartment(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Department dept = em.find(Department.class, id);
        em.close();
        return dept;
    }
}