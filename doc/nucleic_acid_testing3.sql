
DROP TABLE IF EXISTS `tb_nat_0`;
CREATE TABLE `tb_nat_0` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `id_card_code` varchar(255) DEFAULT NULL COMMENT '身份证号码',
                            `sampling_date` varchar(20) DEFAULT NULL COMMENT '采样日期',
                            `sampling_time` datetime DEFAULT NULL COMMENT '采样时间',
                            `result_time` datetime DEFAULT NULL COMMENT '出结果的时间',
                            `result` varchar(1) DEFAULT '0' COMMENT '结果  0：已采样 1：阳性 2阴性 ',
                            PRIMARY KEY (`id`) USING BTREE,
                            KEY `idcard` (`id_card_code`) USING BTREE COMMENT '身份证',
                            KEY `idcardDate` (`id_card_code`,`sampling_date`) USING BTREE COMMENT '身份证-日期联合索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;


DROP TABLE IF EXISTS `tb_nat_1`;
CREATE TABLE `tb_nat_1` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `id_card_code` varchar(255) DEFAULT NULL COMMENT '身份证号码',
                            `sampling_date` varchar(20) DEFAULT NULL COMMENT '采样日期',
                            `sampling_time` datetime DEFAULT NULL COMMENT '采样时间',
                            `result_time` datetime DEFAULT NULL COMMENT '出结果的时间',
                            `result` varchar(1) DEFAULT '0' COMMENT '结果  0：已采样 1：阳性 2阴性 ',
                            PRIMARY KEY (`id`) USING BTREE,
                            KEY `idcard` (`id_card_code`) USING BTREE COMMENT '身份证',
                            KEY `idcardDate` (`id_card_code`,`sampling_date`) USING BTREE COMMENT '身份证-日期联合索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;


DROP TABLE IF EXISTS `tb_nat_2`;
CREATE TABLE `tb_nat_2` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `id_card_code` varchar(255) DEFAULT NULL COMMENT '身份证号码',
                            `sampling_date` varchar(20) DEFAULT NULL COMMENT '采样日期',
                            `sampling_time` datetime DEFAULT NULL COMMENT '采样时间',
                            `result_time` datetime DEFAULT NULL COMMENT '出结果的时间',
                            `result` varchar(1) DEFAULT '0' COMMENT '结果  0：已采样 1：阳性 2阴性 ',
                            PRIMARY KEY (`id`) USING BTREE,
                            KEY `idcard` (`id_card_code`) USING BTREE COMMENT '身份证',
                            KEY `idcardDate` (`id_card_code`,`sampling_date`) USING BTREE COMMENT '身份证-日期联合索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;


DROP TABLE IF EXISTS `tb_nat_3`;
CREATE TABLE `tb_nat_3` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `id_card_code` varchar(255) DEFAULT NULL COMMENT '身份证号码',
                            `sampling_date` varchar(20) DEFAULT NULL COMMENT '采样日期',
                            `sampling_time` datetime DEFAULT NULL COMMENT '采样时间',
                            `result_time` datetime DEFAULT NULL COMMENT '出结果的时间',
                            `result` varchar(1) DEFAULT '0' COMMENT '结果  0：已采样 1：阳性 2阴性 ',
                            PRIMARY KEY (`id`) USING BTREE,
                            KEY `idcard` (`id_card_code`) USING BTREE COMMENT '身份证',
                            KEY `idcardDate` (`id_card_code`,`sampling_date`) USING BTREE COMMENT '身份证-日期联合索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;


DROP TABLE IF EXISTS `tb_nat_4`;
CREATE TABLE `tb_nat_4` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `id_card_code` varchar(255) DEFAULT NULL COMMENT '身份证号码',
                            `sampling_date` varchar(20) DEFAULT NULL COMMENT '采样日期',
                            `sampling_time` datetime DEFAULT NULL COMMENT '采样时间',
                            `result_time` datetime DEFAULT NULL COMMENT '出结果的时间',
                            `result` varchar(1) DEFAULT '0' COMMENT '结果  0：已采样 1：阳性 2阴性 ',
                            PRIMARY KEY (`id`) USING BTREE,
                            KEY `idcard` (`id_card_code`) USING BTREE COMMENT '身份证',
                            KEY `idcardDate` (`id_card_code`,`sampling_date`) USING BTREE COMMENT '身份证-日期联合索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;