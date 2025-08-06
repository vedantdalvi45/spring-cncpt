package com.vedant.crud_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    @EqualsAndHashCode.Include
    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private Member member;
}
