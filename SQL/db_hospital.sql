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
  COMMENT 'PK ID',
  employee_number   INT(10)                 DEFAULT NULL
  COMMENT '员工编号',
  name              VARCHAR(10)             DEFAULT NULL
  COMMENT '姓名',
  gender            ENUM ('男', '女')         DEFAULT NULL
  COMMENT '性别',
  brithday          DATE                    DEFAULT NULL
  COMMENT '出生日期',
  telephone         VARCHAR(20)             DEFAULT ''
  COMMENT '电话',
  email             VARCHAR(30)             DEFAULT ''
  COMMENT '邮箱',
  address           VARCHAR(50)             DEFAULT ''
  COMMENT '家庭住址',
  photo             VARCHAR(50)             DEFAULT ''
  COMMENT '照片',
  education         VARCHAR(20)             DEFAULT ''
  COMMENT '教育背景',
  in_time           DATE                    DEFAULT NULL
  COMMENT '入职时间',
  out_time          DATE                    DEFAULT NULL
  COMMENT '离职时间',
  department_number INT(10)                 DEFAULT NULL
  COMMENT '部门编号',
  postion_number    INT(10)                 DEFAULT NULL
  COMMENT '科室门号',
  status            ENUM ('离职', '在职', '退休') DEFAULT NULL
  COMMENT '状态',
  home              VARCHAR(100)            DEFAULT ''
  COMMENT '现居地址'
)
  COMMENT '档案表';

DROP TABLE IF EXISTS db_hospital.leave;
CREATE TABLE db_hospital.leave (
  id                INT(10)             AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK ID',
  employee_number   INT(10)             DEFAULT NULL
  COMMENT '员工编号',
  department_number INT(10)             DEFAULT NULL
  COMMENT '部门编号',
  start_time        DATE                DEFAULT NULL
  COMMENT '起始日期',
  end_time          DATE                DEFAULT NULL
  COMMENT '结束日期',
  days              VARCHAR(10)         DEFAULT NULL
  COMMENT '天数',
  reson             VARCHAR(100)        DEFAULT NULL
  COMMENT '请假理由',
  type              ENUM ('事假', '病假')   DEFAULT NULL
  COMMENT '请假类型',
  manger            VARCHAR(10)         DEFAULT NULL
  COMMENT '经理',
  status            ENUM ('已批准', '未批准') DEFAULT '未批准'
  COMMENT '批准状态',
  notes             VARCHAR(255)        DEFAULT NULL
  COMMENT '日志'
)
  COMMENT '请假表';

DROP TABLE IF EXISTS db_hospital.move;
CREATE TABLE db_hospital.move (
  id              INT(10)      AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK ID',
  employee_number INT(10)      DEFAULT NULL
  COMMENT '员工编号',
  before          INT(10)      DEFAULT NULL
  COMMENT '调动前部门',
  after           INT(10)      DEFAULT NULL
  COMMENT '调动后',
  time            DATETIME     DEFAULT NULL
  COMMENT '调动时间',
  manager         VARCHAR(10)  DEFAULT NULL
  COMMENT '经理',
  notes           VARCHAR(255) DEFAULT NULL
  COMMENT '日志'
)
  COMMENT '员工调动记录表';

DROP TABLE IF EXISTS db_hospital.overtime;
CREATE TABLE db_hospital.overtime (
  id                INT(10)      AUTO_INCREMENT PRIMARY KEY
  COMMENT '',
  department_number INT(10)      DEFAULT NULL
  COMMENT '',
  employee_number   INT(10)      DEFAULT NULL
  COMMENT '',
  day               DATE         DEFAULT NULL
  COMMENT '',
  start_time        TIME         DEFAULT NULL
  COMMENT '',
  end_time          TIME         DEFAULT NULL
  COMMENT '',
  notes             VARCHAR(255) DEFAULT NULL
  COMMENT ''
)
  COMMENT '';
