package com.sys.regfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "full_name")
    private String fullName;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "stu_reg_num")
    private String stuRegNum;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "dob")
    private int dob;
    @Column(name = "nic")
    private String nic;
    @Column(name = "contact_number")
    private int contactNumber;
//    public boolean getEnabled(){return enabled;}

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
