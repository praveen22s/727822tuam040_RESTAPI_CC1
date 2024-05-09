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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String petname;
    private String category;
    private String fav_food;
    private String age;
    public int getId() {
        return id;
    }
    public Pet(int id, String petname, String category, String fav_food, String age) {
        this.id = id;
        this.petname = petname;
        this.category = category;
        this.fav_food = fav_food;
        this.age = age;
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
    public String getFav_food() {
        return fav_food;
    }
    public void setFav_food(String fav_food) {
        this.fav_food = fav_food;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    

}
