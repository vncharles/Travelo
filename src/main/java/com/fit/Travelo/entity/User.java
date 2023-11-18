package com.fit.Travelo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_account")
@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private boolean active;
    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;


}
