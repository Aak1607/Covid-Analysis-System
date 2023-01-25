package com.mindtree.org.service;

import com.mindtree.org.entity.CovidAnalysis;
import com.mindtree.org.exception.InvalidDateException;
import com.mindtree.org.exception.InvalidStateCodeException;
import com.mindtree.org.exception.NoDataFoundException;
import com.mindtree.org.repository.CovidAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CovidAnalysisService{
    @Autowired
    private CovidAnalysisRepository repository;

    public List<String> state(){
        ArrayList<String> stateList = (ArrayList<String>) repository.state();
        return stateList.
                stream().
                distinct().
                collect(Collectors.toList());
    }
    public List<CovidAnalysis> show() {
        return repository.findAll();
    }
    public List<String> district(String st){
        ArrayList<String> sortDist = (ArrayList<String>) repository.findByDistrict(st);
        boolean stateCode = sortDist.contains(st);
        try{
            if(!stateCode){
                throw new InvalidStateCodeException("Please check your input");
            }
        }
        catch(InvalidStateCodeException e){
            System.out.println("Invalid State Code, "+e.getMessage());
        }
        return sortDist.
                stream().
                sorted().
                collect(Collectors.toList());
    }
    public List<String> date(Date date1, Date date2){
        try{
            LocalDate.parse((CharSequence) date1, DateTimeFormatter.
                    ofPattern("uuuu-M-d").
                    withResolverStyle(ResolverStyle.STRICT));
            throw new InvalidDateException("Please Check your input");
        }
        catch (InvalidDateException e){
            System.out.println("Invalid Start date, "+e.getMessage());

        }
        try{
            LocalDate.parse((CharSequence) date2, DateTimeFormatter.
                    ofPattern("uuuu-M-d").
                    withResolverStyle(ResolverStyle.STRICT));
            throw new InvalidDateException("Please Check your input");
        }
        catch (InvalidDateException e){
            System.out.println("Invalid End date, "+e.getMessage());

        }
        try{
            if (date1==null||date2==null){
                throw new NoDataFoundException("No data present");
            }
        }
        catch (NoDataFoundException e){
            System.out.println(e.getMessage());
        }
        return repository.findByDate(date1,date2);
    }

    //lambda and functional interface
    //*********************************************************************************
    static interf1 m1 = ()->System.out.println(
            """
                    1. Get State Names\s
                    2. Get District for given state\s
                    3. Display Date by State with in Date Range\s
                    4. Exit"""
    );
    public static void showOption(){
        m1.m1ShowOption();
    }
    //*********************************************************************************
}
