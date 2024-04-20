package com.sport.demo.util;

import org.springframework.beans.BeanUtils;

import com.sport.demo.dto.request.AddEventRequestDTO;
import com.sport.demo.dto.request.AddSportRequestDTO;
import com.sport.demo.dto.request.AddTeamRequestDTO;
import com.sport.demo.dto.request.PlayerRegisterRequestDTO;
import com.sport.demo.dto.request.RegisterRequestDTO;
import com.sport.demo.dto.response.LoginResponseDTO;
import com.sport.demo.entity.Event;
import com.sport.demo.entity.Organizer;
import com.sport.demo.entity.Player;
import com.sport.demo.entity.Referee;
import com.sport.demo.entity.Sport;
import com.sport.demo.entity.Team;
import com.sport.demo.entity.User;
import com.sport.demo.enums.AvailabilityStatus;
import com.sport.demo.enums.Gender;
import com.sport.demo.enums.Role;
import com.sport.demo.enums.SportCategory;
import com.sport.demo.enums.Sports;
import com.sport.demo.enums.UserStatus;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MapperUtil {

	public static LoginResponseDTO toLoginResponseDTO(User user) {
		final var loginResponseDTO = new LoginResponseDTO(user.getId(), user.getFirstName(), user.getLastName() , user.getUserStatus().name(), user.getRole().name()); //TODO var java 9 feature
		return loginResponseDTO;
	}

	public static User toUserEntity(RegisterRequestDTO request) {
		final User user = new User();
		BeanUtils.copyProperties(request, user);
		user.setRole(Role.valueOf(request.getRole()));
		user.setUserStatus(UserStatus.NOT_VERIFIED);
		user.setContactNo(Long.parseLong(request.getContactNo()));
		user.setPassword(BCrypt.withDefaults().hashToString(12, request.getPassword().toCharArray()));
		return user;
	}

	public static Player toPlayerEntity(PlayerRegisterRequestDTO request) {
		final Player player = new Player();
		BeanUtils.copyProperties(request, player);
		player.setRole(Role.valueOf(request.getRole()));
		player.setUserStatus(UserStatus.NOT_VERIFIED);
		player.setContactNo(Long.parseLong(request.getContactNo()));
		player.setPassword(BCrypt.withDefaults().hashToString(12, request.getPassword().toCharArray()));
		player.setGender(Gender.valueOf(request.getGender()));
		return player;
	}

	public static Sport toSportEntity(AddSportRequestDTO request) {
		final Sport sport = new Sport();
		sport.setName(Sports.valueOf(request.getName()));
		sport.setType(SportCategory.valueOf(request.getType()));
		sport.setNoOfPlayers(request.getNoOfPlayers());
		return sport;
	}

	public static Team toTeamEntity(AddTeamRequestDTO request) {
		return new Team(request.getName());
	
	}

	public static Event toEventEntity(AddEventRequestDTO request) {
		final Event event = new Event();
		BeanUtils.copyProperties(request, event);
		event.setName(request.getName());
		//TODO date field
		event.setEntryFees(request.getEntryFees());
		return event;
	}
	

	
}
