DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

-- 用户
-- userType [0]管理员 [1]教职工 [2]学生 [3]访客
-- gender [0]女 [1]男 [2]保密
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id         INTEGER PRIMARY KEY          AUTO_INCREMENT,
  username   CHAR(50) UNIQUE NOT NULL,
  password   CHAR(50)        NOT NULL,
  userType   INTEGER                      DEFAULT 3,
  realName   CHAR(50)        NOT NULL,
  gender     INTEGER         NOT NULL     DEFAULT 2,
  mobile     CHAR(50),
  email      CHAR(50),
  createTime DATETIME        NOT NULL     DEFAULT current_timestamp,
  lastLogin  DATETIME,
  info       TEXT
)
  DEFAULT CHARSET = utf8;

-- 站内信
-- type 信件类型 默认为0 可用于标注特殊用途
DROP TABLE IF EXISTS mail;
CREATE TABLE mail (
  id         INTEGER  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  author     INTEGER  NOT NULL,
  receiver   INTEGER  NOT NULL,
  createTime DATETIME NOT NULL DEFAULT current_timestamp,
  isRead     BOOLEAN  NOT NULL DEFAULT FALSE,
  content    TEXT,
  type       INTEGER  NOT NULL DEFAULT 0,
  CONSTRAINT FOREIGN KEY (author) REFERENCES user (id)
    ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (receiver) REFERENCES user (id)
    ON DELETE CASCADE
)
  DEFAULT CHARSET = utf8;

-- 项目
DROP TABLE IF EXISTS project;
CREATE TABLE project (
  id         INTEGER   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  createBy   INTEGER   NOT NULL,
  createTime DATETIME  NOT NULL DEFAULT current_timestamp,
  title      CHAR(255) NOT NULL,
  info       TEXT,
  CONSTRAINT FOREIGN KEY (createBy) REFERENCES user (id)
    ON DELETE CASCADE
)
  DEFAULT CHARSET = utf8;

-- 项目-成员
DROP TABLE IF EXISTS project_user;
CREATE TABLE project_user (
  id         INTEGER  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  project    INTEGER  NOT NULL,
  user       INTEGER  NOT NULL,
  createTime DATETIME NOT NULL DEFAULT current_timestamp,
  CONSTRAINT FOREIGN KEY (project) REFERENCES project (id)
    ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (user) REFERENCES user (id)
    ON DELETE CASCADE
)
  DEFAULT CHARSET = utf8;

-- 工作流
-- status [0]未完成 [1]进行中 [2]已完成
DROP TABLE IF EXISTS workflow;
CREATE TABLE workflow (
  id         INTEGER  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  project    INTEGER  NOT NULL,
  createTime DATETIME NOT NULL DEFAULT current_timestamp,
  title      CHAR(255),
  info       TEXT,
  status     INTEGER  NOT NULL DEFAULT 0,
  CONSTRAINT FOREIGN KEY (project) REFERENCES project (id)
    ON DELETE CASCADE
)
  DEFAULT CHARSET = utf8;

# -- 代码仓库
# DROP TABLE IF EXISTS repository;
# CREATE TABLE repository (
#   id      INTEGER   NOT NULL AUTO_INCREMENT PRIMARY KEY,
#   project INTEGER   NOT NULL,
#   name    CHAR(255) NOT NULL,
#   info    TEXT,
#   CONSTRAINT FOREIGN KEY (project) REFERENCES project (id)
# )
#   DEFAULT CHARSET = utf8;
#
# -- 代码仓库的issue
# -- hint用于存储关闭issue时的注释
# DROP TABLE IF EXISTS issue;
# CREATE TABLE issue (
#   id         INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
#   repository INTEGER NOT NULL,
#   open       BOOLEAN          DEFAULT TRUE,
#   title      CHAR(255),
#   content    TEXT,
#   hint       TEXT,
#   CONSTRAINT FOREIGN KEY (repository) REFERENCES repository (id)
# )
#   DEFAULT CHARSET = utf8;
