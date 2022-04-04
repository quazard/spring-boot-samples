package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue
  private Integer id;
  private String title;

  @ManyToOne
  @JoinColumn(name = "person_id", nullable = false)
  private Person author;

}
