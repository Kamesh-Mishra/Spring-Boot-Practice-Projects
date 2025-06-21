package com.memberofparliament.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.memberofparliament.demo.entity.MemberOfParliament;

public interface MemberOfParliamentRepository extends JpaRepository<MemberOfParliament, String>{


	List<MemberOfParliament> findByState(String state);
	
	List<MemberOfParliament> findByConstituencyAndState(String constituency,String state);
	
	@Query(value="select count(*) as total from member_details", nativeQuery = true)
	String findTotalNumberOfMp();
	
	@Query(value="select count(*)  from member_details where state =:stateName", nativeQuery=true)
	Integer findTotalbyState(@Param("stateName") String stateName );
	
	
	
		
}
