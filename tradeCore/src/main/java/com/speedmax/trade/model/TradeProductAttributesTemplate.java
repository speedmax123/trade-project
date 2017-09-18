package com.speedmax.trade.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbl_product_attributes_template")
public class TradeProductAttributesTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String prodAttrTplName;
    private String prodAttrTplType;
    private long prodTypeId;
    private Date prodAttrTplCreateTime;
    private Date prodAttrTplModifyTime;
    private long prodAttrTplStatus;
}
