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
  COMMENT '备注'
)
  COMMENT '员工考勤表';

DROP TABLE IF EXISTS db_hospital.department;
CREATE TABLE db_hospital.department (
  id                INT(10)      AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK ID',
  department_number INT(10)      DEFAULT NULL
  COMMENT '部门编号',
  name              VARCHAR(20)  DEFAULT NULL
  COMMENT '部门名称',
  manager           VARCHAR(10)  DEFAULT NULL
  COMMENT '部门经理',
  telephone          VARCHAR(20)  DEFAULT NULL
  COMMENT '电话',
  address           VARCHAR(50)  DEFAULT NULL
  COMMENT '部门地址',
  notes             VARCHAR(255) DEFAULT NULL
  COMMENT '备注'
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
  telephone          VARCHAR(20)     DEFAULT ''
  COMMENT '电话',
  email             VARCHAR(30)     DEFAULT ''
  COMMENT '邮箱',
  address           VARCHAR(50)     DEFAULT NULL
  COMMENT '籍贯',
  photo             VARCHAR(50)     DEFAULT ''
  COMMENT '照片',
  education         VARCHAR(20)     DEFAULT ''
  COMMENT '教育背景',
  department_number INT(10)         DEFAULT NULL
  COMMENT '部门编号',
  position_number   INT(10)         DEFAULT NULL
  COMMENT '职称编号',
  in_time           DATE            DEFAULT NULL
  COMMENT '入职时间',
  password          VARCHAR(20)     DEFAULT NULL
  COMMENT '密码',
  notes             VARCHAR(255)    DEFAULT NULL
  COMMENT '备注',
  KEY department_number(department_number),
  KEY title_number(position_number),
  KEY employee_number(employee_number)
)
  COMMENT '员工表';

DROP TABLE IF EXISTS db_hospital.history;
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
  COMMENT '籍贯',
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
  COMMENT '职称编号',
  status            ENUM ('离职', '在职', '退休') DEFAULT NULL
  COMMENT '状态',
  home              VARCHAR(100)            DEFAULT ''
  COMMENT '现居地址',
  note              VARCHAR(255)            DEFAULT ''
  COMMENT '备注'
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
  reason             VARCHAR(100)        DEFAULT NULL
  COMMENT '请假理由',
  type              ENUM ('事假', '病假')   DEFAULT NULL
  COMMENT '请假类型',
  manger            VARCHAR(10)         DEFAULT NULL
  COMMENT '经理',
  status            ENUM ('已批准', '未批准') DEFAULT '未批准'
  COMMENT '批准状态',
  notes             VARCHAR(255)        DEFAULT NULL
  COMMENT '备注'
)
  COMMENT '请假表';

DROP TABLE IF EXISTS db_hospital.move;
CREATE TABLE db_hospital.move (
  id              INT(10)      AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK ID',
  employee_number INT(10)      DEFAULT NULL
  COMMENT '员工编号',
  ago             INT(10)      DEFAULT NULL
  COMMENT '调动前部门',
  after           INT(10)      DEFAULT NULL
  COMMENT '调动后',
  time            DATETIME     DEFAULT NULL
  COMMENT '调动时间',
  manager         VARCHAR(10)  DEFAULT NULL
  COMMENT '经理',
  notes           VARCHAR(255) DEFAULT NULL
  COMMENT '备注'
)
  COMMENT '员工调动记录表';

DROP TABLE IF EXISTS db_hospital.overtime;
CREATE TABLE db_hospital.overtime (
  id                INT(10)      AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK ID',
  department_number INT(10)      DEFAULT NULL
  COMMENT '部门编号',
  employee_number   INT(10)      DEFAULT NULL
  COMMENT '员工编号',
  day               DATE         DEFAULT NULL
  COMMENT '日期',
  start_time        TIME         DEFAULT NULL
  COMMENT '开始时间',
  end_time          TIME         DEFAULT NULL
  COMMENT '结束时间',
  notes             VARCHAR(255) DEFAULT NULL
  COMMENT '备注'
)
  COMMENT '加班表';

