package com.furkansahin.loans.repository;

import org.springframework.stereotype.Repository;

import com.furkansahin.loans.entity.Loans;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LoansRepository extends JpaRepository<Loans,Long> {
    Optional<Loans> findByMobileNumber(String mobileNumber);
}
