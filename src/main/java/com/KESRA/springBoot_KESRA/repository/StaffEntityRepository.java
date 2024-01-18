package com.KESRA.springBoot_KESRA.repository;


import com.KESRA.springBoot_KESRA.entity.Staff_Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository  //marks a class/interface as a DAO for interaction with the database
public interface StaffEntityRepository extends JpaRepository<Staff_Class, Long> {

}
