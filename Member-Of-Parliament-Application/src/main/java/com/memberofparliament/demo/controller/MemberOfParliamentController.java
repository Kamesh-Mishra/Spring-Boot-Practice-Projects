package com.memberofparliament.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.memberofparliament.demo.entity.MemberOfParliament;
import com.memberofparliament.demo.service.MemberOfParliamentService;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/mp")
public class MemberOfParliamentController {

	MemberOfParliamentService memberOfParliamentService;
	
	@GetMapping("/bystate/{state}")
	public ResponseEntity<List<MemberOfParliament>> getAllbyState(@PathVariable String state) {
		
		List<MemberOfParliament> list = memberOfParliamentService.getMPbyState(state);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/byconstituencyandstate/{consti}/{state}")
	public ResponseEntity<List<MemberOfParliament>> getAllByConstituencyAndState(
			@PathVariable String consti, @PathVariable String state){
		List<MemberOfParliament> list = memberOfParliamentService.getMPByConstituencyAndState(consti, state);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/total")
	public ResponseEntity<String> getTotalNumberOfMp(){
		String total = memberOfParliamentService.totalMp();
		return ResponseEntity.ok(total);
	}
	
	@GetMapping("/totalofstate/{state}")
	public ResponseEntity<Integer> getTotalNumOfState(@PathVariable String state){
		Integer data = memberOfParliamentService.getTotalNumofStateMp(state);
		return ResponseEntity.ok(data);
	}
	
	
	
	
	
	
	
	
}
