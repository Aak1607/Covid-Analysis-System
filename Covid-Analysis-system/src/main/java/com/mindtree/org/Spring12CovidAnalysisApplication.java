package com.mindtree.org;

import com.mindtree.org.controller.ConsoleController;
import com.mindtree.org.controller.CovidAnalysisController;
import com.mindtree.org.entity.CovidAnalysis;
import com.mindtree.org.repository.CovidAnalysisRepository;
import com.mindtree.org.service.CovidAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Spring12CovidAnalysisApplication {
    public static void main(String[] args) {
        SpringApplication.run(Spring12CovidAnalysisApplication.class, args);
    }

}
