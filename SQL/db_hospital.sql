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
  COMMENT '部门地址',
  notes             VARCHAR(255) DEFAULT NULL
  COMMENT '日志'
)
  COMMENT '部门';

DROP TABLE IF EXISTS db_hospital.employee;
CREATE TABLE db_hospital.employee (
  id                INT(10)         AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK ID',
  employee_number   INT(10)         DEFAULT NULL
  COMMENT '员工编号',
  name              VARCHAR(10)     DEFAULT NULL
  COMMENT '姓名',
  gender            ENUM ('男', '女') DEFAULT NULL
  COMMENT '性别',
  birthday          DATE            DEFAULT NULL
  COMMENT '出生日期',
  telphone          VARCHAR(20)     DEFAULT ''
  COMMENT '电话',
  email             VARCHAR(30)     DEFAULT ''
  COMMENT '邮箱',
  address           VARCHAR(50)     DEFAULT NULL
  COMMENT '家庭地址',
  photo             VARCHAR(50)     DEFAULT ''
  COMMENT '照片',
  education         VARCHAR(20)     DEFAULT ''
  COMMENT '教育背景',
  department_number INT(10)         DEFAULT NULL
  COMMENT '部门编号',
  position_number   INT(10)         DEFAULT NULL
  COMMENT '科室门号',
  in_time           DATE            DEFAULT NULL
  COMMENT '入职时间',
  password          VARCHAR(20)     DEFAULT NULL
  COMMENT '密码',
  notes             VARCHAR(255)    DEFAULT NULL
  COMMENT '日志',
  KEY department_number(department_number),
  KEY title_number(position_number),
  KEY employee_number(employee_number)
)
  COMMENT '员工表';

DROP TABLE IF EXISTS db_hospital.histoy;
CREATE TABLE db_hospital.history (
  id                INT(10)                 AUTO_INCREMENT PRIMARY KEY
  COMMENT '',
  employee_number   INT(10)                 DEFAULT NULL
  COMMENT '',
  name              VARCHAR(10)             DEFAULT NULL
  COMMENT '',
  gender            ENUM ('男', '女')         DEFAULT NULL
  COMMENT '',
  brithday          DATE                    DEFAULT NULL
  COMMENT '',
  telephone         VARCHAR(20)             DEFAULT ''
  COMMENT '',
  email             VARCHAR(30)             DEFAULT ''
  COMMENT '',
  address           VARCHAR(50)             DEFAULT ''
  COMMENT '',
  photo             VARCHAR(50)             DEFAULT ''
  COMMENT '',
  education         VARCHAR(20)             DEFAULT ''
  COMMENT '',
  in_time           DATE                    DEFAULT NULL
  COMMENT '',
  out_time          DATE                    DEFAULT NULL
  COMMENT '',
  department_number INT(10)                 DEFAULT NULL
  COMMENT '',
  postion_number    INT(10)                 DEFAULT NULL
  COMMENT '',
  status            ENUM ('离职', '在职', '退休') DEFAULT NULL
  COMMENT '',
  home              VARCHAR(100)            DEFAULT ''
  COMMENT ''
);
