package com.revature.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.revature.models.Rstring;
import com.revature.services.IRstringService;


@RestController
public class RstringController {
	
	
	private IRstringService rs;
	
	 @Autowired
	    public RstringController(IRstringService rs)
	 {
	        this.rs = rs;
	  }
	
	
	
	@GetMapping("genString")
	public ResponseEntity<Rstring> getGeneratedString() throws FileNotFoundException 
	{
		Rstring rstr  = rs.generateString();
		
		  JSONObject jo = new JSONObject();
          
	        // putting data to JSONObject
	        jo.put("str", rstr.getStr());
	        
		   PrintWriter pw = new PrintWriter("JSONString.json");
	        pw.write(jo.toJSONString());	          
	        pw.flush();
	        pw.close();	
		
		return new ResponseEntity<Rstring> ( rstr, HttpStatus.OK);
	}
		
	@GetMapping("readString")
	public ResponseEntity<Rstring> readJsonFileString() throws Exception, IOException 
	{    
		Rstring rstr  = rs.readJsonString();
		
		return new ResponseEntity<Rstring> ( rstr, HttpStatus.OK);
	}
		

}


// https://www.geeksforgeeks.org/parse-json-java/
