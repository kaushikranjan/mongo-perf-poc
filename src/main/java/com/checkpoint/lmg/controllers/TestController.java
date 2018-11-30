package com.checkpoint.lmg.controllers;


import com.checkpoint.lmg.models.InputModel;
import com.checkpoint.lmg.models.SOHModel;
import com.checkpoint.lmg.repositories.SOHDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class TestController {

    private final SOHDAL sohdal;

    @Autowired
    public TestController(SOHDAL sohdal) {
        this.sohdal = sohdal;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addData(@RequestBody List<InputModel> modelList) {
        Long start = System.currentTimeMillis();

        List<SOHModel> sohModelList = new ArrayList<>();
        for(InputModel mod : modelList) {
            sohModelList.add(mod.convertToDBModel());
        }

        //sohdal.insert(sohModelList.get(0));
        sohdal.bulk(sohModelList);
        Long end = System.currentTimeMillis();

        Double seconds = ((double)(end-start))/1000;
        return seconds.toString();
    }
}
