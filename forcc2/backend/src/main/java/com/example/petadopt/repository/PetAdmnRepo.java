package com.example.petadopt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.petadopt.model.PetAdmn;

@Repository
public interface PetAdmnRepo extends JpaRepository<PetAdmn,Integer> {
    @Query("SELECT i FROM GiftM i WHERE i.username = ?1")
    Page<PetAdmn> findByUsername(String username, Pageable pageable);
    
}