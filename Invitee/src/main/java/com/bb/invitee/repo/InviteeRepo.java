package com.bb.invitee.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.invitee.entity.InviteeEntity;

public interface InviteeRepo extends JpaRepository<InviteeEntity, String> {

	InviteeEntity save(Optional<InviteeEntity> inviteeEntity1);
		
}
