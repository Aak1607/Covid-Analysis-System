package com.mindtree.org.controller;

import com.mindtree.org.service.CovidAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;
@RestController
public class ConsoleController {

    public static void masterFunction(){
        //************************
        //Show Option
        System.out.println("Enter a Number to select option: ");
        CovidAnalysisService.showOption();
        //****************************************************************************
        //Get user option
        Scanner sc = new Scanner(System.in);
        int optionNumber = sc.nextInt();
        while(optionNumber!=5) {
            switch (optionNumber) {
                case 1 -> {
                    System.out.println("State list");
                }

                case 2 ->{
                    System.out.println("Get district");
                    CovidAnalysisService.showOption();
                }

                case 3 ->{
                    System.out.println("Get date");
                    CovidAnalysisService.showOption();
                }

                case 4 -> {
                    System.out.println("System SHUTDOWN!!");
                    System.exit(0);
                }//obj1.optionShow();

                default -> {
                    System.out.println("Enter a valid number");
                    CovidAnalysisService.showOption();
                }
            }
            optionNumber = sc.nextInt();
        }
        sc.close();
        //****************************************************************************
    }


}
