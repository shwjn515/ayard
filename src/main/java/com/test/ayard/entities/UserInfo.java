package com.test.ayard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userinfo")
public class UserInfo {
    @Column(name = "name")
    String name;
    @Column(name = "password")
    String password;
    @Column(name = "u_id")
    String u_id;
    @Column(name = "phone")
    Long phone;
    @Column(name = "u_address")
    String u_address;
    @Column(name = "u_name")
    String u_name;
    @Column(name = "u_photo")
    String u_photo;
    @Column(name = "u_class")
    int u_class;
    @Id
    @Column(name = "id")
    Long id;
}
