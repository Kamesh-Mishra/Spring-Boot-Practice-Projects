package com.memberofparliament.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Member_Details")
@Entity
public class MemberOfParliament {

	@Id
	String name;
	String party;
	
	String constituency;
	String state;
}
