package com.iuc.event_management.entity;
//package com.iuc.event_management.entity;
//
//
//import jakarta.persistence.*;
//
//import java.util.Collection;

//@Entity
//@Table(name = "roles")
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String name;
//
//    @ManyToMany(mappedBy = "roles")
//    private Collection<User> users;
//
//}

public enum Role {
    ADMIN, USER, ORGANIZER
}