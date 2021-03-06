package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.ResourceService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class ResourceController {

  private final ResourceService resourceService;

  public ResourceController(
      final ResourceService resourceService
  ) {
    this.resourceService = resourceService;
  }

  @QueryMapping
  public Flux<Person> persons() {
    return resourceService.findAllPersons();
  }

}
