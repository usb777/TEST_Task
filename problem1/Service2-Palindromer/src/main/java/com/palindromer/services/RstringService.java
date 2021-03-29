package com.palindromer.services;




import java.util.List;

import com.palindromer.model.Rstring;



public interface RstringService 
{
    public List<Rstring> getAllRstrings();
    public Rstring saveNewRstring(Rstring rstr);
    // public Category getCategoryById(int id);
    public Rstring updateRstring(Rstring rstr);
    public void deleteRstring(int id);
    
    public Rstring getPalindrom() throws Exception ;
    public Rstring getLongestPalindromInDatabse();
}