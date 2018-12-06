/**
 * 客户资料表
 */
DROP TABLE IF EXISTS `td_customer`;
CREATE TABLE `td_customer` (
  `id`                    bigint(20)       NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `name`                  varchar(100)     DEFAULT NULL                  COMMENT '姓名',
  `sex`                   int(11)          DEFAULT NULL                  COMMENT '性别 1：男 2：女',
  `identity_card`         varchar(18)      DEFAULT NULL                  COMMENT '身份证号',
  `phone_number`          varchar(11)      DEFAULT NULL                  COMMENT '手机号码',
  `marriage_status`       int(11)          DEFAULT NULL                  COMMENT '婚姻状况(1:未婚,2:已婚,3:离异)',
  `educational_level`     int(11)          DEFAULT NULL                  COMMENT '教育水平 1：本科及以上 2：大专 3：高中 4：初中及以下',
  `address`               varchar(500)     DEFAULT NULL                  COMMENT '住址',
  `address_type`          int(11)          DEFAULT NULL                  COMMENT '住址类别 1：自置 2：亲属房 3：租赁',
  `address_axplain`       varchar(1024)    DEFAULT NULL                  COMMENT '住址说明',
  `hukou_type`            int(11)          DEFAULT NULL                  COMMENT '户口类型 1：深户:2：广东 3：外地',
  `estate`                int(11)          DEFAULT NULL                  COMMENT '房产状况 1：无 2：深圳商品房 3：深圳小产权房 4：非深商品房',
  `vehicle`               int(11)          DEFAULT NULL                  COMMENT '车辆状况 1：无 2:全款 3：按揭 4：押证 5：押车',
  `policy`                int(11)          DEFAULT NULL                  COMMENT '保单状况 1：无 2:1年 3:2年 4:3年',
  `business_id`           bigint(20)       DEFAULT NULL                  COMMENT '业务人员ID，关联用户ID',
  `provider_person`       varchar(100)     DEFAULT NULL                  COMMENT '供单人',
  `status`                int(11)          DEFAULT NULL                  COMMENT '状态 100：待申请、 101：待预审  1011：预审拒单、102：待面审  1021：面审拒单、103：待终审  1031：终审拒单、104：待考察 1041：考察拒单、105：待放款、106：还款中、107：已结清、108：逾期中、109：坏账客户',
  `remark`                varchar(1024)    DEFAULT NULL                  COMMENT '备注',
  `create_by`             bigint(20)       DEFAULT NULL                  COMMENT '创建人',
  `create_time`           datetime         NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`             bigint(20)       DEFAULT NULL                   COMMENT '更新人',
  `update_time`           datetime         NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                    int(11)          DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='客户资料表';
/**
 * 文件表
 */
DROP TABLE IF EXISTS `td_file`;
CREATE TABLE `td_file` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `ref_id`             bigint(20)         DEFAULT NULL                  COMMENT '关联业务id',
  `type`               int(11)            DEFAULT NULL                  COMMENT '文件所属类型 1：客户资料文件 2：经营资料文件 3：房产资料文件 4：车辆资料文件 5：保单资料文件 6：跟进记录文件',
  `name`               varchar(500)       DEFAULT NULL                  COMMENT '文件名称',
  `path`               varchar(1024)      DEFAULT NULL                  COMMENT '文件路径',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '文件表';

/**
 * 经营资料
 */
DROP TABLE IF EXISTS `td_business`;
CREATE TABLE `td_business` (
  `id`                  bigint(20)        NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`         bigint(20)        DEFAULT NULL                  COMMENT '客户id',
  `company_name`        varchar(100)      DEFAULT NULL                  COMMENT '公司名称',
  `setup_date`          datetime          DEFAULT NULL                  COMMENT '注册时间',
  `corporation`         int(11)           DEFAULT NULL                  COMMENT '是否公司法人 1：是 2：不是',
  `share_stock`         decimal(12,6)     DEFAULT NULL                  COMMENT '占股比例',
  `industry_type`       varchar(255)      DEFAULT NULL                  COMMENT '行业类别',
  `half_year_ticket`    decimal(12,2)     DEFAULT NULL                  COMMENT '近半年开票额，精确到万',
  `half_year_tax`       decimal(12,2)     DEFAULT NULL                  COMMENT '近半年纳税额，精确到万',
  `month_turnover`      decimal(12,3)     DEFAULT NULL                  COMMENT '月均营业额，精确到万',
  `employees_num`       int(11)           DEFAULT NULL                  COMMENT '员工人数',
  `social_num`          int(11)           DEFAULT NULL                  COMMENT '社保人数', 
  `company_address`     varchar(500)      DEFAULT NULL                  COMMENT '公司地址，地址控件',
  `address_explain`     varchar(2014)     DEFAULT NULL                  COMMENT '地址说明，说明面积，租金，租期',
  `remark`              varchar(1024)     DEFAULT NULL                  COMMENT '备注',
  `create_by`           bigint(20)        DEFAULT NULL                  COMMENT '创建人',
  `create_time`         datetime          NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`           bigint(20)        DEFAULT NULL                   COMMENT '更新人',
  `update_time`         datetime          NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                  int(11)           DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='经营资料';

/**
 * 房产资料
 */
DROP TABLE IF EXISTS `td_estate`;
CREATE TABLE `td_estate` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户id',
  `type`               int(11)            DEFAULT NULL                  COMMENT '房产类型 1：商品住宅 2：商住 3：商铺(内铺) 4：商铺(外铺) 5：安居房 6：军产房 7：统建房 8：自建房',
  `status`             int(11)            DEFAULT NULL                  COMMENT '房产状态 1：全款 2：按揭 3：转按 4：其他',
  `address`            varchar(1024)      DEFAULT NULL                  COMMENT '房产地址',
  `owner`              varchar(1024)      DEFAULT NULL                  COMMENT '业主，多人共有说明比例',
  `area`               decimal(12,4)      DEFAULT NULL                  COMMENT '面积',
  `purchase_time`      datetime           DEFAULT NULL                  COMMENT '购买时间',
  `buy_way`            int(11)            DEFAULT NULL                  COMMENT '购买方式 1：全款 2：按揭 3：其他',
  `down_payment`       decimal(20,3)      DEFAULT NULL                  COMMENT '首付款，精确到万',
  `pledge_bank`        varchar(255)       DEFAULT NULL                  COMMENT '当前质押机构',
  `pledge_time`        datetime           DEFAULT NULL                  COMMENT '质押时间',
  `loan_amount`        decimal(12,3)      DEFAULT NULL                  COMMENT '贷款金额',
  `loan_term`          int(11)            DEFAULT NULL                  COMMENT '贷款年限',
  `monthly_supply`     decimal(10,0)      DEFAULT NULL                  COMMENT '月供',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='房产资料';

/**
 * 车辆资料
 */
DROP TABLE IF EXISTS `td_vehicle`;
CREATE TABLE `td_vehicle` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `type`               int(11)            DEFAULT NULL                  COMMENT '车辆类型 1：本人名下 2：家属名下 3：公司名下',
  `status`             int(11)            DEFAULT NULL                  COMMENT '车辆状态 1：全款 2：按揭 3：押证 4：押车',
  `car_num_address`    varchar(1024)      DEFAULT NULL                  COMMENT '车牌地址，地址控件',
  `brand`              varchar(255)       DEFAULT NULL                  COMMENT '车辆品牌，控件',
  `car_number`         varchar(255)       DEFAULT NULL                  COMMENT '车牌号',
  `buy_way`            int(11)            DEFAULT NULL                  COMMENT '购买方式 1：全款 2：按揭 3：其他',
  `down_payment`       decimal(20,3)      DEFAULT NULL                  COMMENT '首付款，精确到万',
  `pledge_bank`        varchar(255)       DEFAULT NULL                  COMMENT '当前质押机构',
  `pledge_time`        datetime           DEFAULT NULL                  COMMENT '质押时间',
  `loan_amount`        decimal(12,3)      DEFAULT NULL                  COMMENT '贷款金额',
  `loan_year_limit`    int(11)            DEFAULT NULL                  COMMENT '贷款年限',
  `monthly_supply`     decimal(12,2)      DEFAULT NULL                  COMMENT '月供额度',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '车辆资料';

/**
 * 保单资料
 */
DROP TABLE IF EXISTS `td_policy`;
CREATE TABLE `td_policy` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `type`               int(11)            DEFAULT NULL                  COMMENT '保单类型 1：寿险 2：分红险 3：万能险',
  `status`             int(11)            DEFAULT NULL                  COMMENT '保单状态 1：正常 2：断交 3：结束',
  `buy_time`           datetime           DEFAULT NULL                  COMMENT '投保时间',
  `pay_way`            int(11)            DEFAULT NULL                  COMMENT '缴费方式 1：月缴 2：季缴 3：年缴',
  `pay_amount`         decimal(20,3)      DEFAULT NULL                  COMMENT '缴费金额',
  `company_name`       varchar(255)       DEFAULT NULL                  COMMENT '保险公司，控件',
  `explain`            varchar(1024)      DEFAULT NULL                  COMMENT '保单说明',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '保单资料';

/**
 * 联系人资料
 */
DROP TABLE IF EXISTS `td_contacts`;
CREATE TABLE `td_contacts` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `name`               varchar(255)       DEFAULT NULL                  COMMENT '姓名',
  `relation`           varchar(255)       DEFAULT NULL                  COMMENT '关系',
  `phone`              varchar(255)       DEFAULT NULL                  COMMENT '手机号码',
  `identity_card`      varchar(18)        DEFAULT NULL                  COMMENT '身份证号',
  `address`            varchar(1024)      DEFAULT NULL                  COMMENT '联系地址',
  `work_units`         varchar(1024)      DEFAULT NULL                  COMMENT '工作单位',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '联系人资料';

/**
 * 贷款申请表
 */
DROP TABLE IF EXISTS `td_loan_apply`;
CREATE TABLE `td_loan_apply` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `apply_amount`       decimal(20,3)      DEFAULT NULL                  COMMENT '申请额度',
  `apply_periods`      int(11)            DEFAULT NULL                  COMMENT '申请期数 6、9、12、15、18、24、30、36',
  `month_repay`        decimal(20,3)      DEFAULT NULL                  COMMENT '月还款能力',
  `require`            varchar(1024)      DEFAULT NULL                  COMMENT '贷款要求',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '贷款申请表';

/**
 * 审核总表
 */
DROP TABLE IF EXISTS `td_audit`;
CREATE TABLE `td_audit` (
  `id`                   bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`          bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `loan_apply_id`        bigint(20)         DEFAULT NULL                  COMMENT '贷款申请ID',
  `company_survey`       varchar(1024)      DEFAULT NULL                  COMMENT '公司调查,待面审状态必填：股东、关联公司、变更情况、设备、库存、口述等',
  `month_amount`         decimal(20,3)      DEFAULT NULL                  COMMENT '月均营业额,待面审状态必填',
  `month_amount_expain`  varchar(1024)      DEFAULT NULL                  COMMENT '月均营业额说明,待面审状态必填',
  `investigate`          varchar(1024)      DEFAULT NULL                  COMMENT '法诉调查,待面审状态必填',
  `folk_investigate`     varchar(1024)      DEFAULT NULL                  COMMENT '民间调查,待面审状态必填',
  `phone_verify`         varchar(1024)      DEFAULT NULL                  COMMENT '电核情况说明',
  `total_assets`         decimal(20,3)      DEFAULT NULL                  COMMENT '总资产认定，计算值，根据客户资产审核表计算',
  `total_liability`      decimal(20,3)      DEFAULT NULL                  COMMENT '总负债认定，计算值，根据客户负债审核表计算',
  `total_spending`       decimal(20,3)      DEFAULT NULL                  COMMENT '总支出认定，计算值，根据客户负债审核表计算',
  `month_income`         decimal(20,3)      DEFAULT NULL                  COMMENT '月收入认定，待面审状态必填',
  `month_income_explain` varchar(1024)      DEFAULT NULL                  COMMENT '月收入说明，待面审状态必填',
  `month_spending`       decimal(20,3)      DEFAULT NULL                  COMMENT '月支出认定，根据客户负债审核表计算',
  `query_count_explain`  varchar(1024)      DEFAULT NULL                  COMMENT '查询次数说明',
  `overdue_explain`      varchar(1024)      DEFAULT NULL                  COMMENT '逾期说明',
  `pre_audit_id`         bigint(20)         DEFAULT NULL                  COMMENT '预审人ID',
  `pre_audit_amount`     decimal(20,3)      DEFAULT NULL                  COMMENT '预审额度',
  `pre_audit_period`     int(11)            DEFAULT NULL                  COMMENT '预审期数 6、9、12、15、18、24、30、36',
  `pre_audit_opinion`    varchar(1024)      DEFAULT NULL                  COMMENT '预审意见',
  `pre_audit_status`     int(11)            DEFAULT NULL                  COMMENT '预审结果，101：待预审  1011：预审拒单 1012：预审退回',
  `face_audit_id`        bigint(20)         DEFAULT NULL                  COMMENT '面审人ID',
  `face_audit_amount`    decimal(20,3)      DEFAULT NULL                  COMMENT '面审额度',
  `face_audit_period`    int(11)            DEFAULT NULL                  COMMENT '面审期数 6、9、12、15、18、24、30、36',
  `face_audit_opinion`   varchar(1024)      DEFAULT NULL                  COMMENT '面审意见',
  `face_audit_status`     int(11)           DEFAULT NULL                  COMMENT '面审结果，102：待面审  1021：面审拒单 1022：面审退回',
  `final_audit_id`       bigint(20)         DEFAULT NULL                  COMMENT '终审人ID',
  `final_audit_amount`   decimal(20,3)      DEFAULT NULL                  COMMENT '终审额度',
  `final_audit_period`   int(11)            DEFAULT NULL                  COMMENT '终审期数 6、9、12、15、18、24、30、36',
  `final_audit_opinion`  varchar(1024)      DEFAULT NULL                  COMMENT '终审意见',
  `final_audit_status`   int(11)            DEFAULT NULL                  COMMENT '终审结果，103：待终审  1031：终审拒单 1032：终审退回',
  `inspect_id`           bigint(20)         DEFAULT NULL                  COMMENT '考察人ID',
  `inspect_amount`       decimal(20,3)      DEFAULT NULL                  COMMENT '考察额度',
  `inspect_period`       int(11)            DEFAULT NULL                  COMMENT '考察期数 6、9、12、15、18、24、30、36',
  `inspect_opinion`      varchar(1024)      DEFAULT NULL                  COMMENT '考察意见',
  `inspect_status`       int(11)            DEFAULT NULL                  COMMENT '考察结果，104：待考察  1041：考察拒单 1042：考察退回',
  /**`audit_status`         int(11)            DEFAULT NULL                  COMMENT '审核状态，同客户状态',**/
  `remark`               varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`            bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`          datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`            bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`          datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                   int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '审核总表';

/**
 * 流水记录表
 */
DROP TABLE IF EXISTS `td_flow_record`;
CREATE TABLE `td_flow_record` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `audit_id`           bigint(20)         DEFAULT NULL                  COMMENT '审核总表id',
  `type`               int(11)            DEFAULT NULL                  COMMENT '流水类型 1：对公 2：对私', 
  `flow_time`          datetime           DEFAULT NULL                  COMMENT '流水时间',
  `amount`             decimal(20,3)      DEFAULT NULL                  COMMENT '金额',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '流水记录表';

/**
 * 房产审核表
 */
DROP TABLE IF EXISTS `td_estate_audit`;
CREATE TABLE `td_estate_audit` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户id',
  `audit_id`           bigint(20)         DEFAULT NULL                  COMMENT '审核总表id',
  `estate_id`          bigint(20)         DEFAULT NULL                  COMMENT '房产资料id',
  `assess_value`       decimal(20,3)      DEFAULT NULL                  COMMENT '评估价值',
  `assess_explain`     varchar(1024)      DEFAULT NULL                  COMMENT '评估说明',
  `assess_time`        datetime           DEFAULT NULL                  COMMENT '评估时间',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='房产审核表';

/**
 * 车辆审核表
 */
DROP TABLE IF EXISTS `td_vehicle_audit`;
CREATE TABLE `td_vehicle_audit` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `audit_id`           bigint(20)         DEFAULT NULL                  COMMENT '审核总表id',
  `vehicle_id`         bigint(20)         DEFAULT NULL                  COMMENT '车辆资料id',
  `effecte_comfirm`    varchar(1024)      DEFAULT NULL                  COMMENT '有效性确认',
  `assess_value`       decimal(20,3)      DEFAULT NULL                  COMMENT '评估价值',
  `assess_explain`     varchar(1024)      DEFAULT NULL                  COMMENT '评估说明',
  `assess_time`        datetime           DEFAULT NULL                  COMMENT '评估时间',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '车辆审核表';


/**
 * 负债审核表
 */
DROP TABLE IF EXISTS `td_liability_audit`;
CREATE TABLE `td_liability_audit` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `audit_id`           bigint(20)         DEFAULT NULL                  COMMENT '审核总表id',
  `type`               int(11)            DEFAULT NULL                  COMMENT '负债类型 1：房贷 2：车贷 3：银行信用贷 4:金融信用贷 5：小额信用贷 6：网络信用贷 7：民间 8：亲友 9：信用卡',
  `loan_time`          datetime           DEFAULT NULL                  COMMENT '贷款时间',
  `loan_amount`        decimal(20,3)      DEFAULT NULL                  COMMENT '贷款额度，信用卡为总额',
  `loan_balance`       decimal(20,3)      DEFAULT NULL                  COMMENT '贷款余额，信用卡为近半年使用额',
  `loan_end_time`      datetime           DEFAULT NULL                  COMMENT '贷款结束时间',
  `month_repay_amount` decimal(20,3)      DEFAULT NULL                  COMMENT '月还款额度，信用卡为近半年使用额度*10%',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '负债审核表';

/**
 * 放款表
 */
DROP TABLE IF EXISTS `td_loan`;
CREATE TABLE `td_loan` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `loan_apply_id`      bigint(20)         DEFAULT NULL                  COMMENT '贷款申请ID',
  `audit_id`           bigint(20)         DEFAULT NULL                  COMMENT '审核总表id',
  `loan_time`          datetime           DEFAULT NULL                  COMMENT '放款时间',
  `loan_amount`        decimal(20,3)      DEFAULT NULL                  COMMENT '放款金额',
  `loan_rate`          decimal(20,3)      DEFAULT NULL                  COMMENT '放款利率',
  `loan_periods`       int(11)            DEFAULT NULL                  COMMENT '放款期数',
  `bad`                int(11)            DEFAULT NULL                  COMMENT '是否不良 1：否 2：是',
  `bad_time`           datetime           DEFAULT NULL                  COMMENT '不良产生的月份',
  `tiqian_settle`      int(11)            DEFAULT NULL                  COMMENT '提前结清 1：是  2：否',
  `settle_time`        datetime           DEFAULT NULL                  COMMENT '结清时间',
  `loan_contract_no`   varchar(500)       DEFAULT NULL                  COMMENT '放款合同编号',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '放款表';


/**
 * 还款计划表
 */
DROP TABLE IF EXISTS `td_repay_plan`;
CREATE TABLE `td_repay_plan` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `loan_id`            bigint(20)         DEFAULT NULL                  COMMENT '放款ID',
  `repay_periods`      int(11)            DEFAULT NULL                  COMMENT '还款期',
  `repay_date`         datetime           DEFAULT NULL                  COMMENT '还款日',
  `principal`          decimal(20,3)      DEFAULT NULL                  COMMENT '应还本金',
  `interest`           decimal(20,3)      DEFAULT NULL                  COMMENT '应还利息',
  `settle`             int(11)            DEFAULT NULL                  COMMENT '是否结清 1：是 2：否',
  `settle_time`        datetime           DEFAULT NULL                  COMMENT '结清时间',
  `overdue`            int(11)            DEFAULT NULL                  COMMENT '是否逾期 0：正常 1:1个月逾期 2:2个月逾期 3:3个月逾期 4：归入不良客户',
  `overdue_days`       int(11)            DEFAULT NULL                  COMMENT '逾期天数',
  `loan_contract_no`   varchar(500)       DEFAULT NULL                  COMMENT '放款合同编号',
  `delay_pay_amount`   decimal(20,3)      DEFAULT NULL                  COMMENT '滞纳金',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '还款计划表';

/**
 * 还款记录表
 */
DROP TABLE IF EXISTS `td_repay_record`;
CREATE TABLE `td_repay_record` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `repay_plan_id`      bigint(20)         DEFAULT NULL                  COMMENT '还款计划ID',
  `repay_amount`       decimal(20,3)      DEFAULT NULL                  COMMENT '还款金额',
  `repay_time`         datetime           DEFAULT NULL                  COMMENT '还款时间',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '还款记录表';

/**
 * 贷后跟进记录表
 */
DROP TABLE IF EXISTS `td_loan_post`;
CREATE TABLE `td_loan_post` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `loan_id`            bigint(20)         DEFAULT NULL                  COMMENT '放款ID',
  `follow_type`        int(11)            DEFAULT NULL                  COMMENT '跟进方式 1：电话 2：聊天工具 3：上门',
  `follow_context`     varchar(1024)      DEFAULT NULL                  COMMENT '跟进内容',
  `follow_time`        datetime           DEFAULT NULL                  COMMENT '跟进时间',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '贷后跟进记录表';


/**
 * 不良客户记录表
 */
DROP TABLE IF EXISTS `td_bad_record`;
CREATE TABLE `td_bad_record` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `customer_id`        bigint(20)         DEFAULT NULL                  COMMENT '客户ID',
  `loan_id`            bigint(20)         DEFAULT NULL                  COMMENT '放款ID',
  `bad_amount`         decimal(20,3)      DEFAULT NULL                  COMMENT '不良金额',
  `bad_time`           datetime           DEFAULT NULL                  COMMENT '坏账时间',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '不良客户记录表';


/**
 * 不良客户还款记录表
 */
DROP TABLE IF EXISTS `td_bad_repay`;
CREATE TABLE `td_bad_repay` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `bad_record_id`      bigint(20)         DEFAULT NULL                  COMMENT '不良客户ID',
  `repay_amount`       decimal(20,3)      DEFAULT NULL                  COMMENT '还款金额',
  `repay_time`         datetime           DEFAULT NULL                  COMMENT '还款时间',
  `collection_type`    int(11)            DEFAULT NULL                  COMMENT '催收方式 1：电话催收  2：上门催收 3：法诉催收 4：其他',
  `principal_id`       bigint(20)         DEFAULT NULL                  COMMENT '贷后负责人ID',
  `end`                int(11)            DEFAULT NULL                  COMMENT '结束标识 1：结束 2：没有结束',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '不良客户还款记录表';


/**
 * 不良客户还款记录表
 */
DROP TABLE IF EXISTS `td_bad_repay`;
CREATE TABLE `td_bad_repay` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `bad_record_id`      bigint(20)         DEFAULT NULL                  COMMENT '不良客户ID',
  `repay_amount`       decimal(20,3)      DEFAULT NULL                  COMMENT '还款金额',
  `repay_time`         datetime           DEFAULT NULL                  COMMENT '还款时间',
  `collection_type`    int(11)            DEFAULT NULL                  COMMENT '催收方式 1：电话催收  2：上门催收 3：法诉催收 4：其他',
  `principal_id`       bigint(20)         DEFAULT NULL                  COMMENT '贷后负责人ID',
  `end`                int(11)            DEFAULT NULL                  COMMENT '结束标识 1：结束 2：没有结束',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '不良客户还款记录表';


/**
 * 不良客户法诉记录表
 */
DROP TABLE IF EXISTS `td_bad_sue`;
CREATE TABLE `td_bad_sue` (
  `id`                 bigint(20)         NOT NULL      AUTO_INCREMENT  COMMENT '主键ID',
  `bad_record_id`      bigint(20)         DEFAULT NULL                  COMMENT '不良客户ID',
  `status`             int(11)            DEFAULT NULL                  COMMENT '当前状态 1：法诉提起、2：正式立案:3：已开庭:4：已判决:5：已执行:6：已列失信:7：已结束',
  `sue_date`           datetime           DEFAULT NULL                  COMMENT '起诉日期',
  `setup_date`         datetime           DEFAULT NULL                  COMMENT '立案日期',
  `hold_court_date`    datetime           DEFAULT NULL                  COMMENT '开庭日期',
  `sentence_date`      datetime           DEFAULT NULL                  COMMENT '判决日期',
  `execution_date`     datetime           DEFAULT NULL                  COMMENT '立执行日期',
  `apply_breach_date`  datetime           DEFAULT NULL                  COMMENT '申请失信日期',
  `sue_end_date`       datetime           DEFAULT NULL                  COMMENT '法诉结束日期',
  `notice`             datetime           DEFAULT NULL                  COMMENT '是否公告 1：是 2：否',
  `preser`             datetime           DEFAULT NULL                  COMMENT '是否财产保全',
  `sue_amount`         datetime           DEFAULT NULL                  COMMENT '诉讼费',
  `notice_amount`      datetime           DEFAULT NULL                  COMMENT '公告费',
  `preser_amount`      datetime           DEFAULT NULL                  COMMENT '财产保全担保费',
  `sue_preser_amount`  datetime           DEFAULT NULL                  COMMENT '财产保全法诉费',
  `attorney_amount`    datetime           DEFAULT NULL                  COMMENT '律师费',
  `other_amount`       datetime           DEFAULT NULL                  COMMENT '其他杂费',
  `total_amount`       datetime           DEFAULT NULL                  COMMENT '合计费用',
  `sue_back_amount`    datetime           DEFAULT NULL                  COMMENT '法诉收回费用',
  `remark`             varchar(1024)      DEFAULT NULL                  COMMENT '备注',
  `create_by`          bigint(20)         DEFAULT NULL                  COMMENT '创建人',
  `create_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by`          bigint(20)         DEFAULT NULL                   COMMENT '更新人',
  `update_time`        datetime           NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
  `yn`                 int(11)            DEFAULT '1'                   COMMENT '是否有效 1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT '不良客户法诉记录表';