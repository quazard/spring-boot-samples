package com.example.kafka.streams.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.cloud.stream.binder.kafka.KafkaBindingRebalanceListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class KafkaConfig {

  private final SampleKafkaProperties sampleKafkaProperties;

  public KafkaConfig(
      final SampleKafkaProperties sampleKafkaProperties
  ) {
    this.sampleKafkaProperties = sampleKafkaProperties;
  }

  @Bean
  public KafkaBindingRebalanceListener kafkaBindingRebalanceListener() {
    return new KafkaBindingRebalanceListener() {

      @Override
      public void onPartitionsAssigned(
          final String bindingName,
          final Consumer<?, ?> consumer,
          final Collection<TopicPartition> partitions,
          final boolean initial
      ) {
        sampleKafkaProperties.getSeekList()
            .stream()
            .filter(binderSeek -> bindingName.equals(binderSeek.getBinding()))
            .map(
                binderSeek -> partitions.stream()
                    .collect(
                        Collectors.toMap(
                            Function.identity(),
                            topicPartition -> binderSeek.getTimestamp()
                        )
                    )
            )
            .map(consumer::offsetsForTimes)
            .map(Map::entrySet)
            .flatMap(Collection::stream)
            .forEach(
                entrySet -> {
                  log.info(
                      "Seek config on binder {} to topic {} partition {} offset {}",
                      bindingName,
                      entrySet.getKey().topic(),
                      entrySet.getKey().partition(),
                      entrySet.getValue().offset()
                  );

                  consumer.seek(entrySet.getKey(), entrySet.getValue().offset());
                }
            );
      }

    };
  }

}
