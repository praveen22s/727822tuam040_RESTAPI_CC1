package com.example.petadopt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.petadopt.model.Pet;

public interface Repository extends JpaRepository<Pet,Integer>
{
    Optional<Pet> findByCategory(String category);
}
