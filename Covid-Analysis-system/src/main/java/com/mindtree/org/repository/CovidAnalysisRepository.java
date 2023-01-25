package com.mindtree.org.repository;

import com.mindtree.org.entity.CovidAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public interface CovidAnalysisRepository extends JpaRepository <CovidAnalysis,Long> {

    @Query("select s.state from CovidAnalysis s")
    List<String> state();
    @Query("select s.district from CovidAnalysis s where s.state= :st")
    List<String> findByDistrict(@Param("st") String st);

    @Query("select s.date, s.state, s.confirmed from CovidAnalysis s where s.date between :date1 and :date2")
    List<String> findByDate(@Param("date1") Date date1, @Param("date2") Date date2);

    @Query("select s.date, s.state, s.confirmed from CovidAnalysis s where s.date between :date1 and :date2")
    List<String> findByDateState(@Param("date1") Date date1, String st1 ,@Param("date2") Date date2, String st2);
}