DROP TABLE IF EXISTS db_hospital.position;
CREATE TABLE db_hospital.position (
  id              INT(10)                                 AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK ID',
  position_number INT(10)                                 DEFAULT NULL
  COMMENT '职称编号',
  name            VARCHAR(20)                             DEFAULT NULL
  COMMENT '职称名称',
  level           ENUM ('部门主任', '部门员工', '人事部主任', '人事部员工') DEFAULT NULL
  COMMENT '级别',
  notes           VARCHAR(255)                            DEFAULT NULL
  COMMENT '备注',
  KEY position_number(position_number)
)
  COMMENT '职称表';

DROP TABLE IF EXISTS db_hospital.rewards_punishment;
CREATE TABLE db_hospital.rewards_punishment (
  id              INT(10)      AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK ID',
  employee_number INT(10)      DEFAULT NULL
  COMMENT '员工编号',
  type            VARCHAR(10)  DEFAULT NULL
  COMMENT '类型',
  reason          VARCHAR(100) DEFAULT NULL
  COMMENT '原因',
  money           FLOAT(8, 0)  DEFAULT NULL
  COMMENT '金额',
  time            DATETIME(6)  DEFAULT NULL
  COMMENT '时间',
  manager         VARCHAR(10)  DEFAULT NULL
  COMMENT '经理',
  notes           VARCHAR(200) DEFAULT NULL
  COMMENT '备注',
  KEY employee_number (employee_number),
  CONSTRAINT rewards_punishment_ibfk_1 FOREIGN KEY (employee_number) REFERENCES employee (employee_number)
)
  COMMENT '奖罚记录表';

# 注:
# before 是 MySQL 保留字. 换成 ago .
# 或者使用 ``
SELECT *
FROM attendance;

