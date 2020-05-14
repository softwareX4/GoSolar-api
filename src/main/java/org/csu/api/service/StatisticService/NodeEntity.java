package org.csu.api.service.StatisticService;


import org.csu.api.dto.FeatureDTO;

public class NodeEntity {
    private int type;
    private String name;
    private FeatureDTO feature;
    private int radius;
    private String src;
    public NodeEntity(int type, String name) {
        this.type = type;
        this.name = name;
        this.feature = null;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public FeatureDTO getFeature() {
        return feature;
    }

    public void setFeature(FeatureDTO feature) {
        this.feature = feature;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "NodeEntity{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", src='" + src + '\'' +
                ",     feature=" + feature +
                '}';
    }
}
