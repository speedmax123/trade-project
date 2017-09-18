package com.speedmax.trade.model;

import lombok.*;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbl_trade_user")
public class TradeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userType;
    private String email;
    private String username;
    private Long vipStatus;
    private Long authStep;
    private Long enable;
    private String password;
    private String dealpwd;
    private String mobilePhone;
    private String reffer;
    private Long rating;
    private Long creditRating;
    private String lastIp;
    private Date lastDate;
    private Date vipCreateTime;
    private Long creditLimit;
    private String headImg;
    private Date createTime;
    private String content;
    private double usableSum;
    private double freezeSum;
    private double dueInSum;
    private double dueOutSum;
    private Long agentId;
    private Long supervisorId;
    private Long groupId;
    private Long usableCreditLimit;
    private Long creditLimitation;
    private double vipFee;
    private Long feeStatus;
    private Long loginCount;
    private Date lockTime;
    private Long cashStatus;
    private double xMax;
    private double X;
    private double xMin;
    private Long isFirstVip;
    private String sign;
    private String sign2;
    private Long loginErrorCount;
    private Long isLoginLimit;
    private Long isApplyPro;
    private String continuousDays;
    private String sessionId;
    private Long controlSendTimes;
    private Long autoPayment;
    private Long msgTimes;

}
