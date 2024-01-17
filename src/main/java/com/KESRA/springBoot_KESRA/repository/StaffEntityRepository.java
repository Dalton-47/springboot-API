package com.KESRA.springBoot_KESRA.repository;


import com.KESRA.springBoot_KESRA.entity.Staff_Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository  //tells the spring container that this class handles encapsulation of the class handling database access
public interface StaffEntityRepository extends JpaRepository<Staff_Class, Long> {

}
