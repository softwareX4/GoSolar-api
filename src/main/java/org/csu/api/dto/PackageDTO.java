package org.csu.api.dto;

import java.util.ArrayList;
import java.util.List;

public class PackageDTO {
    private String name;
    private List<PackageDTO>packages;
    private List<FileDTO> files;

    public PackageDTO() {
        this.setPackages(new ArrayList<PackageDTO>());
        this.setFiles(new ArrayList<FileDTO>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FileDTO> getFiles() {
        return files;
    }

    public void setFiles(List<FileDTO> files) {
        this.files = files;
    }

    public List<PackageDTO> getPackages() {
        return packages;
    }

    public void setPackages(List<PackageDTO> packages) {
        this.packages = packages;
    }

    @Override
    public String toString() {
        return "\nPackageDTO{" +
                "name='" + name + '\'' +
                ", \n  packages=" + packages.toString() +
                ", \n    files=" + files.toString() +
                '}';
    }
}
