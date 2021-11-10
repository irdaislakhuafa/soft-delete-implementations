package com.springexample.softdeleteimplementations.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
// this syntax will execute when data from this table is deleted
@SQLDelete(sql = "update books set deleted = true where id=?") 
// @Where(clause = "deleted = false") // this syntax will always execute when this data is showing
@FilterDef(name = "statusDeleted", parameters = @ParamDef(name = "isDeleted", type = "boolean")) // definition a FilterDef parameters
@Filter(name = "statusDeleted", condition = "deleted = :isDeleted")
public class Book {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private double price;

    private boolean deleted = Boolean.FALSE; // default value is false
}
