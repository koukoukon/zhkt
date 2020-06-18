/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : zhkt

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 18/06/2020 15:45:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu`  (
  `menu_id` int(0) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名称',
  `menu_pid` int(0) NOT NULL COMMENT '自关联',
  `menu_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '第一位,补位.之后每三位代表一个级别菜单编号',
  `menu_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '#' COMMENT '菜单链接',
  `menu_target` int(0) NULL DEFAULT 0 COMMENT '0:本系统 1:外链',
  `menu_min_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单小图标',
  `menu_max_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单大图标',
  `menu_show` int(0) NOT NULL DEFAULT 0 COMMENT '0:显示型菜单 1:非显示型菜单',
  `menu_order` tinyint(0) NOT NULL DEFAULT 1 COMMENT '菜单排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_menu
-- ----------------------------
INSERT INTO `system_menu` VALUES (1, '系统管理', 0, '1001', '#', 0, NULL, NULL, 0, 1);
INSERT INTO `system_menu` VALUES (2, '角色管理', 1, '1001001', 'role/manage.html', 0, NULL, NULL, 0, 1);
INSERT INTO `system_menu` VALUES (3, '新建角色', 2, '1001001001', 'role/add.html', 0, NULL, NULL, 1, 1);
INSERT INTO `system_menu` VALUES (4, '编辑角色', 2, '1001001002', 'role/edit.html', 0, NULL, NULL, 1, 1);
INSERT INTO `system_menu` VALUES (5, '设置角色状态', 2, '1001001003', 'role/status.html', 0, NULL, NULL, 1, 1);
INSERT INTO `system_menu` VALUES (6, '设置角色权限', 2, '1001001004', 'role/set.html', 0, NULL, NULL, 1, 1);
INSERT INTO `system_menu` VALUES (7, '用户管理', 1, '1001002', 'user/manage.html', 0, NULL, NULL, 0, 2);
INSERT INTO `system_menu` VALUES (8, '新增用户', 7, '1001002001', 'user/add.html', 0, NULL, NULL, 1, 1);
INSERT INTO `system_menu` VALUES (9, '导入用户', 7, '1001002002', 'user/import.html', 0, NULL, NULL, 1, 1);
INSERT INTO `system_menu` VALUES (10, '编辑用户', 7, '1001002003', 'user/edit.html', 0, NULL, NULL, 1, 1);

-- ----------------------------
-- Table structure for system_organization
-- ----------------------------
DROP TABLE IF EXISTS `system_organization`;
CREATE TABLE `system_organization`  (
  `organization_id` int(0) NOT NULL AUTO_INCREMENT,
  `organization_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `organization_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组织结构编号，第一位为补位，',
  `organization_pid` int(0) NULL DEFAULT NULL COMMENT '自关联',
  `organization_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '0:正常 1:禁用',
  PRIMARY KEY (`organization_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_organization
-- ----------------------------
INSERT INTO `system_organization` VALUES (1, '信息工程系', '101', 0, '0');
INSERT INTO `system_organization` VALUES (2, '计算机应用技术', '10101', 1, '0');
INSERT INTO `system_organization` VALUES (3, '2018级Java开发1班', '1010101', 2, '0');
INSERT INTO `system_organization` VALUES (4, '教师教育系', '102', 0, '0');
INSERT INTO `system_organization` VALUES (5, '学前教育', '10201', 4, '0');
INSERT INTO `system_organization` VALUES (6, '2019级学前教育1班', '1020101', 5, '0');
INSERT INTO `system_organization` VALUES (7, '软件开发', '1010102', 2, '0');

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role`  (
  `role_id` int(0) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `role_default` int(0) NOT NULL DEFAULT 0 COMMENT '0:用户创建的 1:系统内置的',
  `role_status` int(0) NOT NULL DEFAULT 0 COMMENT '0:有效 1:禁用',
  `role_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户描述',
  `role_create_user_pid` int(0) NULL DEFAULT NULL COMMENT '创建人id',
  `role_create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `role_edit_user_pid` int(0) NULL DEFAULT NULL COMMENT '修改人id',
  `role_edit_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES (1, '管理员', 1, 0, '系统内置管理员,拥有所有权限', 0, '2020-06-03 12:49:16', 1, '2020-06-17 10:15:35');
INSERT INTO `system_role` VALUES (2, '默认角色', 1, 0, '系统内置空权限的角色', 0, '2020-06-08 10:51:32', 1, '2020-06-16 16:42:28');
INSERT INTO `system_role` VALUES (3, 'a', 0, 1, 'b', 1, '2020-06-17 10:37:43', 1, '2020-06-18 15:34:12');
INSERT INTO `system_role` VALUES (4, '测试角色', 0, 0, '供系统测试使用', 1, '2020-06-18 15:12:55', NULL, NULL);
INSERT INTO `system_role` VALUES (7, '编辑角色', 0, 0, 'bbbadwad编辑', 1, '2020-06-18 15:17:03', 1, '2020-06-18 15:38:42');
INSERT INTO `system_role` VALUES (8, 'wadwa', 0, 0, 'awdwadaw', 1, '2020-06-18 15:17:07', NULL, NULL);
INSERT INTO `system_role` VALUES (9, 'awd', 0, 0, 'wadwada', 1, '2020-06-18 15:17:09', NULL, NULL);
INSERT INTO `system_role` VALUES (10, 'awdwadw', 0, 0, 'adwadaw', 1, '2020-06-18 15:17:12', NULL, NULL);
INSERT INTO `system_role` VALUES (11, 'wad', 0, 0, 'wadwadwa', 1, '2020-06-18 15:17:15', NULL, NULL);
INSERT INTO `system_role` VALUES (12, '测试角色2', 0, 1, '考试测试角色', 1, '2020-06-18 15:19:49', 1, '2020-06-18 15:29:51');
INSERT INTO `system_role` VALUES (13, '2', 0, 0, '2', 1, '2020-06-18 15:20:09', NULL, NULL);
INSERT INTO `system_role` VALUES (14, 'dawdaw', 0, 0, 'wa', 1, '2020-06-18 15:22:14', NULL, NULL);
INSERT INTO `system_role` VALUES (15, 'w', 0, 0, 'dwadaw', 1, '2020-06-18 15:23:16', NULL, NULL);
INSERT INTO `system_role` VALUES (16, 'awd', 0, 0, 'wadwad', 1, '2020-06-18 15:24:12', NULL, NULL);
INSERT INTO `system_role` VALUES (17, 'wa', 0, 0, 'dwadwa', 1, '2020-06-18 15:24:40', NULL, NULL);
INSERT INTO `system_role` VALUES (18, '考试角色', 0, 0, '考试测试', 1, '2020-06-18 15:26:26', NULL, NULL);

-- ----------------------------
-- Table structure for system_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_role_menu`;
CREATE TABLE `system_role_menu`  (
  `role_menu_id` int(0) NOT NULL AUTO_INCREMENT,
  `role_pid` int(0) NULL DEFAULT NULL COMMENT '关联角色主键',
  `menu_pid` int(0) NULL DEFAULT NULL COMMENT '关联菜单主键',
  PRIMARY KEY (`role_menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 791 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_role_menu
-- ----------------------------
INSERT INTO `system_role_menu` VALUES (1, 1, 1);
INSERT INTO `system_role_menu` VALUES (2, 1, 2);
INSERT INTO `system_role_menu` VALUES (3, 1, 3);
INSERT INTO `system_role_menu` VALUES (4, 1, 4);
INSERT INTO `system_role_menu` VALUES (5, 1, 5);
INSERT INTO `system_role_menu` VALUES (6, 1, 6);
INSERT INTO `system_role_menu` VALUES (7, 1, 7);
INSERT INTO `system_role_menu` VALUES (8, 1, 8);
INSERT INTO `system_role_menu` VALUES (9, 1, 9);
INSERT INTO `system_role_menu` VALUES (10, 1, 10);
INSERT INTO `system_role_menu` VALUES (792, 7, 1);
INSERT INTO `system_role_menu` VALUES (793, 7, 2);
INSERT INTO `system_role_menu` VALUES (794, 7, 3);
INSERT INTO `system_role_menu` VALUES (795, 7, 4);
INSERT INTO `system_role_menu` VALUES (796, 7, 5);
INSERT INTO `system_role_menu` VALUES (797, 7, 6);
INSERT INTO `system_role_menu` VALUES (798, 4, 1);
INSERT INTO `system_role_menu` VALUES (799, 4, 2);
INSERT INTO `system_role_menu` VALUES (800, 4, 3);
INSERT INTO `system_role_menu` VALUES (801, 4, 4);
INSERT INTO `system_role_menu` VALUES (802, 4, 5);
INSERT INTO `system_role_menu` VALUES (803, 4, 6);

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '真实姓名',
  `user_password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `user_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号',
  `user_number` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '工号或学号',
  `organization_pid` int(0) NOT NULL COMMENT '组织外键id',
  `role_pid` int(0) NOT NULL DEFAULT 0 COMMENT '角色外键id',
  `user_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '0:正常 1:禁用',
  `user_delete_flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '0:正常 1:删除',
  `user_create_user_pid` int(0) NULL DEFAULT NULL COMMENT '创建用户id',
  `user_create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `user_edit_user_pid` int(0) NULL DEFAULT NULL COMMENT '修改用户id',
  `user_edit_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES (1, 'admin', '114514', '17633875433', '18141301004', 0, 1, '0', '0', 0, '2020-06-03 12:58:35', NULL, NULL);
INSERT INTO `system_user` VALUES (2, 'user', '123456', '17633875433', '18141301004', 3, 2, '0', '0', 1, '2020-06-17 09:45:37', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
