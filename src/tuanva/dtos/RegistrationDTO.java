/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuanva.dtos;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class RegistrationDTO implements Serializable{
    String registrationID, fullname, email, phone, address;
    Integer age, numberOfMember, numberOfChildren, numberOfAdults;
    boolean gender;
    

    public RegistrationDTO() {
    }

    public RegistrationDTO(String registrationID, String fullname, Integer age, boolean gender,String email, String phone, String address, Integer numberOfMember, Integer numberOfChildren, Integer numberOfAdults) {
        this.registrationID = registrationID;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.numberOfMember = numberOfMember;
        this.numberOfChildren = numberOfChildren;
        this.numberOfAdults = numberOfAdults;
        this.gender = gender;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumberOfMember() {
        return numberOfMember;
    }

    public void setNumberOfMember(Integer numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public boolean isGender() {
//        return gender;
        if(String.valueOf(gender).equalsIgnoreCase("Male")){
            return gender = true;
        }else if(String.valueOf(gender).equalsIgnoreCase("Female")){
            return gender = false;
        }
        return gender;
//        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return registrationID + "," + fullname + "," + age + "," + gender + "," + email + "," + phone + "," + address + "," + numberOfMember + "," + numberOfChildren + "," + numberOfAdults;
    }
    
    public String print(){
        return registrationID + "," + fullname + "," + age + "," + change(gender) + "," + email + "," + phone + "," + address + "," + numberOfMember + "," + numberOfChildren + "," + numberOfAdults;
        
    }
//    
//    public boolean convert(String gender){
//        boolean gender1;
//        if(gender.equalsIgnoreCase("male")){
//            gender1 = Boolean.parseBoolean("true");
//        }else{
//            gender1 = Boolean.parseBoolean("false");
//        }
//        return gender1;
//    }
 
    public String change(boolean gender){
        String temp = "";
        if(gender){
            temp = "Male";
        }else{
            temp = "Female";
        }
        return temp;
    }
    
}
