package com.iris.microserviceprovider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author yx start
 * @create 2019/4/3,16:58
 */
@RestController
@RequestMapping(value = "/server")
public class DemoController {
    @RequestMapping(value = "/list")
    public List getAllList() {
        List<Map> data = getData(10, (n) -> {
            List<Map> resList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                Map m = new HashMap(2);
                m.put("name", "9898==name==" + i);
                m.put("id", "9898==id==" + i);
                resList.add(m);
            }
            return resList;
        });

        return data ;
    }

    public List<Map> getData(Integer n , Function<Integer,List<Map>> fun){
        return fun.apply(n) ;
    }



}
