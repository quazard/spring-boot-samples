package com.example.kafka.streams.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class KafkaStreamOutput {

  public static final String SAMPLE_OUT = "sample-out";

  private final StreamBridge streamBridge;

  public KafkaStreamOutput(final StreamBridge streamBridge) {
    this.streamBridge = streamBridge;
  }

  public <T>Mono<Boolean> binderSupplier(
      final String binder,
      final T payload
  ) {
    return Mono.create(
        sink -> {
          try {
            Message<T> message = MessageBuilder.withPayload(payload).build();
            boolean isPublished = this.streamBridge.send(binder, message);

            if (isPublished) {
              log.info("payload published");
              sink.success(true);
            } else {
              log.error("payload was not published");
              sink.error(new RuntimeException("payload was not published"));
            }
          } catch (RuntimeException e) {
            log.error("Error publishing: {}", e.getMessage());
            sink.error(e);
          }
        }
    );
  }

}
