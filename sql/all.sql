use
seata;
CREATE TABLE `global_table`
(
    `xid`                       varchar(128) NOT NULL,
    `transaction_id`            bigint(20) DEFAULT NULL,
    `status`                    tinyint(4) NOT NULL,
    `application_id`            varchar(64)   DEFAULT NULL,
    `transaction_service_group` varchar(64)   DEFAULT NULL,
    `transaction_name`          varchar(64)   DEFAULT NULL,
    `timeout`                   int(11) DEFAULT NULL,
    `begin_time`                bigint(20) DEFAULT NULL,
    `application_data`          varchar(2000) DEFAULT NULL,
    `gmt_create`                datetime      DEFAULT NULL,
    `gmt_modified`              datetime      DEFAULT NULL,
    PRIMARY KEY (`xid`),
    KEY                         `idx_gmt_modified_status` (`gmt_modified`,`status`),
    KEY                         `idx_transaction_id` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `branch_table`
(
    `branch_id`         bigint(20) NOT NULL,
    `xid`               varchar(128) NOT NULL,
    `transaction_id`    bigint(20) DEFAULT NULL,
    `resource_group_id` varchar(32)   DEFAULT NULL,
    `resource_id`       varchar(256)  DEFAULT NULL,
    `lock_key`          varchar(128)  DEFAULT NULL,
    `branch_type`       varchar(8)    DEFAULT NULL,
    `status`            tinyint(4) DEFAULT NULL,
    `client_id`         varchar(64)   DEFAULT NULL,
    `application_data`  varchar(2000) DEFAULT NULL,
    `gmt_create`        datetime      DEFAULT NULL,
    `gmt_modified`      datetime      DEFAULT NULL,
    PRIMARY KEY (`branch_id`),
    KEY                 `idx_xid` (`xid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table `lock_table`
(
    `row_key`        varchar(128) not null,
    `xid`            varchar(96),
    `transaction_id` long,
    `branch_id`      long,
    `resource_id`    varchar(256),
    `table_name`     varchar(32),
    `pk`             varchar(32),
    `gmt_create`     datetime,
    `gmt_modified`   datetime,
    primary key (`row_key`)
);

USE
test;
CREATE TABLE `account_tbl`
(
    `id`      INT(11) NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(255) DEFAULT NULL,
    `money`   INT(11) DEFAULT 0,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO account_tbl (id, user_id, money)
VALUES (1, '1001', 10000);
INSERT INTO account_tbl (id, user_id, money)
VALUES (2, '1002', 10000);

CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP SCHEMA IF EXISTS db_order;
CREATE SCHEMA db_order;
USE
db_order;

CREATE TABLE `order_tbl`
(
    `id`             INT(11) NOT NULL AUTO_INCREMENT,
    `user_id`        VARCHAR(255) DEFAULT NULL,
    `commodity_code` VARCHAR(255) DEFAULT NULL,
    `count`          INT(11) DEFAULT '0',
    `money`          INT(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;