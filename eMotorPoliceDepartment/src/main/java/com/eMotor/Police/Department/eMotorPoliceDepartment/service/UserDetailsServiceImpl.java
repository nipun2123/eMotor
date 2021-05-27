package com.eMotor.Police.Department.eMotorPoliceDepartment.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.DepartmentAccountRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.DepartmentAccount;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private DepartmentAccountRepository departmentAccountRepository;

    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String username) {
        DepartmentAccount user = departmentAccountRepository.findByUsername(username);
        if (user == null) {
        	throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
   

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}