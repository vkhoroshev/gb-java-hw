-- Создаем базу данных (если не существует)
CREATE DATABASE IF NOT EXISTS `lesson01` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
-- Устанавливаем ее по умолчанию
USE `lesson01`;

-- Удаляем таблицы (если существуют)
DROP TABLE IF EXISTS `towns`;
DROP TABLE IF EXISTS `town_types`;
DROP TABLE IF EXISTS `districts`;
DROP TABLE IF EXISTS `regions`;
DROP TABLE IF EXISTS `countries`;

-- Создаем таблицу стран
CREATE TABLE `countries` (
   `id` int unsigned NOT NULL AUTO_INCREMENT,
   `name` varchar(100) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `countries_name` (`name`)
 ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- Создаем таблицу областей
CREATE TABLE `regions` (
   `id` int unsigned NOT NULL AUTO_INCREMENT,
   `name` varchar(100) NOT NULL,
   `country_id` int unsigned NOT NULL,
   PRIMARY KEY (`id`),
   KEY `regions_country_id` (`country_id`),
   CONSTRAINT `regions_country_id` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`)
 ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- Создаем таблицу районов
CREATE TABLE `districts` (
   `id` int unsigned NOT NULL AUTO_INCREMENT,
   `name` varchar(100) NOT NULL,
   `region_id` int unsigned NOT NULL,
   PRIMARY KEY (`id`),
   KEY `districts_region_id` (`region_id`),
   CONSTRAINT `districts_region_id` FOREIGN KEY (`region_id`) REFERENCES `regions` (`id`)
 ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- Создаем таблицу типов городов
CREATE TABLE `town_types` (
   `id` int unsigned NOT NULL AUTO_INCREMENT,
   `name` varchar(100) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `town_types_name` (`name`)
 ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- Создаем таблицу городов
CREATE TABLE `towns` (
   `id` int unsigned NOT NULL AUTO_INCREMENT,
   `name` varchar(100) NOT NULL,
   `type_id` int unsigned NOT NULL,
   `district_id` int unsigned DEFAULT NULL,
   `region_id` int unsigned NOT NULL,
   PRIMARY KEY (`id`),
   KEY `towns_type_id` (`type_id`),
   KEY `towns_district_id` (`district_id`),
   KEY `towns_region_id` (`region_id`),
   CONSTRAINT `towns_type_id` FOREIGN KEY (`type_id`) REFERENCES `town_types` (`id`),
   CONSTRAINT `towns_district_id` FOREIGN KEY (`district_id`) REFERENCES `districts` (`id`),
   CONSTRAINT `towns_region_id` FOREIGN KEY (`region_id`) REFERENCES `regions` (`id`)
 ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
