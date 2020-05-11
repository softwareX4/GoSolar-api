package org.csu.api.Controller;

import org.csu.api.dto.PackageDTO;
import org.csu.api.dto.RestResultDTO;
import org.csu.api.service.StatisticService.FileTraverse;
import org.csu.api.service.StatisticService.FileTraverseTree;
import org.csu.api.service.StatisticService.NodeEntity;
import org.csu.api.util.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class VisController {


    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

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
            RestResultDTO res =  new RestResultDTO<Node<NodeEntity>>(200,"success",root);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            return new RestResultDTO(400,"failed");
        }
    }
}
