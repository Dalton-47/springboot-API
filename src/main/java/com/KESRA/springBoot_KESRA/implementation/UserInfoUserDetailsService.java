package com.KESRA.springBoot_KESRA.implementation;

import com.KESRA.springBoot_KESRA.pojo.Staff;
import com.KESRA.springBoot_KESRA.repository.StaffEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {


    @Autowired
    StaffEntityRepository staffEntityRepository;
    @Override
    public UserDetails loadUserByUsername(String first_name) throws UsernameNotFoundException {

        Optional<Staff> staff = staffEntityRepository.findByName(first_name);

        return staff.map(UserInfoUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("User not found"+first_name));

    }
}
