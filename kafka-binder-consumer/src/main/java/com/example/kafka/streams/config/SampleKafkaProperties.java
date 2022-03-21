package com.example.kafka.streams.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "sample.kafka")
public class SampleKafkaProperties {

  private List<BinderSeek> seekList;

  @Setter
  @Getter
  public static class BinderSeek {
    private String binding;
    private long timestamp;
  }

}
