package com.example.petadopt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pets")
public class Pet
{
    
    public Pet() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String petname;
    private String category;
    private String favfood;
    private String age;
    public Pet(int id, String petname, String category, String favfood, String age)
    {
        this.id = id;
        this.petname = petname;
        this.category = category;
        this.favfood = favfood;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPetname() {
        return petname;
    }
    public void setPetname(String petname) {
        this.petname = petname;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getFavfood() {
        return favfood;
    }
    public void setFavfood(String favfood) {
        this.favfood = favfood;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

}
