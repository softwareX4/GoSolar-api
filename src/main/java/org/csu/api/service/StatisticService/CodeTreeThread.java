package org.csu.api.service.StatisticService;

import org.csu.api.util.Node;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

//CodeTree的多线程类  视遍历开销情况使用
public class CodeTreeThread implements Callable<String> {

    private HashMap<String , Node<NodeEntity>> dic;
    private Node<NodeEntity> target;

    public CodeTreeThread(HashMap<String, Node<NodeEntity>> dic, Node<NodeEntity> root) {
        this.dic = dic;
        this.target = root;
    }

    public void changeEntity(Node<NodeEntity> target){
        if(dic.containsKey(target.getNodeEntity().getSrc())){
            Node<NodeEntity> node = dic.get(target.getNodeEntity().getSrc());
            Node<NodeEntity> parent = node.getParentNode();
            parent.removeChildNode(node);
            parent.addChildNode(target);
        }
    }
    @Override
    public String call() throws Exception {

        changeEntity(target);

        return null;
    }
}
