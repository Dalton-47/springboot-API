package com.KESRA.springBoot_KESRA.implementation;

import com.KESRA.springBoot_KESRA.dto.AuthRequest;
import com.KESRA.springBoot_KESRA.pojo.Staff;
import com.KESRA.springBoot_KESRA.repository.StaffEntityRepository;
import com.KESRA.springBoot_KESRA.service.Staff_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class Staff_Implementation implements Staff_Service {

    @Autowired
    StaffEntityRepository staffEntityRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Staff_Implementation() {

    }

    @Override
    public <S extends Staff> S save(S entity) {
        return staffEntityRepository.save(entity);
    }

    @Override
    public <S extends Staff> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Staff> findById(Long aLong) {


        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Staff> findAll() {
        return staffEntityRepository.findAll();
    }

    @Override
    public List<Staff> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Staff entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Staff> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }


    @Override
    public <S extends Staff> S saveAndFlush(S entity) {

        return entity;
    }

    @Override
    public <S extends Staff> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Staff> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Staff getOne(Long aLong) {
        return null;
    }

    @Override
    public Staff getById(Long aLong) {
        return null;
    }

    @Override
    public Staff getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Staff> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Staff> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Staff> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Staff> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Staff> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Staff> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Staff, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Staff> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return null;
    }

    public Staff updateStaff(@RequestBody Staff staffClass) {

        // Check if staffClass has a valid ID
        if (staffClass.getEmp_no() <= 0) {
            // If the ID is null, throw an exception indicating that the ID is required
            throw new IllegalArgumentException("ID is required for updating staff");
        }

        // Check if the staff member with the given ID exists
        Optional<Staff> existingStaffOptional = findById(staffClass.getEmp_no());

        if (existingStaffOptional.isPresent()) {
            // If the staff member exists, update the details
            Staff existingStaff = existingStaffOptional.get();
            existingStaff.setDepartment(staffClass.getDepartment());
            existingStaff.setName(staffClass.getName());
            existingStaff.setSecond_name(staffClass.getSecond_name());
            existingStaff.setWage(staffClass.getWage());
            existingStaff.setProject_completion_rate(staffClass.getProject_completion_rate());

            System.out.println("SUCCESS");
            // Save the updated staff member
            return save(existingStaff);

        } else {
            // If the staff member does not exist, create a new staff member
            return save(staffClass);
        }
    }

    public ResponseEntity<String> deleteStaffById(@PathVariable(value = "emp_no") long emp_no) {
        try {
            deleteById(emp_no);
            // If deletion is successful, return a success message
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            // If deletion fails, return an error message
            return new ResponseEntity<>("Failed to delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    public Staff addUser(@RequestBody Staff staff){
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));
        save(staff);
        return staff;
    }

    @Override
    public Optional<Staff> findByName(String name) {
        return Optional.empty();
    }

    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest )
    {
       return jwtService.generateToken(authRequest.getName());
    }
}
