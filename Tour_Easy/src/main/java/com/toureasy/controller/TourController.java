package com.toureasy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toureasy.dto.SearchTourDto;
import com.toureasy.dto.TourAddDto;
import com.toureasy.dto.TourDetailsDto;
import com.toureasy.entity.Tour;
import com.toureasy.service.TourService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tour")
public class TourController {

	@Autowired
	private TourService tourService;

	@PostMapping("/search")
	public ResponseEntity<List<TourDetailsDto>> getTourDetails(@Valid @RequestBody SearchTourDto tourDetails) {

		List<TourDetailsDto> list = tourService.getAllTour(tourDetails);
		
		if(list.size()>0) {
			System.out.println("\n\n\n");
			System.out.println(list.get(0));
			//System.out.println(list.get(1));
			System.out.println("\n\n\n");
			return new ResponseEntity<>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
	}

	@PostMapping("/add")
	public ResponseEntity<Tour> addTour(@Valid @RequestBody TourAddDto tour) {	
		
		Tour newTour = tourService.addTour(tour);
		return new ResponseEntity<>(newTour, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tour> getTourById(@PathVariable("id") int id) {

		Tour tour = tourService.getTourById(id);
		if (tour != null) {
			return new ResponseEntity<>(tour, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTourById(@PathVariable("id") int id) {

		tourService.deleteTour(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tour> updateTourFromDb(@PathVariable("id") int id, @Valid @RequestBody Tour tour) {
		Tour updateTour = tourService.updateTour(id, tour);
		if (updateTour != null) {
			return new ResponseEntity<>(updateTour, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
