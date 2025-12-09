package com.gp.user_profile_service.consumer;


import com.gp.user_profile_service.event.OrderEvent;
import com.gp.user_profile_service.service.OrderProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderEventConsumer.class);

    private final OrderProcessingService orderProcessingService;

    public OrderEventConsumer(OrderProcessingService orderProcessingService) {
        this.orderProcessingService = orderProcessingService;
    }

    // Simple listener
    @KafkaListener(
            topics = "${kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeOrderEvent(OrderEvent orderEvent) {
        logger.info("Received order event: {}", orderEvent);
        orderProcessingService.processOrder(orderEvent);
    }

    // Advanced listener with metadata
    @KafkaListener(
            topics = "${kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}-detailed",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeOrderEventDetailed(
            @Payload OrderEvent orderEvent,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {

        logger.info("┌─────────────────────────────────────────");
        logger.info("│ Received Message from Kafka");
        logger.info("├─────────────────────────────────────────");
        logger.info("│ Topic: {}", topic);
        logger.info("│ Partition: {}", partition);
        logger.info("│ Offset: {}", offset);
        logger.info("│ Timestamp: {}", timestamp);
        logger.info("│ Order: {}", orderEvent);
        logger.info("└─────────────────────────────────────────");

        orderProcessingService.processOrder(orderEvent);
    }

//    // Listener with manual acknowledgment (if needed)
//    @KafkaListener(
//            topics = "${kafka.topic.name}",
//            groupId = "${spring.kafka.consumer.group-id}-manual-ack",
//            containerFactory = "kafkaListenerContainerFactory"
//    )
//    public void consumeWithManualAck(
//            ConsumerRecord<String, OrderEvent> record,
//            Acknowledgment acknowledgment) {
//
//        try {
//            logger.info("Processing order from partition {} at offset {}",
//                    record.partition(), record.offset());
//
//            orderProcessingService.processOrder(record.value());
//
//            // Manually acknowledge after successful processing
//            if (acknowledgment != null) {
//                acknowledgment.acknowledge();
//                logger.info("Message acknowledged");
//            }
//
//        } catch (Exception e) {
//            logger.error("Error processing message, will not acknowledge", e);
//            // Message will be reprocessed
//        }
//    }
}
