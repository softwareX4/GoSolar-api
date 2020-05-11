package org.csu.api.dto;

public class FeatureDTO {
    private int type;//stuct  file package
    private int attr;
    private int methods;
    private long loc;
    private String src;

    public FeatureDTO() {
    }

    public FeatureDTO(int type, String src) {
        this.type = type;
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAttr() {
        return attr;
    }

    public void setAttr(int attr) {
        this.attr = attr;
    }

    public int getMethods() {
        return methods;
    }

    public void setMethods(int methods) {
        this.methods = methods;
    }

    public long getLoc() {
        return loc;
    }

    public void setLoc(long loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "FeatureDTO{" +
                "type=" + type +
                ", attr=" + attr +
                ", methods=" + methods +
                ", loc=" + loc +
                ", src=" + src +
                '}' ;
    }
}
