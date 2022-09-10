package com.example.demo.model;

import org.springframework.data.annotation.Id;

public record Person(@Id Integer id, String name) {}
