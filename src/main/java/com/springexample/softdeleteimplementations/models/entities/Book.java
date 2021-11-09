package com.springexample.softdeleteimplementations.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "update books set deleted = true where id=?") // this syntax will execute when data from this table is
                                                               // deleted
@Where(clause = "deleted = false") // this syntax will always execute when this data is showing
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
