package com.example.kafka.streams.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Slf4j
@Component
public class KafkaStreamInput {

  @Bean
  public Consumer<Flux<Message<String>>> sampleConsumer() {
    return flux -> flux
        .map(Message::getPayload)
        .doOnNext(s -> log.info("SampleConsumer | content: {}", s))
        .subscribe();
  }

  @Bean
  public Consumer<Flux<Message<String>>> sampleSeekConsumer() {
    return flux -> flux
        .map(Message::getPayload)
        .doOnNext(s -> log.info("SampleSeekConsumer | content: {}", s))
        .subscribe();
  }

}
