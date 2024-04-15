CREATE TABLE `student` (
	`id` SERIAL NOT NULL COMMENT 'id',
	`st_id` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生番号',
	`name` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '学生名',
	`nyu_year` INT(10) COMMENT '入学年度',
	`class_id` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT 'クラス番号',
	`zaigaku` BOOLEAN DEFAULT NULL COMMENT '在学',
	`zai_co` CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '学校コード',
	PRIMARY KEY (`st_id`)
) ENGINE=InnoDB;
