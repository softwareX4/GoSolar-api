package org.csu.api.Controller;

import org.csu.api.dto.PackageDTO;
import org.csu.api.dto.RestResultDTO;
import org.csu.api.service.StatisticService.FileTraverse;
import org.csu.api.service.StatisticService.FileTraverseTree;
import org.csu.api.service.StatisticService.NodeEntity;
import org.csu.api.util.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class VisController {


    @Autowired
    private FileTraverseTree fileTraverseTree;


    @RequestMapping(value = "/index")
    public RestResultDTO index(){
            return new RestResultDTO(200,"connect successed");
    }

    @RequestMapping("/initial")
    @ResponseBody
    public RestResultDTO initial(@RequestParam("path") String path){
        try {
            Node<NodeEntity> root = fileTraverseTree.analyse(path);
            return new RestResultDTO<Node<NodeEntity>>(200,"success",root);
        } catch (IOException e) {
            e.printStackTrace();
            return new RestResultDTO(400,"failed");
        }
    }
}
