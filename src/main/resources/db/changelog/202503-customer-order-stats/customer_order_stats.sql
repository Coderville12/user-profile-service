

--create table
-- SQL schema for table customer_order_stats
CREATE TABLE IF NOT EXISTS customer_order_stats (
    customer_id BIGINT NOT NULL PRIMARY KEY,
    total_orders BIGINT,
    last_order_value DOUBLE,
    last_order_time TIMESTAMP,
    CONSTRAINT pk_customer_order_stats PRIMARY KEY (customer_id)
);
