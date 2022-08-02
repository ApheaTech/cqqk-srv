package com.aphea.cqqksrv.service;

import com.aphea.cqqksrv.entity.vo.NodeVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.aphea.cqqksrv.entity.TNode;

import java.util.List;

/**
 * 系统菜单(TNode)表服务接口
 *
 * @author xuhang
 * @since 2022-08-02 10:29:14
 */
public interface TNodeService extends IService<TNode> {

    List<NodeVO> getNodeTree();
}

