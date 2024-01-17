package com.KESRA.springBoot_KESRA.controller;

import com.KESRA.springBoot_KESRA.entity.Staff_Class;
import com.KESRA.springBoot_KESRA.repository.StaffEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api")
public class StaffController {

@Autowired
   private StaffEntityRepository staffEntityRepository;

@GetMapping("/stafflist")
public List<Staff_Class> getAllEntities() {
    return staffEntityRepository.findAll();
}



}
