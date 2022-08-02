package com.aphea.cqqksrv.entity.vo;

import com.aphea.cqqksrv.entity.CarInfo;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * TODO
 *
 * @author 航
 * @date 2022/8/2 11:45
 */
@Data
@ToString
public class CarInfoVO {

    //车辆序号（主键）
    private Integer id;
    //车牌号
    private String carNo;
    //单位组织
    private String deptId;
    //车辆种类
    private Integer classId;
    //车辆类型
    private Integer typeId;
    //是否领导用车1-是 0-否
    private Integer isLeader;
    //车身颜色
    private String carColor;
    //厂牌型号
    private String factoryMode;
    //出厂日期
    private Date outDate;
    //入户日期
    private Date inDate;
    //价值（万元）
    private String price;
    //车辆来历
    private String carFrom;
    //已累计行驶公里
    private String totalRun;
    //行驶证车主
    private String carMaster;
    //车主地址
    private String masterAddress;
    //车主代码
    private String masterCode;
    //制造国
    private String madeCountry;
    //制造厂商
    private String madeFactory;
    //启用日期
    private Date startDate;
    //发动机型号
    private String engineMode;
    //气缸数目
    private Integer cylinderNum;
    //车架号
    private String frameNo;
    //排量/功率
    private String maxPower;
    //最小离地距离
    private String minFromLand;
    //缸径x行程
    private String cylinderBore;
    //最小转弯半径
    private String minSwerRadius;
    //压缩比
    private String compRation;
    //转向器型式
    private String redrectMode;
    //工作顺序
    private String workSeq;
    //发动机号
    private String engineNo;
    //变速器型式
    private String derailMode;
    //轴数
    private Integer axesNum;
    //轴距
    private String axesDist;
    //轮胎规格
    private String tyreSpec;
    //轮胎数
    private Integer yreNum;
    //主制动型式
    private String mainBrake;
    //驻车制动型式
    private String stopBrak;
    //油耗
    private String useGas;
    //油箱容量
    private String gasCap;
    //核定载客
    private String chkPersonNum;
    //核定载重
    private String chkWeight;
    //总质量
    private String totalWeight;
    //车身尺寸-长
    private String bodyLong;
    //车身尺寸-宽
    private String bodyWidth;
    //车身尺寸-高
    private String bodyHeight;
    //冷却-形式
    private String coolStyle;
    //冷却-容量
    private String coolCap;
    //轮距-前
    private String frontTread;
    //轮距-中后
    private String backTread;
    //备注
    private String remark;

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
    //行驶证复印件
    private String masterUrl;
    //发动机号拓印
    private String engineNoUrl;
    //车辆照片
    private String carPhotoUrl;
    //车架号拓印
    private String frameNoUrl;
    //车辆状态-1删除 0-正常 1-停用 2-值班 3-租赁服务 4-维修保养 5-大修 6-报废 7-其他
    private Integer status;
    //调度状态0-未用 1-正在使用
    private Integer dispatchStatus;

    private String deptName;

    private String propLogicName;

    private String driverName;

}