INSERT INTO `attendance` VALUES ('1', '1001', '2017-07-07', '下午', '17:01:33', '迟到', '17:25:15', '早退', NULL, NULL);
INSERT INTO `attendance` VALUES ('2', '1001', '2017-07-08', '上午', '08:53:43', '正常', '11:20:46', '早退', NULL, NULL);
INSERT INTO `attendance` VALUES ('3', '1001', '2017-07-08', '下午', '14:25:17', '正常', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES ('4', '1009', '2017-07-10', '上午', '10:29:35', '迟到', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES ('5', '1009', '2017-07-10', '下午', '16:42:01', '迟到', '16:42:25', '早退', NULL, NULL);
INSERT INTO `attendance` VALUES ('6', '1009', '2017-07-10', '加班', '19:31:46', '正常', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES ('7', '1009', '2017-07-11', '上午', '09:21:13', '迟到', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES ('8', '1009', '2017-07-12', '上午', '09:09:53', '迟到', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES ('9', '1009', '2017-07-12', '下午', '15:31:03', '迟到', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES ('10', '1001', '2017-07-12', '下午', '15:34:58', '迟到', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES ('11', '1007', '2017-07-12', '下午', '15:51:24', '迟到', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES ('12', '1008', '2017-07-12', '下午', '16:48:03', '迟到', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES ('13', '1009', '2017-07-12', '加班', '21:02:35', '迟到', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES ('14', '1010', '2017-07-12', '加班', '21:24:34', '迟到', NULL, '未签到', NULL, NULL);

SELECT *
FROM department;
INSERT INTO `department` VALUES ('1', '2001', '急诊科', '王生安', '0923-3456180', '住院楼101', '');
INSERT INTO `department` VALUES ('2', '2002', '骨科', '贺易', '0923-3456324', '门诊楼304', '');
INSERT INTO `department` VALUES ('3', '2003', '内分泌科  ', '周卓浩', '0923-3456909', '门诊楼205', '');
INSERT INTO `department` VALUES ('4', '2004', '神经内科 ', '何刚名', '0923-3456231', '门诊楼109', '');
INSERT INTO `department` VALUES ('5', '2005', '神经外科', '王成文 ', '0923-3456782', '门诊楼102', '');
INSERT INTO `department` VALUES ('6', '2006', '消化内科 ', '严席华', '0923-3456098', '门诊楼201', '');
INSERT INTO `department` VALUES ('7', '2007', '检验科', '云介融 ', '0923-3456143', '医技楼104', '');
INSERT INTO `department` VALUES ('8', '2008', '体检中心 ', '范湖', '0923-3456677', '医技楼203', '');
INSERT INTO `department` VALUES ('9', '2009', '放射科  ', '吴敬序', '0923-3456489', '医技楼305', '');
INSERT INTO `department` VALUES ('10', '2010', '护理部    ', '凌月青', '0923-3456210', '住院楼109', '');
INSERT INTO `department` VALUES ('11', '2011', '康复理疗科 ', '丁频佟', '0923-3456724', '医技楼208', '');
INSERT INTO `department` VALUES ('12', '2012', '药剂科', '王缘', '0923-3456423', '医技楼302', '');
INSERT INTO `department` VALUES ('13', '2013', '人事部', '李烨', '0923-2456123', '办公楼108', '');

SELECT *
FROM employee;
INSERT INTO `employee` VALUES
  ('1', '1001', 'admin', '男', '1995-10-18', '15678015439', '123@qq.com', '北京朝阳', '照片', '本科', '2013', '3009', '2017-02-22', 'admin', '');
INSERT INTO `employee` VALUES
  ('2', '1007', '李烨', '女', '1996-03-04', '18907327612', '', NULL, '', '', '2001', '3003', '2017-01-10', '1007', '');
INSERT INTO `employee`
VALUES ('3', '1008', '刘旭亮', '男', '1995-06-06', '13464238971', '', '', '', '', '2007', '3003', '2017-06-28', '1008', '');
INSERT INTO `employee`
VALUES ('4', '1009', '张彤', '男', '1995-09-24', '15810239904', '', '', '', '', '2013', '3009', '2017-02-06', '1009', '');
INSERT INTO `employee`
VALUES ('5', '1010', '杨杰', '男', '1995-01-26', '17871239756', '', '', '', '', '2013', '3010', '2017-05-12', '1010', '');
INSERT INTO `employee` VALUES
  ('6', '1011', '唐治涛', '男', '1995-03-29', '18832013916', '', '河北沧州', NULL, '大学本科', '2007', '3003', '2017-07-05', 'tzt4',
   '');
INSERT INTO `employee` VALUES
  ('7', '1012', '张璐', '男', '1997-03-04', '18832050264', '', '河北张家口', NULL, '大学本科', '2013', '3009', '2017-07-05',
   'zhanglu', '');

SELECT *
FROM history;
INSERT INTO `history` VALUES
  ('1', '1001', 'admin', '男', '1995-10-18', '15678015439', '', '', '', '', '2017-02-22', NULL, '2001', '3002', '在职', '',
   '');
INSERT INTO `history` VALUES
  ('2', '1002', '王秀英', '女', '1992-03-08', '15590678821', '', '', '', '', '2011-04-29', '2017-07-04', '2011', '3004',
   '离职', '', '');
INSERT INTO `history` VALUES
  ('3', '1003', '李强', '男', '1993-12-22', '18929778634', '', '', '', '', '2010-05-06', '2017-07-05', '2010', '3007',
   '退休', '', '');
INSERT INTO `history` VALUES
  ('4', '1004', '刘洋', '男', '1991-07-26', '13807987324', '', '', '', '', '2009-12-23', '2017-07-04', '2009', '3005',
   '退休', '', '');
INSERT INTO `history` VALUES
  ('5', '1005', '李敏', '女', '1991-01-03', '13791826142', '', '', '', '', '2010-03-29', '2017-07-05', '2008', '3004',
   '退休', '', '');
INSERT INTO `history` VALUES
  ('6', '1006', '王伟 ', '女', '1990-06-12', '13986207926', '', '', '', '', '2010-10-12', '2017-07-06', '2012', '3005',
   '离职', '', '');
INSERT INTO `history` VALUES
  ('7', '1007', '李烨', '女', '1996-03-04', '18907327612', '', '', '', '', '2017-01-10', NULL, '2001', '3003', '离职', '',
   '');
INSERT INTO `history` VALUES
  ('8', '1008', '刘旭亮', '男', '1995-06-00', '13464238971', '', '', '', '', '2017-06-28', NULL, '2002', '3001', '在职', '',
   '');
INSERT INTO `history` VALUES
  ('9', '1009', '张彤', '男', '1995-09-24', '15810239904', '', '', '', '', '2017-02-06', NULL, '2002', '3003', '在职', '',
   '');
INSERT INTO `history` VALUES
  ('10', '1010', '杨杰', '男', '1995-01-26', '17871239756', '', '', '', '', '2017-05-12', NULL, '2003', '3003', '在职', '',
   '');
INSERT INTO `history` VALUES
  ('11', '1011', '唐治涛', '男', '1995-03-29', '18832013916', '819564344@qq.com', '河北沧州', '', '大学本科', '2017-07-05', NULL,
   '2010', '3006', '在职', '', '');
INSERT INTO `history` VALUES
  ('12', '1012', '张璐', '男', '1997-03-11', '18832050264', '1215959210@qq.com', '河北省张家口', '', '本科', '2017-07-05', NULL,
   '2009', '3004', '在职', '', '');

SELECT *
FROM db_hospital.leave;

INSERT INTO `leave` VALUES ('1', '1007', '2007', '2017-07-11', '2017-07-12', '1', '家中有事', '事假', null, '未批准', null);
INSERT INTO `leave` VALUES ('2', '1008', '2007', '2017-07-10', '2017-07-12', '2', '偶感风寒', '病假', null, '已批准', null);
INSERT INTO `leave` VALUES ('3', '1011', '2007', '2017-07-11', '2017-07-11', '1', '回家看看', '事假', null, '已批准', null);
INSERT INTO `leave` VALUES ('7', '1008', '2007', '2017-07-14', '2017-07-17', '3', '真的有点事', '事假', null, '已批准', null);
INSERT INTO `leave` VALUES ('8', '1009', '2013', '2017-07-05', '2017-07-06', '1', '回家看看', '事假', null, '已批准', null);
INSERT INTO `leave` VALUES ('9', '1012', '2013', '2017-07-08', '2017-07-08', '1', '摊上事了', '事假', null, '未批准', null);
INSERT INTO `leave` VALUES ('10', '1012', '2013', '2017-07-13', '2017-07-14', '1', '真的有点事', '事假', null, '已批准', null);


SELECT *
FROM move;

INSERT INTO `move` VALUES ('1', '1011', '2010', '2011', '2017-07-10 20:40:20', '张彤', null);
INSERT INTO `move` VALUES ('3', '1007', '2001', '2007', '2017-07-11 09:53:34', '张彤', null);

SELECT *
FROM overtime;

INSERT INTO `overtime` VALUES ('1', '2007', '1007', '2017-07-12', null, null, null);
INSERT INTO `overtime` VALUES ('2', '2001', '1008', '2017-07-12', null, null, null);
INSERT INTO `overtime` VALUES ('3', '2013', '1012', '2017-07-12', null, null, null);
INSERT INTO `overtime` VALUES ('4', '2003', '1010', '2017-07-12', null, null, null);
INSERT INTO `overtime` VALUES ('8', '2011', '1011', '2017-07-14', null, null, null);

SELECT *
FROM position;
INSERT INTO `position` VALUES ('1', '3001', '主任医师', '部门主任', '');
INSERT INTO `position` VALUES ('2', '3002', '副主任医师', '部门员工', '');
INSERT INTO `position` VALUES ('3', '3003', '医师', '部门员工', '');
INSERT INTO `position` VALUES ('4', '3004', '主任技师', '部门主任', '');
INSERT INTO `position` VALUES ('5', '3005', '副主任技师', '部门员工', '');
INSERT INTO `position` VALUES ('6', '3006', '技师', '部门员工', '');
INSERT INTO `position` VALUES ('7', '3007', '护士长', '部门主任', '');
INSERT INTO `position` VALUES ('8', '3008', '护士', '部门员工', '');
INSERT INTO `position` VALUES ('9', '3009', '人事部主任', '人事部主任', '');
INSERT INTO `position` VALUES ('10', '3010', '人事部员工', '人事部员工', '');
INSERT INTO `position` VALUES ('11', '1001', '人事部主任', '人事部主任', '');
