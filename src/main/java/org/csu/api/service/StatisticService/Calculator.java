package org.csu.api.service.StatisticService;

import org.csu.api.dto.RestResultDTO;
import org.csu.api.util.AppConst;
import org.csu.api.util.Node;

import java.io.IOException;
import java.util.HashMap;

import static java.lang.Math.*;

//计算前端半径
public  class Calculator {

    public  HashMap<String ,Integer> radius ;


    public Calculator() {
        this.radius = new HashMap<>();
    }

    public  int calcR(Node<NodeEntity> root){


        //如果是子节点
        if(root.getChildNodes() == null || root.getChildNodes().isEmpty()){
            int childMethods = 0;
            if(root.getNodeEntity().getType() == AppConst.Type.PACKAGE){
                childMethods = AppConst.PACKAGE_R;
            }
            else {
                childMethods = root.getNodeEntity().getFeature().getMethods();
            }
            radius.put(root.getNodeEntity().getSrc(),childMethods);

            System.out.println(root.getNodeEntity().getName() + "  -- childMethods:" + childMethods);
            root.getNodeEntity().setRadius(childMethods);
            return childMethods;

        }

        else {
           int  maxMethods = 0;
            //计算子节点最大方法数
            for(Node<NodeEntity> child : root.getChildNodes()){
                int childMax = calcR(child);
                maxMethods = max(maxMethods,childMax);
            }
            System.out.println(root.getNodeEntity().getName() + "  -- childMaxMethods:" + maxMethods);
            int parentR = 0;
            if(root.getNodeEntity().getType() == AppConst.Type.PACKAGE){
                parentR = AppConst.PACKAGE_R;
            }
            else {
                parentR = root.getNodeEntity().getFeature().getMethods();
            }
            int r1 = parentR + maxMethods;
            int r2;
            if(maxMethods <= 1) {
                r2 = 1;
            }
            else r2 = (int) ceil(maxMethods /  sin( (PI / ( root.getChildNodes().size() ) ) ) );

            int res = max(r1,r2);
            System.out.println("res ==> " + res);
            radius.put(root.getNodeEntity().getSrc(),res);
            root.getNodeEntity().setRadius(res);
            //清空maxMethods，返回上一层
            return res;
        }
    }


    public static void main(String[] args) throws IOException {

        Node<NodeEntity> root = new FileTraverseTree().analyse("G:\\AAApersonal\\毕设\\project\\kubernetes-master\\pkg\\controller\\apis");
        Calculator cal = new Calculator();
        System.out.println(cal.calcR(root));
        System.out.println(cal.radius.toString());
    }
}
