package com.bb.invitee.entity;

import com.bb.invitee.enums.InviteType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InviteeEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
	
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InviteType inviteType;
	
    @Column(nullable = false)
	private String surNameOfInvitor;
//	
//    @Column(nullable = false)
//	private String nameOfBride;
//	
//    @Column(nullable = false)
//	private String nameOfGroom;
//	
//	private String namesOfBrideFamily;
//	
//	private String namesOfGroomFamily;
//	
//    @Column(nullable = false)
//	private String eventdateOne;
//	
//	private String eventdateTwo;
//	
//	private String picsUrl[];
//	
//	private String audiosUrl[];
//	
//	private String byuserId;
	
	
}
