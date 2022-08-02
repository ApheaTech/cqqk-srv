package com.aphea.cqqksrv.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * TODO
 *
 * @author 航
 * @date 2022/8/2 13:39
 */
@Data
@ToString
public class DriverInfoVO {

    //序号（主键）
    private Integer id;
    //驾驶员编号
    private String drvCode;
    //驾驶员姓名
    private String name;
    //性别 1-男2-女
    private Integer sexType;
    //籍贯
    private String nativePlace;
    //出生日期
    private Date birthDate;
    //文化程度
    private String education;
    //民族
    private String nation;
    //参加工作时间
    private Date eginWorkDate;
    //初次领证时间
    private Date firstGetDate;
    //驾驶证证号
    private String drvLicNo;
    //驾驶证档案号
    private String drvLicRecordNo;
    //驾驶有效期(始)
    private Date drvLicBeginDate;
    //驾驶有效期(止)
    private Date drvLicEndDate;
    //准驾车型
    private String drvCarType;
    //技术等级
    private String technicLevel;
    //现工作单位ID
    private String deptId;
    //备注
    private String remark;
    //照片
    private String photoUrl;
    //内部准驾证号
    private String workLicNo;
    //准驾有效期(始)
    private Date workLicBeginDate;
    //准驾有效期(止)
    private Date workLicEndDate;
    //爱人名称
    private String mateName;
    //职业资格等级
    private String workLevel;
    //爱人工作单位
    private String mateWorkDept;
    //家庭现状
    private String familyInfo;
    //身份证图片
    private String idCardUrl;
    //驾驶证图片
    private String drvLicUrl;
    //准驾证图片
    private String drvPmtUrl;
    //调度状态 0-未用 1-正在使用
    private Integer status;
    //联系电话
    private String phone;
    //紧急联系人
    private String contactName;
    //紧急联系方式
    private String contactPhone;

    private String ppdmGuid;
    //有效标志
    private String activeInd;
    //生效日期
    private Date effectiveDate;
    //失效日期
    private Date expiryDate;
    //行更改人
    private String rowChangedBy;
    //行更改日期
    private Date rowChangedDate;
    //行创建人
    private String rowCreatedBy;
    //行创建日期
    private Date rowCreatedDate;
    //行有效日期
    private Date rowEffectiveDate;
    //行失效日期
    private Date rowExpiryDate;

    private String deptName;

    private String driverName;

}
