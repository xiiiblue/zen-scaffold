package com.bluexiii.zenscaffold.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by bluexiii on 28/08/2017.
 */
@Entity
@Table(name = "TD_B_PRODUCT", schema = "UCR_CEN1")
@Getter
@Setter
@ToString
public class TdBProduct {
    @Id
    private Long productId;
    private String productName;
    private String productExplain;
    private String productMode;
    private String netTypeCode;
    private String brandCode;
    private String groupBrandCode;
    private Long serviceId;
    private String productObjType;
    private String resTypeCode;
    private String declaredProductId;
    private String compTag;
    private String enableTag;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startAbsoluteDate;
    private Long startOffset;
    private String startUnit;
    private String endEnableTag;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endAbsoluteDate;
    private Long endOffset;
    private String endUnit;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    private Long minNumber;
    private Long maxNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    private String version;
    private String productState;
    private String updateStaffId;
    private String updateDepartId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    private String prepayTag;
    private String needExp;
    private String productAppType;
    private String prodId;
    private String rsrvValue1;
    private String rsrvValue2;
    private String rsrvValue3;
    private String rsrvValue4;
    private String rsrvValue5;
    private String provinceCode;
}
