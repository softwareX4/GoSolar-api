package org.csu.api.util;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.csu.api.dto.FeatureDTO;
import org.csu.api.service.StatisticService.NodeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Node<T> implements Serializable {
    @JsonBackReference
    private Node parentNode;
    private T nodeEntity;
    private List<Node> childNodes;

    public Node (T nodeEntity){
        this.nodeEntity=nodeEntity;
    }

    public Node (){}

    public void addChildNode(Node childNode){
        childNode.setParentNode(this);
        if ( this.childNodes==null){
            this.childNodes = new ArrayList<Node>();
        }
        this.childNodes.add(childNode);
    }

    public void removeChildNode(Node childNode){
        if (this.childNodes!=null){
            this.childNodes.remove(childNode);
        }
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public T getNodeEntity() {
        return nodeEntity;
    }

    public void setNodeEntity(T nodeEntity) {
        this.nodeEntity = nodeEntity;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<Node> childNodes) {
        this.childNodes = childNodes;
    }


    @Override
    public String toString() {

        return "Node{" +
                " nodeEntity=" + nodeEntity +
                '}';
    }



    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    public   void displaytree(Node<NodeEntity> f, int level) {       //递归显示树

        String preStr = "";
        for(int i=0; i<level; i++) {
            preStr += "    ";
        }

        for(int i=0; i<f.getChildNodes().size(); i++) {
            Node<NodeEntity> t = f.getChildNodes().get(i);
            System.out.println(preStr + "-"+t.getNodeEntity().toString());

            logger.info(preStr + "-"+t.getNodeEntity().toString());

            if(!( t.getChildNodes() == null || t.getChildNodes().isEmpty())) {
                displaytree(t, level + 1);
            }
        }
    }


}