package org.csu.api.service.StatisticService;


import org.csu.api.dto.FeatureDTO;
import org.csu.api.util.AppConst;
import org.csu.api.util.Node;

import java.util.HashMap;
import java.util.List;

public class CodeTree {


    public HashMap<String , Node<NodeEntity>> dic;

    public CodeTree() {
        this.dic = new HashMap<>();
    }


    //由于频繁性查找文件节点，将src作为key放入HashMap中，加快查询速度
    public  void initial(Node<NodeEntity> root){
        //如果是叶子节点
        if(root.getChildNodes() == null || root.getChildNodes().isEmpty()){
            if(root.getNodeEntity().getType() == AppConst.Type.PACKAGE){
                return;
            }
            //如果是file类型
            else if(root.getNodeEntity().getType() == AppConst.Type.FILE) {
                dic.put(root.getNodeEntity().getSrc(), root);
                return;
            }
        }
        //深度优先遍历
        List<Node> childs = root.getChildNodes();
        for (Node<NodeEntity> n : childs) {
            initial(n);
        }
    }


    public void changeEntity(Node<NodeEntity> target){
        if(dic.containsKey(target.getNodeEntity().getSrc())){
            Node<NodeEntity> node = dic.get(target.getNodeEntity().getSrc());
            Node<NodeEntity> parent = node.getParentNode();
            parent.removeChildNode(node);
            parent.addChildNode(target);
        }
    }

}
