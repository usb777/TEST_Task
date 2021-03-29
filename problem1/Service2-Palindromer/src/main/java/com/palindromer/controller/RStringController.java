package com.palindromer.controller;

/**
1. Receives string input over an API
2. Stores the longest palindrome in provided database
3. Retrieves the stored palindrome over an API 
 */
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palindromer.model.Rstring;
import com.palindromer.services.RstringService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("palindrom")
public class RStringController 
{
    private RstringService rstrService;

    @Autowired   // by contructor
    public RStringController(RstringService rstrService) {
        this.rstrService =rstrService;
    }

    /**
     * get all palindroms from Databases
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Rstring>> getAllRstrings() {
        return new ResponseEntity(rstrService.getAllRstrings() , HttpStatus.OK);
    }
    
    /**
     * Get palindrom Over Api and save it in Database
     * @return
     * @throws Exception
     */
    @GetMapping("currentpalindrom")
   	public ResponseEntity<Rstring> returnPalindrom() throws Exception 
   	{ 
    	rstrService.saveNewRstring(rstrService.getPalindrom()); //save longest palindrom
   		return new ResponseEntity<Rstring> (rstrService.getPalindrom(), HttpStatus.OK);
   	}
    
    //longest Palindrom
    @GetMapping("longestpalindrom")
   	public ResponseEntity<Rstring> longestPalindromFromDatabase() throws Exception 
   	{ 
    	
   		return new ResponseEntity<Rstring> (rstrService.getLongestPalindromInDatabse() , HttpStatus.OK);
   	}
    
    
    

    @PostMapping
    public ResponseEntity<Rstring> saveNewRstring(@RequestBody Rstring rstr)
    {
        if(rstr.getrId()!=0){
            return new ResponseEntity("Id must be 0", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity( rstrService.saveNewRstring(rstr) , HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Rstring> updateRstring(@RequestBody Rstring rstr) {
        if (rstr.getrId() == 0) {
            return new ResponseEntity("Rstring id must not be 0", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(rstrService.updateRstring(rstr)  , HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<Object> deleteCategory(@PathVariable int id){    	
    	rstrService.deleteRstring(id);
    	  return new ResponseEntity( HttpStatus.OK);  	
    	
        
    }  //deleteCategory(@PathVariable int id)
    
    

    // @GetMapping("{id}")
    // public ResponseEntity<Category> getCategoryById(@PathVariable int id){
    // if(id == 0){
    // return new ResponseEntity("Category id must not be 0",
    // HttpStatus.BAD_REQUEST);
    // }
    // return new ResponseEntity(cs.getCategoryById(id), HttpStatus.CREATED)
    // }

}