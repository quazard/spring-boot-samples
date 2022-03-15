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
        .doOnEach(m -> log.info("incoming event"))
        .map(Message::getPayload)
        .doOnNext(s -> log.info("content: {}", s))
        .subscribe();
  }

}
