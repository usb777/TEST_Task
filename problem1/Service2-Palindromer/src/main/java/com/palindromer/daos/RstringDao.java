package com.palindromer.daos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.palindromer.model.Rstring;


@Repository
public interface RstringDao extends JpaRepository<Rstring, Integer> {
	
	
	
	  @Query(value = "select rid,str,lpalindrom,psize from rstring Having psize=MAX(psize)", 	  nativeQuery = true)
		 public Rstring findlongestPalindromInDatabse();

}