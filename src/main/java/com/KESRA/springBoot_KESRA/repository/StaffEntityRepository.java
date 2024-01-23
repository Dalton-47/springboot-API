package com.KESRA.springBoot_KESRA.repository;


import com.KESRA.springBoot_KESRA.pojo.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //marks a class/interface as a DAO for interaction with the database
public interface StaffEntityRepository extends JpaRepository<Staff, Long> {

}
