

--liquibase formatted sql
--changeset gunjan:004-create-customer-order-stats
CREATE TABLE IF NOT EXISTS customer_order_stats (
    customer_id BIGINT NOT NULL,
    total_orders BIGINT,
    last_order_value DOUBLE,
    last_order_time TIMESTAMP,
    PRIMARY KEY (customer_id)
);