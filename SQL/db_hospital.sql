DROP DATABASE IF EXISTS db_hospital;
CREATE DATABASE db_hospital;
USE db_hospital;

SHOW DATABASES;

DROP TABLE IF EXISTS db_hospital.attendanca;
CREATE TABLE db_hospital.attendance (
  id              INT(10)                  AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK ID',
  employee_number INT(10)                  DEFAULT NULL
  COMMENT '员工工号',
  day             DATE                     DEFAULT NULL
  COMMENT '日期',
  time_type       ENUM ('上午', '下午', '加班')  DEFAULT NULL
  COMMENT '上班状态',
  start_time      TIME                     DEFAULT NULL
  COMMENT '上班时间',
  srart_type      ENUM ('正常', '迟到', '未签到') DEFAULT '未签到'
  COMMENT '上班出勤状态',
  end_time        TIME                     DEFAULT NULL
  COMMENT '下班时间',
  end_type        ENUM ('正常', '早退', '未签到') DEFAULT '未签到'
  COMMENT '下班出勤状态',
  work_type       ENUM ('上班', '请假')        DEFAULT NULL
  COMMENT '工作情况',
  notes           VARCHAR(255)             DEFAULT NULL
  COMMENT '日志'
)
  COMMENT '员工考勤表';

DROP TABLE IF EXISTS db_hospital.department;
CREATE TABLE db_hospital.department (
  id                INT(10)      AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK ID',
  department_number INT(10)      DEFAULT NULL
  COMMENT '部门编号',
  name              VARCHAR(20)  DEFAULT NULL
  COMMENT '部门名字',
  manager           VARCHAR(10)  DEFAULT NULL
  COMMENT '经理',
  telphone          VARCHAR(20)  DEFAULT NULL
  COMMENT '电话',
  address           VARCHAR(50)  DEFAULT NULL
  COMMENT '地址',
  notes             VARCHAR(255) DEFAULT NULL
  COMMENT '日志'
)
  COMMENT '部门';

DROP TABLE IF EXISTS db_hospital.employee;
CREATE TABLE db_hospital.employee (
  id                INT(10)         AUTO_INCREMENT PRIMARY KEY
  COMMENT '',
  employee_number   INT(10)         DEFAULT NULL
  COMMENT '',
  name              VARCHAR(10)     DEFAULT NULL
  COMMENT '',
  gender            ENUM ('男', '女') DEFAULT NULL
  COMMENT '',
  birthday          DATE            DEFAULT NULL
  COMMENT '',
  telphone          VARCHAR(20)     DEFAULT ''
  COMMENT '',
  email             VARCHAR(30)     DEFAULT ''
  COMMENT '',
  address           VARCHAR(50)     DEFAULT NULL
  COMMENT '',
  photo             VARCHAR(50)     DEFAULT ''
  COMMENT '',
  education         VARCHAR(20)     DEFAULT ''
  COMMENT '',
  department_number INT(10)         DEFAULT NULL
  COMMENT '',
  position_number   INT(10)         DEFAULT NULL
  COMMENT '',
  in_time           DATE            DEFAULT NULL
  COMMENT '',
  password          VARCHAR(20)     DEFAULT NULL
  COMMENT '',
  notes             VARCHAR(255)    DEFAULT NULL
  COMMENT ''
);
