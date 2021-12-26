-- _countries
CREATE TABLE `_countries` (
   `id` int NOT NULL AUTO_INCREMENT,
   `title` varchar(150) NOT NULL,
   PRIMARY KEY (`id`),
   KEY `_countries_title` (`title`)
 ) ENGINE=InnoDB AUTO_INCREMENT=236 DEFAULT CHARSET=utf8mb3;

-- _regions
CREATE TABLE `_regions` (
   `id` int NOT NULL AUTO_INCREMENT,
   `country_id` int NOT NULL,
   `title` varchar(150) NOT NULL,
   PRIMARY KEY (`id`),
   KEY `fk_regions_country_idx` (`country_id`),
   KEY `_regions_title` (`title`),
   CONSTRAINT `fk_regions_country` FOREIGN KEY (`country_id`) REFERENCES `_countries` (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=5468685 DEFAULT CHARSET=utf8mb3;

-- _cities
CREATE TABLE `_cities` (
   `id` int NOT NULL AUTO_INCREMENT,
   `country_id` int NOT NULL,
   `important` tinyint(1) NOT NULL,
   `region_id` int DEFAULT NULL,
   `title` varchar(150) NOT NULL,
   PRIMARY KEY (`id`),
   KEY `fk_cities_country_id_idx` (`country_id`),
   KEY `fk_cities_region_id_idx` (`region_id`),
   KEY `_cities_title` (`title`),
   CONSTRAINT `fk_cities_country_id_idx` FOREIGN KEY (`country_id`) REFERENCES `_countries` (`id`),
   CONSTRAINT `fk_cities_region_id_idx` FOREIGN KEY (`region_id`) REFERENCES `_regions` (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=5469360 DEFAULT CHARSET=utf8mb3;
