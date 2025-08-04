package com.vedant.crud_demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Member {

    @Id
    @Column(name = "user_id")
    @EqualsAndHashCode.Include
    private String userId;

    @Column(name = "pw")
    private String password;

    @Column(name = "active")
    private int active;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Role> roles = new HashSet<>();
}
