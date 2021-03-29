package com.revature.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import com.revature.models.Rstring;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RstringService implements IRstringService {

	@Override
	public Rstring generateString() 
	{
		// TODO Auto-generated method stub
	   String genString = "";
	   Rstring rstr = new Rstring();
	   
		Map<Integer,Character> mapA = new TreeMap<Integer,Character>();
		mapA.put(0, 'a');
		mapA.put(1, 'b');
		mapA.put(2, 'c');
		mapA.put(3, 'd');
		mapA.put(4, 'e');
		mapA.put(5, 'f');
		mapA.put(6, 'g');
		mapA.put(7, 'h');
		mapA.put(8, 'i');
		mapA.put(9, 'j');
		mapA.put(10, 'k');
		mapA.put(11, 'l');
		mapA.put(12, 'm');
		mapA.put(13, 'n');
		mapA.put(14, 'o');
		mapA.put(15, 'p');
		mapA.put(16, 'q');
		mapA.put(17, 'r');
		mapA.put(18, 's');
		mapA.put(19, 't');
		mapA.put(20, 'u');
		mapA.put(21, 'v');
		mapA.put(22, 'w');
		mapA.put(23, 'x');
		mapA.put(24, 'y');
		mapA.put(25, 'z');
		mapA.put(26, ' ');
		mapA.put(27, ' ');
		mapA.put(28, ' ');
		mapA.put(29, ' ');
		mapA.put(30, ' ');
		
		int min = 0;
		int max = 30;
   
			

	   StringBuilder sb = new StringBuilder();
	   
	   for (int i=0;i<generateStringSize();i++)
	   {
		   sb.append(   mapA.get(  (int)Math.round((Math.random() * ((max - min) + 1)) + min)   )   ) ;
	   }
     
		//(Math.random() * ((max - min) + 1)) + min
		
	   rstr.setStr(sb.toString());
		
		
		
		return rstr;
	}
	

 	
	private static int generateStringSize()
	{
		int min = 3;
		int max = 1000;
        int stringSize = (int) Math.round((Math.random() * ((max - min) + 1)) + min)	;
		
		return stringSize;
	}
	
	
	public Rstring readJsonString() throws FileNotFoundException, Exception 
	{
		Object obj = null;
		
		// TODO Auto-generated method stub
		 // parsing file "JSONExample.json" 
        obj = new JSONParser().parse(new FileReader("JSONString.json")); 
    //     System.out.println("============"+obj.toString()+"============");
       // typecasting obj to JSONObject 
       JSONObject jo = (JSONObject) obj; 
    //   System.out.println("============"+jo.toString()+"============");
       // getting firstName and lastName 
       String str = (String) jo.get("str"); 
    //   System.out.println("=====str======="+str+"=====str=======");
       
       Rstring rstr=new Rstring(str);
     
		return rstr;
	}

}