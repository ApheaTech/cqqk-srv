package com.aphea.cqqksrv.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author 航
 * @date 2022/8/2 10:34
 */
@Data
@ToString
public class NodeVO {

    //权限节点ID
    private String nodeId;
    //名称
    private String nodeName;
    //类型。0表示目录菜单;1表示菜单叶子菜点；2表示执行权限
    private String nodeType;
    //菜单地址
    private String url;
    //备注
    private String remark;
    //父菜单ID
    private String parentId;
    //图标
    private String nodeIcon;
    //状态(0-删除，1-有效，2-禁用)
    private String isValid;

    private List<NodeVO> childNode;

}
