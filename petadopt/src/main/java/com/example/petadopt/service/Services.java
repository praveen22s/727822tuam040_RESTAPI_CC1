package com.example.petadopt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.petadopt.model.Pet;
import com.example.petadopt.repository.Repository;
@Service
public class Services {

    @Autowired
    public Repository ab;


    public Pet createnewuser(@NonNull Pet user)
    {
        return ab.save(user);
    }

    //getuser

    public List<Pet> getAllusers()
    {
        return ab.findAll();
    }


    public Optional<Pet> getModelByCategory(String category)
    {
        return ab.findByCategory(category);
    }

    //updateUser

    public Pet updateUser(@NonNull String category,@RequestBody Pet user)
    {
        return ab.findByCategory(category)
        .map(existingUser -> {
        existingUser.setCategory(user.getCategory());
        existingUser.setAge(user.getAge());
        existingUser.setPetname(user.getPetname());
        existingUser.setFavfood(user.getFavfood());
        return ab.save(existingUser);

        }
        )

        .orElseThrow(() -> new RuntimeException("User not found with this email: "+ category));

    }
    public void removeUser(@NonNull Integer userId)
    {
        ab.deleteById(userId);
    }
}
