package com.KESRA.springBoot_KESRA.repository;


import com.KESRA.springBoot_KESRA.entity.Staff_Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffEntityRepository extends JpaRepository<Staff_Class, Long> {

    //save
   Staff_Class save(Staff_Class staffClass);

    // Read
    Staff_Class findById(long emp_no);
    List<Staff_Class> findAll();

    //delete
    /*
    void deleteById(int emp_no);
    void delete(Staff_Class entity);

     */

}
