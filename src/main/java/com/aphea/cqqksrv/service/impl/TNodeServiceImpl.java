package com.aphea.cqqksrv.service.impl;

import com.aphea.cqqksrv.dao.TOrgDao;
import com.aphea.cqqksrv.entity.TOrg;
import com.aphea.cqqksrv.entity.vo.NodeVO;
import com.aphea.cqqksrv.entity.vo.OrgVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aphea.cqqksrv.dao.TNodeDao;
import com.aphea.cqqksrv.entity.TNode;
import com.aphea.cqqksrv.service.TNodeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统菜单(TNode)表服务实现类
 *
 * @author xuhang
 * @since 2022-08-02 10:29:14
 */
@Service("tNodeService")
public class TNodeServiceImpl extends ServiceImpl<TNodeDao, TNode> implements TNodeService {

    private List<NodeVO> nodeList;

    // TODO 添加根据用户ID判断
    @Override
    public List<NodeVO> getNodeTree() {

        nodeList = getNodeList();

        NodeVO rootNode = new NodeVO();
        rootNode.setNodeId("0");
        rootNode.setChildNode(getChildrenNode(rootNode));

        return rootNode.getChildNode();
    }

    public List<NodeVO> getChildrenNode(NodeVO nodeVO) {

        List<NodeVO> subNodeList = nodeList.stream()
                .filter(node -> node.getParentId().equals(nodeVO.getNodeId()))
                .collect(Collectors.toList());

        for (NodeVO subNode : subNodeList) {
            List<NodeVO> subChildrenOrg = getChildrenNode(subNode);
            subNode.setChildNode(subChildrenOrg);
        }

        return subNodeList;
    }

    public List<NodeVO> getNodeList() {

        TNodeDao baseMapper = this.baseMapper;
        List<TNode> tNodeList = baseMapper.selectList(new QueryWrapper<TNode>());
        List<NodeVO> list = tNodeList.stream().map(tNode -> {
            NodeVO nodeVO = new NodeVO();
            BeanUtils.copyProperties(tNode, nodeVO);
            return nodeVO;
        }).collect(Collectors.toList());

        return list;
    }
}

