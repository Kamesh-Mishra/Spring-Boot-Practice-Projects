package com.memberofparliament.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.memberofparliament.demo.entity.MemberOfParliament;
import com.memberofparliament.demo.repository.MemberOfParliamentRepository;
import com.memberofparliament.demo.service.MemberOfParliamentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberOfParliamentServiceImpl implements MemberOfParliamentService {

	MemberOfParliamentRepository memberOfParliamentRepository;

	@Override
	public List<MemberOfParliament> getMPbyState(String state) {
		List<MemberOfParliament> list = memberOfParliamentRepository.findByState(state);
		return list;
	}

	@Override
	public List<MemberOfParliament> getMPByConstituencyAndState(String constituency, String state) {
		List<MemberOfParliament> list = memberOfParliamentRepository.findByConstituencyAndState(constituency, state);
		return list;
	}

	@Override
	public String totalMp() {
		String total = memberOfParliamentRepository.findTotalNumberOfMp();
		return total;
	}

	@Override
	public Integer getTotalNumofStateMp(String state) {
		Integer total = memberOfParliamentRepository.findTotalbyState(state);
		return total;
	} 
	
	

}
