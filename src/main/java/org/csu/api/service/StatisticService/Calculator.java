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


    public static int getRadius(Node<NodeEntity> node){
        int type = node.getNodeEntity().getType();
        if(type ==  AppConst.Type.PACKAGE){
            return AppConst.PACKAGE_R;
        }
        int methods = node.getNodeEntity().getFeature().getMethods();
        if(type == AppConst.Type.FILE){
            if(methods < AppConst.Method.F_S)
                return AppConst.Radius.F_S;
            else if(methods < AppConst.Method.F_M)
                return  AppConst.Radius.F_M;
            else if(methods < AppConst.Method.F_L)
                return AppConst.Radius.F_L;
            else
                return AppConst.Radius.F_XL;
        }
        else {
            if(methods < AppConst.Method.S_S)
                return AppConst.Radius.S_S;
            else if(methods < AppConst.Method.S_M)
                return AppConst.Radius.S_M;
            else
                return AppConst.Radius.S_L;
        }
    }




    public  int calcR(Node<NodeEntity> root){

        //如果是子节点
        if(root.getChildNodes() == null || root.getChildNodes().isEmpty()){
            int childR = root.getNodeEntity().getRadius();
            radius.put(root.getNodeEntity().getSrc(),childR);
            return childR;

        }

        else {
            int  maxR = 0;
            //计算子节点最大方法数
            for(Node<NodeEntity> child : root.getChildNodes()){
                int childMax = calcR(child);
                maxR = max(maxR,childMax);
            }
            System.out.println(root.getNodeEntity().getName() + "  -- childMaxR:" + maxR);
            int parentR = root.getNodeEntity().getRadius();
            int r1 = parentR + maxR;
            int r2;
            int n = root.getChildNodes().size();
            //若只有一个子节点，则外接圆半径为子节点半径
            if(n == 1) {
                r2 = maxR;
            }
            else if ( n == 2){
                //若有两个子节点，则外接圆半径为子节点直径
                r2 = 2 * maxR;
            }
            else {
                //边长为a的正n多边形的半径 R = a / (2 * sin ( PI / n ) ) , 此处边长为 2 * maxR
                r2 = (int) ceil(maxR /  sin( (PI / n ) ) );
            }
            int res = max(r1,r2);
            radius.put(root.getNodeEntity().getSrc(),res);
            root.getNodeEntity().setRadius(res);
            //清空maxMethods，返回上一层
            return res + maxR;
        }
    }


    public static void main(String[] args) throws IOException {

        Node<NodeEntity> root = new FileTraverseTree().analyse("G:\\AAApersonal\\毕设\\project\\kubernetes-master\\pkg\\controller\\apis");
        Calculator cal = new Calculator();
        System.out.println(cal.calcR(root));
        System.out.println(cal.radius.toString());
    }
}
