package org.csu.api.dto;

public class StructDTO {
    private String name;
    private FeatureDTO feature;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeatureDTO getFeature() {
        return feature;
    }

    public void setFeature(FeatureDTO feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        return "\n        StructDTO{" +
                "name='" + name + '\'' +
                ", feature=" + feature.toString() +
                '}';
    }
}
