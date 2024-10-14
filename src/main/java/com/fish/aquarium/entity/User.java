package com.fish.aquarium.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "users")
public class User implements UserDetails{
    @Column(nullable=false, unique = true)
    private String personalNumber;
    @Column(nullable=false)
    private String firstName;
    @Column(nullable=false)
    private String lastName;  
    @Column(nullable=false, unique = true)
    private String email; 
    @Column(nullable=false)
    private String passwordHash; 
    @Column(nullable=false)
    private String role; 
// constructor + var
    public User(String personalNumber, String firstName, String lastName, String phoneNumber, String email, String role, String passwordHash){
    this.personalNumber = personalNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.passwordHash= passwordHash;
    this.role= role;

    }
    






    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }

    public String getPersonalNumber(){
        return personalNumber;
    }
    public void setPersonalNumber(){
        this.personalNumber =personalNumber;
    }
    public String getFirtName(){
        return firstName;
    }
    public void setFirstName(){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    public void setLastName(){
        this.lastName = lastName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = email;
    }
    public String getRole(){
        return role;
    }
    public void setRole(){
        this.email = email;
    }
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }




}
