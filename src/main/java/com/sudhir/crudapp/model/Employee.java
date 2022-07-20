package com.sudhir.crudapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // This annotation indicates that this class is a persistent class
@Table(name="Employee") // THis annotation provides the table that maps this entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {

    @Id // this annotation is for primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // to mention generation strategy
    private long id;

    @Column(name="name") //  this annotation is used to define the column in database that maps this annotation
    private String name;

    @Column(name="dept")
    private String dept;

    @Column(name="salary")
    private String salary;

}
