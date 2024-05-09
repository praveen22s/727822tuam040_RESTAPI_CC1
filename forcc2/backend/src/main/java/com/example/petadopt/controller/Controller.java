package com.example.petadopt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petadopt.model.Pet;
import com.example.petadopt.service.Service_1;
import com.example.petadopt.model.PetAdmn;


// import com.example.day4post.service.Service;
import lombok.NonNull;

@RestController
@RequestMapping("/api/users")
public class Controller
{
    

@Autowired
private  Service_1 userService;

@PostMapping("/createUser")

public ResponseEntity<Pet> createUser(@NonNull @RequestBody Pet user) {

Pet createdUser = userService.createnewuser(user);

return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

}

@GetMapping("readUser/{category}")

//@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")

public ResponseEntity<?> getUserByEmail(@PathVariable String category)
{

Optional<Pet> user = userService.getModelByCategory(category);

return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))

.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

}

@GetMapping("/readUsers")

// @PreAuthorize("hasAuthority('ADMIN')")

public ResponseEntity<List<Pet>> getAllUsers()
{

List<Pet> users = userService.getAllusers();

return new ResponseEntity<>(users, HttpStatus.OK);

}

@PutMapping("updateUser/{category}")

// @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")

public ResponseEntity<Pet> updateUser(@NonNull @PathVariable String category,@RequestBody Pet updateRequest)
{

Pet updated = userService.updateUser(category, updateRequest);

return new ResponseEntity<>(updated, HttpStatus.OK);

}

@DeleteMapping("deleteUser/{userId}")

// @PreAuthorize("hasAuthority('ADMIN')")

public ResponseEntity<Void> removeUser(@NonNull @PathVariable Integer userId) {

userService.removeUser(userId);

return new ResponseEntity<>(HttpStatus.NO_CONTENT);

@GetMapping("/user/by-username")
public ResponseEntity<Page<PetAdmn>> findByUsername(@RequestParam String username, Pageable pageable) {
    Page<PetAdmn> users = PetAdmnService.findByUsername(username, pageable);
    return ResponseEntity.ok(users);
}
@PostMapping("/user/{userId}/product")
public ResponseEntity<Product> addProductToPetAdmn(@PathVariable Integer userId, @RequestBody Product product) {
    PetAdmn Gm = PetAdmnService.getPetAdmnById(userId);
    
    if (PetAdmn != null) {
        product.setPetAdmn(PetAdmn);
        Product addedProduct = productRepo.save(product); // Save product directly
        
        if (addedProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
        } 
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    } else {
        return ResponseEntity.notFound().build();
    }

}

}