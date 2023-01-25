package com.mindtree.org.controller;

import com.mindtree.org.entity.CovidAnalysis;
import com.mindtree.org.service.CovidAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@RestController
public class CovidAnalysisController {
    //********************************************
    @Autowired
    private CovidAnalysisService service;
    //********************************************
    @RequestMapping("/all")
    public List<CovidAnalysis> showAllCovidData(){
        List<CovidAnalysis> s = service.show();
        s.forEach(System.out::println);//Console
        return service.show();
    }

    @RequestMapping("/showListOption")
    public String showOption(){
        return """
                    1. Get State Names\s
                    2. Get District for given state\s
                    3. Display Date by State with in Date Range\s
                    4. Exit""";
    }

    @RequestMapping("/showListOption/1")
    public List<String> showState(){
        return service.state();
    }

    @RequestMapping("/showListOption/2/{stateCode}")
    public List<String> showDistrict(@PathVariable  String stateCode){
        return service.district(stateCode);
    }

    @RequestMapping("/showListOption/3/{date1}/{date2}")
    public List<String> showDate(@PathVariable Date date1, @PathVariable Date date2){
        return service.date(date1, date2);
    }

    @RequestMapping("/showListOption/4")
    public String systemExit(){
        System.exit(0);
        return "System SHUTDOWN";
    }
    //**********************************************************************************************
}

