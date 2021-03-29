package com.revature.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.revature.models.Rstring;



public interface IRstringService 
{
	
		
	public Rstring generateString();
	public Rstring readJsonString() throws FileNotFoundException, Exception ;

}
