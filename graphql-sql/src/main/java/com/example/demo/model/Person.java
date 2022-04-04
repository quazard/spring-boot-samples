package com.example.demo.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "persons")
public class Person {

  @Id
  @GeneratedValue
  private Integer id;
  private String name;

  // TODO: Change EAGER load, as it is considered anti-pattern
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "author", cascade = CascadeType.ALL)
  private List<Post> posts = new ArrayList<>();

}
