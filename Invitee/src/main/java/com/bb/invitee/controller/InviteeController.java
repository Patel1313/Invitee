package com.bb.invitee.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bb.invitee.Services.InviteeServices;
import com.bb.invitee.entity.InviteeEntity;
import com.bb.invitee.enums.InviteType;
import com.bb.invitee.repo.InviteeRepo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
@RequestMapping("/invitee")
public class InviteeController {
	
	@Autowired
	private InviteeServices inviteeServices;
	
	@Autowired
	private InviteeRepo inviteeRepo;
	
	@GetMapping("/helloWorld")
	private String helloWorld() {
		System.out.println("helloWorld");
		return "Hello World";
	}
	
	@GetMapping("/helloWorld/{string}")
	private String helloWorld(@PathVariable String string) {
		System.out.println("helloWorld: Variables : "+string);
		return "Hello Welcome, "+ string;
	}
	
	@GetMapping("/findAll")
	private List<InviteeEntity> findAllInviteeEntities(){
		System.out.println("findAllInviteeEntities");
		return inviteeServices.findAll();
	}
	
	@GetMapping("/findById/{string}")
	private Optional<InviteeEntity> findById(@PathVariable String string) {
		System.out.println("findById: Variables : "+string);
		return inviteeServices.findById(string);
	}
	
	@PostMapping("/save")
	private InviteeEntity save(@RequestBody InviteeEntity inviteeEntity) {
		System.out.println("save: Variables : "+inviteeEntity);
		return inviteeServices.save(inviteeEntity);
	}
	
	@PutMapping("/updateById/{id}")
	private String updateById(@PathVariable String id, @RequestBody InviteeEntity inviteeEntity) {
		System.out.println("updateById: Variables : "+id+ " , "+inviteeEntity);
		return inviteeServices.updateById(inviteeEntity, id);
	}
	
	@DeleteMapping("/DeleteById/{id}")
	private boolean deleteByid(@PathVariable String id) {
		System.out.println("updateById: Variables : "+id);
		return inviteeServices.deleteById(id);
	}
	
	//Create Bulk Random records
	@PostConstruct
	public void saveBulkRandomRecords(){
	System.out.println("saveBulkRandomRecord");
	
	Random random = new Random();
	int i=0;
	while( i<=100) {
		i++;
		InviteeEntity inviteeEntity = new InviteeEntity();
		int randomNumber = random.nextInt(10);
		
		switch(randomNumber) {
		case 1:
			inviteeEntity.setInviteType(InviteType.BIRTHDAY);
			break;
		case 2:
			inviteeEntity.setInviteType(InviteType.MARRIAGE);
			break;
		case 3:
			inviteeEntity.setInviteType(InviteType.OTHERS);
			break;
		case 4:
			inviteeEntity.setInviteType(InviteType.RECEPTION);
			break;
		case 5:
			inviteeEntity.setInviteType(InviteType.RETIREMENT);
			break;
		case 6:
			inviteeEntity.setInviteType(InviteType.BIRTHDAY);
			break;
		case 7:
			inviteeEntity.setInviteType(InviteType.MARRIAGE);
			break;
		case 8:
			inviteeEntity.setInviteType(InviteType.OTHERS);
			break;
		case 9:
			inviteeEntity.setInviteType(InviteType.RECEPTION);
			break;
		case 10:
			inviteeEntity.setInviteType(InviteType.RETIREMENT);
			break;
		default:
			inviteeEntity.setInviteType(InviteType.MARRIAGE);
			break;
		}
		inviteeEntity.setSurNameOfInvitor("Bollam "+randomNumber);
		System.out.println("saveBulkRandomRecords: inviteeEntity : "+inviteeEntity);
		inviteeRepo.save(inviteeEntity);
	}

	}
	
	//Destroying All data
	@PreDestroy
	private void shutdown() {
		System.out.println("Deleting All data");
		inviteeRepo.deleteAll();
	}
}
