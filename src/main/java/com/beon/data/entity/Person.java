package com.beon.data.entity;

/**
 * Created by leo on 14-4-6.
 */

import javax.persistence.*;

@Entity
@Table(name = "person", schema = "public")
public class Person implements java.io.Serializable {
    private static final long serialVersionUID = -6884164599965097414L;

    //private static final long serialVersionUID = 2320205665052433730L;
    // Fields

    private Integer id;
    private String name;
    private Integer age;

    // Constructors

    /**
     * default constructor
     */
    public Person() {
    }

    /**
     * minimal constructor
     */
    public Person(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Property accessors
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "zest_person_id_seq")
    @SequenceGenerator(name = "zest_person_id_seq", sequenceName = "zest_person_id_seq", allocationSize = 1)

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}