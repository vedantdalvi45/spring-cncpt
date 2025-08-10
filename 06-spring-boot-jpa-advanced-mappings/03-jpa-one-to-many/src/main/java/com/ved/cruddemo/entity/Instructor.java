package com.ved.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.usertype.CompositeUserType;

import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    @ToString.Exclude
    private InstructorDetail instructorDetail;

    @ToString.Exclude
    @OneToMany(mappedBy = "instructor",cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    private List<Course> courses;

    public Instructor(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    public Course addCourse(Course course){
        course.setInstructor(this);
        if (courses == null){
            courses = new ArrayList<>();
            courses.add(course);
        }else {
            courses.add(course);
        }
        return course;
    }
    public List<Course> addCourses(List<Course> newCourses){
        if (courses == null)
            courses = new ArrayList<>(courses);

        courses.addAll(newCourses);
        newCourses.forEach(course -> course.setInstructor(this));
        return newCourses;
    }




}
