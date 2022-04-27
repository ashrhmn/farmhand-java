/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Repository.PersonRepo;

/**
 *
 * @author ash
 */
public class Person {
    private String name;
    private String nid;
    private String mobile;
    private String dateOfBirth;
    private String email;
    private String address;
    private String tradeLicenseNo;
    private Double credit;
    

    public Person(String name, String nid, String mobile, String dateOfBirth, String email, String address, String tradeLicenseNo) {
        this.name = name;
        this.nid = nid;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.tradeLicenseNo = tradeLicenseNo;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTradeLicenseNo() {
        return tradeLicenseNo;
    }

    public void setTradeLicenseNo(String tradeLicenseNo) {
        this.tradeLicenseNo = tradeLicenseNo;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }
}
