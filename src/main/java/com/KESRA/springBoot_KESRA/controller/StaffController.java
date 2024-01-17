package com.KESRA.springBoot_KESRA.controller;

import com.KESRA.springBoot_KESRA.entity.Staff_Class;
import com.KESRA.springBoot_KESRA.repository.StaffEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

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

@PostMapping("/postStaff")
    public Staff_Class addStaff(@RequestBody Staff_Class staffClass)
{
    // Log input data
    System.out.println("Received staff data: " + staffClass);

    // Save the staff data
    Staff_Class savedStaff = staffEntityRepository.save(staffClass);

    // Log the saved staff data
    System.out.println("Saved staff data: " + savedStaff);

    return savedStaff;
    /*
    //sample data for postman
    {
    "first_name": "Harsh",
    "second_name": "Software Developer",
    "department": "Teaching",
    "wage":36784.56,
    "project_completion_rate": 45.5
}
     */
}

    @PutMapping("/updateStaff")
    public Staff_Class updateStaff(@RequestBody Staff_Class staffClass) {
        // Check if staffClass has a valid ID
        if (staffClass.getEmp_no() <= 0) {
            // If the ID is null, throw an exception indicating that the ID is required
            throw new IllegalArgumentException("ID is required for updating staff");
        }

        // Check if the staff member with the given ID exists
        Optional<Staff_Class> existingStaffOptional = staffEntityRepository.findById(staffClass.getEmp_no());

        if (existingStaffOptional.isPresent()) {
            // If the staff member exists, update the details
            Staff_Class existingStaff = existingStaffOptional.get();
            existingStaff.setDepartment(staffClass.getDepartment());
            existingStaff.setFirst_name(staffClass.getFirst_name());
            existingStaff.setSecond_name(staffClass.getSecond_name());
            existingStaff.setWage(staffClass.getWage());
            existingStaff.setProject_completion_rate(staffClass.getProject_completion_rate());

            // Save the updated staff member
            return staffEntityRepository.save(existingStaff);
        } else {
            // If the staff member does not exist, create a new staff member
            return staffEntityRepository.save(staffClass);
        }
    }



}
