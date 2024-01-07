package com.durai096.QuizeApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
    @Table(name ="category_table_new")
public class Category {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", insertable = false, updatable = false)
   private int id;
   String category;


}
