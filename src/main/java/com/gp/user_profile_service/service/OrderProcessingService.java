package com.gp.user_profile_service.service;

import com.gp.user_profile_service.event.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(OrderProcessingService.class);

    public void processOrder(OrderEvent orderEvent) {
        logger.info("=== Processing Order ===");
        logger.info("Order ID: {}", orderEvent.getOrderId());
        logger.info("Customer ID: {}", orderEvent.getCustomerId());
        logger.info("Product: {}", orderEvent.getProductName());
        logger.info("Quantity: {}", orderEvent.getQuantity());
        logger.info("Amount: ${}", orderEvent.getAmount());
        logger.info("Status: {}", orderEvent.getStatus());
        logger.info("Order Date: {}", orderEvent.getOrderDate());

        // Add your business logic here
        // For example:
        // - Validate order
        // - Check inventory
        // - Process payment
        // - Update database
        // - Send notification

        try {
            // Simulate processing time
            Thread.sleep(100);

            // Business logic
            if ("CREATED".equals(orderEvent.getStatus())) {
                logger.info("Order {} is ready for processing", orderEvent.getOrderId());
                // Process the order
                validateOrder(orderEvent);
                checkInventory(orderEvent);
                updateOrderStatus(orderEvent);
            }

            logger.info("Order {} processed successfully", orderEvent.getOrderId());

        } catch (InterruptedException e) {
            logger.error("Processing interrupted for order {}", orderEvent.getOrderId(), e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            logger.error("Error processing order {}", orderEvent.getOrderId(), e);
            // Handle error - could republish to DLQ (Dead Letter Queue)
        }
    }

    private void validateOrder(OrderEvent order) {
        logger.debug("Validating order: {}", order.getOrderId());
        // Validation logic
        if (order.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid order amount");
        }
    }

    private void checkInventory(OrderEvent order) {
        logger.debug("Checking inventory for: {}", order.getProductName());
        // Inventory check logic
    }

    private void updateOrderStatus(OrderEvent order) {
        logger.debug("Updating order status to CONFIRMED: {}", order.getOrderId());
        // Database update logic
    }
}
