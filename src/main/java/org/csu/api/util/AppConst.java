package org.csu.api.util;

public  class AppConst {
    public static final class Type{
        public final static  int ROOT = 0;
        public final static  int PACKAGE = 1;
        public final static  int FILE = 2;
        public final static  int STRUCT = 3;
    }

    //线程数
    public static final int nThread = 8;

    //前端协商Package半径大小
    public static final int PACKAGE_R = 4;

    //前端定义的半径
    public static final class Radius{
        //Struct
        public final static int S_S = 2;
        public final static int S_M = 3;
        public final static int S_L = 4;
        //File
        public final static int F_S = 6;
        public final static int F_M = 7;
        public final static int F_L = 8;
        public final static int F_XL = 9;
    }

    //方法数分级
    public static final class Method{
        //Struct
        public final static int S_S = 2;
        public final static int S_M = 4;
        //File
        public final static int F_S = 10;
        public final static int F_M = 20;
        public final static int F_L = 30;
    }

}
