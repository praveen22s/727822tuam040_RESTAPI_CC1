package com.example.petadopt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.petadopt.model.PetAdmn;
import com.example.petadopt.repository.PetAdmnRepo;

@Service
public class PetAdmnService {
    @Autowired
    private PetAdmnRepo petAdmnRepo;

    public PetAdmnRepo addPets(PetAdmnRepo Pets) {
        return petAdmnRepo.save(Pets);
    }

    public Page<PetAdmnRepo> getAllPetss(Pageable pageable) {
        return petAdmnRepo.findAll(pageable);
    }

    public PetAdmnRepo getPetsById(Integer id) {
        return petAdmnRepo.findById(id).orElse(null);
    }

    public PetAdmnRepo updatePets(PetAdmnRepo Pets) {
        return petAdmnRepo.save(Pets);
    }

    public void deletePetsById(Integer id) {
        petAdmnRepo.deleteById(id);
    }

    public Page<PetAdmnRepo> findBySomeCriteria(String username, Pageable pageable) {
        return petAdmnRepo.findBySomeCriteria(username, pageable);
    }
}
