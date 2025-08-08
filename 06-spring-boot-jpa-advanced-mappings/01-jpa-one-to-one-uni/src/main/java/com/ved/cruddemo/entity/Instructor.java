package com.ved.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instructor")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Instructor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "first_name")
    private String fName;

    @Column(name = "last_name")
    private String lName;


    @Column(name = "email", unique = true)
    private String email;



    public Instructor(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
//    @ToString.Exclude
    private InstructorDetail instructorDetail;
}
