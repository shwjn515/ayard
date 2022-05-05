package com.test.ayard.entities;

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
    String name;
    String password;
    String u_id;
    int phone;
    String u_address;
    String u_name;
    String u_photo;
    int u_class;
    @Id
    Integer id;
}
