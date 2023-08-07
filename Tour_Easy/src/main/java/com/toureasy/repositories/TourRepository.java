package com.toureasy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toureasy.dto.TourDetailsDto;
import com.toureasy.entity.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
	
//@Query("select new com.toureasy.dto.TourDetailsDto(t.source as source, t.destination as destination, t.price as price, t.dateTime as date, a.companyName as companyName, a.firstName as firstName, a.lastName as lastName, a.mobileNo as mobileNo) from Tour t left join t.agent a where t.source = ?1 and t.destination = ?2 and t.dateTime = ?3")
//	List<TourDetailsDto> getAllTourDetails(String source, String destination, LocalDateTime dateTime);

	@Query("select new com.toureasy.dto.TourDetailsDto(t.source as source, t.destination as destination, t.price as price, t.dateTime as date, a.companyName as companyName, a.firstName as firstName, a.lastName as lastName, a.mobileNo as mobileNo) from Tour t left join t.agent a where t.source = ?1 and t.destination = ?2 ")
	List<TourDetailsDto> getAllTourDetails(String source, String destination);
	
//	@Query("select new com.toureasy.dto.TourDetailsDto(t.source as source, t.destination as destination, t.price as price, t.dateTime as date, a.companyName as companyName, a.firstName as firstName, a.lastName as lastName, a.mobileNo as mobileNo) from Tour t left join t.agent a where t.source = ?1 and t.destination = ?2 and t.dateTime = ?3")
//	List<TourDetailsDto> getAllTourDetails(String source, String destination, LocalDate date);

//	@Query("select new com.toureasy.dto.TourDetailsDto(t.source as source, t.destination as destination, t.price as price, t.dateTime as date, a.companyName as companyName, a.firstName as firstName, a.lastName as lastName, a.mobileNo as mobileNo) from Tour t left join t.agent a where t.source = ?1 and t.destination = ?2 and t.date = ?3")
//	List<TourDetailsDto> getAllTourDetails(String source, String destination, LocalDate date);


}

