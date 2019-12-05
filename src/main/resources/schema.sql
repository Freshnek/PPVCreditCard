--src/main/resources/schema.sql

CREATE TABLE `cards` (
    `number` VARCHAR(50) PRIMARY KEY,
    `limit` DECIMAL(13,2),
    `saldo` DECIMAL(13,2)
);