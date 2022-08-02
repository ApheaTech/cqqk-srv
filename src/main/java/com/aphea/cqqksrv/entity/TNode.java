package com.aphea.cqqksrv.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 系统菜单(TNode)表实体类
 *
 * @author xuhang
 * @since 2022-08-02 10:29:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class TNode extends Model<TNode> {
    //权限节点ID
    private String nodeId;
    //名称
    private String nodeName;
    //类型。0表示目录菜单;1表示菜单叶子菜点；2表示执行权限
    private String nodeType;
    //菜单地址
    private String url;
    //菜单来源(1-APP，2-运营端，3-园长端，4-教委管理员，5-教委普通人员)
    private String nodeSrc;
    //备注
    private String remark;
    //父菜单ID
    private String parentId;
    //节点显示顺序
    private Integer nodeOrder;
    //创建人帐号
    private String createUser;
    //创建时间
    private Date createDate;
    //是否系统默认节点
    private String systemDefault;
    //图标
    private String nodeIcon;
    //状态(0-删除，1-有效，2-禁用)
    private String isValid;
    //平台类型（1Android客户端，2-IOS客户端，3-云平台,4--园长端,5-运营端)
    private String sysType;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.nodeId;
    }
}

