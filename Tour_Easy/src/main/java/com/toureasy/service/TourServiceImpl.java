package com.toureasy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toureasy.dto.SearchTourDto;
import com.toureasy.dto.TourAddDto;
import com.toureasy.dto.TourDetailsDto;
import com.toureasy.entity.Agent;
import com.toureasy.entity.Tour;
import com.toureasy.repositories.TourRepository;

@Service
@Transactional
public class TourServiceImpl implements TourService {

	@Autowired
	private TourRepository tourRepository;
	
	@Autowired
	private AgentService agentService;

	@Override
	public Tour addTour(TourAddDto tour) {
		
		Tour newTour = new Tour();
		Agent agent = tour.getLoginId() != null ? agentService.getAgent(tour.getLoginId()) : null;
		newTour.setAgent(agent);
		newTour.setDateTime(tour.getDateTime());
		newTour.setSource(tour.getSource());
		newTour.setDestination(tour.getDestination());
		newTour.setPrice(tour.getPrice());		
		return tourRepository.save(newTour);

	}

	@Override
	public void deleteTour(int id) {
		tourRepository.deleteById(id);

	}

	@Override
	public Tour getTourById(int id) {
		return tourRepository.findById(id).orElse(null);
	}

	@Override
	public Tour updateTour(int id, Tour tour) {

		Tour existingTour = tourRepository.findById(id).orElse(null);
		if (existingTour != null) {
			existingTour.setSource(tour.getSource());
			existingTour.setDestination(tour.getDestination());
			existingTour.setDateTime(tour.getDateTime());
			existingTour.setPrice(tour.getPrice());

			return tourRepository.save(existingTour);
		} else {
			return null;
		}
	}

	@Override
	public List<TourDetailsDto> getAllTour(SearchTourDto searchTour) {
		List<TourDetailsDto> list= tourRepository.getAllTourDetails(searchTour.getSource(), searchTour.getDestination());
		return list;
	}

}
