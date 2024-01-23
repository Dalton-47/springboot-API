package com.KESRA.springBoot_KESRA.controller;

import com.KESRA.springBoot_KESRA.implementation.Staff_Implementation;
import com.KESRA.springBoot_KESRA.pojo.Staff;
import com.KESRA.springBoot_KESRA.repository.StaffEntityRepository;
import com.KESRA.springBoot_KESRA.service.Staff_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StaffController extends Staff_Implementation {

@GetMapping("/stafflist")
public List<Staff> getAllEntities()
{
    return findAll();
}

@PostMapping("/postStaff")
    public void addStaff(@RequestBody Staff staffClass)
{
    saveAndFlush(staffClass) ;
}

    @PutMapping("/updateStaff")
   public void putStaffMember(@RequestBody Staff staff)
    {
        updateStaff(staff);
    }

    @DeleteMapping("/deleteStaff/{emp_no}")
    public void delete_StaffById(long emp_no) {
        deleteStaffById( emp_no);
    }


}
