package com.toureasy.service;

import java.util.List;

import com.toureasy.dto.SearchTourDto;
import com.toureasy.dto.TourAddDto;
import com.toureasy.dto.TourDetailsDto;
import com.toureasy.entity.Tour;

public interface TourService {

	public Tour addTour(TourAddDto tour);

	public void deleteTour(int id);

	public Tour getTourById(int id);

	public Tour updateTour(int id,Tour tour);
	
	public List<TourDetailsDto> getAllTour(SearchTourDto searchTour);

}
