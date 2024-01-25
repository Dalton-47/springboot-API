package com.KESRA.springBoot_KESRA.repository;


import com.KESRA.springBoot_KESRA.pojo.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  //marks a class/interface as a DAO for interaction with the database
public interface StaffEntityRepository extends JpaRepository<Staff, Long> {

    Optional<Staff> findByName(String name);
}
