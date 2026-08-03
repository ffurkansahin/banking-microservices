package com.furkansahin.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkansahin.accounts.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
