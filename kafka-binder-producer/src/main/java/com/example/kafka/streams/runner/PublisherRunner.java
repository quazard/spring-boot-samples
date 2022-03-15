package com.example.kafka.streams.runner;

import com.example.kafka.streams.producer.KafkaStreamOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@Component
public class PublisherRunner implements ApplicationRunner {

  private final KafkaStreamOutput kafkaStreamOutput;

  public PublisherRunner(final KafkaStreamOutput kafkaStreamOutput) {
    this.kafkaStreamOutput = kafkaStreamOutput;
  }

  @Override
  public void run(ApplicationArguments args) {
    Flux.range(1, 40)
        .flatMap(
            i -> this.kafkaStreamOutput
                .binderSupplier(KafkaStreamOutput.SAMPLE_OUT, "content " + i)
        )
        .subscribe();
  }

}
