-- Dumping structure for table qlessdb.role

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_top_actif` bit(1) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjuqcxi07jmwxksjjokolg6jc7` (`company_id`),
  CONSTRAINT `FKjuqcxi07jmwxksjjokolg6jc7` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table qlessdb.role: ~5 rows (approximately)
INSERT INTO `role` (`id`, `role_name`, `role_top_actif`, `company_id`) VALUES
	(102, 'Admin', b'1', null)