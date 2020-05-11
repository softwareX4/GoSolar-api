package org.csu.api.dto;
import java.util.ArrayList;
import java.util.List;

public class FileDTO {
    private String name;
    private FeatureDTO fileFeature;
    private List<StructDTO> structs;

    public FileDTO() {
        this.structs = new ArrayList<StructDTO>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeatureDTO getFileFeature() {
        return fileFeature;
    }

    public void setFileFeature(FeatureDTO fileFeature) {
        this.fileFeature = fileFeature;
    }

    public List<StructDTO> getStructs() {
        return structs;
    }

    public void setStructs(List<StructDTO> structs) {
        this.structs = structs;
    }

    @Override
    public String toString() {
        return "\n    FileDTO{" +
                "name='" + name + '\'' +
                ",\n      fileFeature=" + fileFeature.toString() +
                ", \n       structs=" + structs.toString() +
                '}' ;
    }
}
