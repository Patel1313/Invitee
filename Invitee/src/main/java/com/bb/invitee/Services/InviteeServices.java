package com.bb.invitee.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bb.invitee.entity.InviteeEntity;
import com.bb.invitee.enums.InviteType;
import com.bb.invitee.repo.InviteeRepo;

@Service
public class InviteeServices {
	
	@Autowired
	private InviteeRepo inviteeRepo;
	
	//CURD
	
	//Read
	public List<InviteeEntity> findAll(){
		return inviteeRepo.findAll();
	}
	
	public Optional<InviteeEntity> findById(String string){
		return inviteeRepo.findById(string);
	}
	
	//Create
	public InviteeEntity save(InviteeEntity inviteeEntity){
	System.out.println("save: inviteeEntity : "+inviteeEntity);
	inviteeEntity.setInviteType(inviteeEntity.getInviteType() == null ? InviteType.MARRIAGE: inviteeEntity.getInviteType());
	System.out.println("save: inviteeEntity : "+inviteeEntity);
		return inviteeRepo.save(inviteeEntity);
	}
	
	//Update	
	public String updateById(InviteeEntity inviteeEntity, String string){
		Optional<InviteeEntity> inviteeEntity1 = inviteeRepo.findById(string);
		System.out.println("updateById: inviteeEntity1 : "+inviteeEntity1);
		if(inviteeEntity1.isPresent()) {
			System.out.println("updateById: inviteeEntity1.isPresent() : "+inviteeEntity1.isPresent());
			InviteeEntity inviteeEntity2 = new InviteeEntity();
			inviteeEntity2.setId(string);
			inviteeEntity2.setInviteType(inviteeEntity.getInviteType() == null ? InviteType.MARRIAGE: inviteeEntity.getInviteType());
			inviteeEntity2.setSurNameOfInvitor(inviteeEntity.getSurNameOfInvitor());
			inviteeRepo.save(inviteeEntity2);
			return  "Updated Successfully";
		}
		return "failed";
	}
	
	//Delete
	public boolean deleteById(String string){
		Optional<InviteeEntity> inviteeEntity = inviteeRepo.findById(string);
		if(inviteeEntity.isPresent()) {
			inviteeRepo.deleteById(string);
			return true;
		}
		return false;
	}
	
}
