package com.memberofparliament.demo.service;

import java.util.List;
import com.memberofparliament.demo.entity.MemberOfParliament;

public interface MemberOfParliamentService {


	List<MemberOfParliament> getMPbyState(String state);
	
	List<MemberOfParliament> getMPByConstituencyAndState(String constituency,String state);
	
	String totalMp();
	
	Integer getTotalNumofStateMp(String state);
	
}
