package com.sport.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sport.demo.enums.SportCategory;
import com.sport.demo.enums.Sports;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sports")
@NoArgsConstructor
@Getter
@Setter
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private SportCategory type;
    private Sports name;
    private Integer noOfPlayers;
    

    
	@OneToOne(mappedBy = "sport")
	private Event event;
    
}