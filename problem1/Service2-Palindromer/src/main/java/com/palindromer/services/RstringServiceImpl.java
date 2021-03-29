package com.palindromer.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palindromer.daos.RstringDao;
import com.palindromer.model.Rstring;



@Service
public class RstringServiceImpl implements RstringService {

    private RstringDao rstrDAO;

    @Autowired
    public RstringServiceImpl(RstringDao rstrdao) {
        this.rstrDAO = rstrdao;
    }

    @Override
    public List<Rstring> getAllRstrings() 
    {
        return rstrDAO.findAll();
    }
    
    
    public Rstring getLongestPalindromInDatabse()
    {
    	return rstrDAO.findlongestPalindromInDatabse();
    }

    /**
     * Sort method:Dzimtry
     * 
     * @Override public List<Users> getAllUsers() { return
     *           ud.findAll(Sort.by(Sort.Direction.ASC, "userId")); //Sorted By
     *           userId asc }
     * 
     */
    @Override
    public Rstring saveNewRstring(Rstring rstr) {
        return rstrDAO.save(rstr);
    }

    // @Override
    // public Category getCategoryById(int id){
    // return cd.getOne(id);
    // }

    @Override
    @Transactional
    public Rstring updateRstring(Rstring rstr) 
    {
        Rstring oldStr = rstrDAO.getOne(rstr.getrId());
        
        
        if (oldStr.getStr() != null) 
        {
        	oldStr.setStr(oldStr.getStr() );
        }
        
        if (oldStr.getLpalindrom() != null) 
        {
        	oldStr.setLpalindrom(oldStr.getLpalindrom());
        }
        
        if (oldStr.getPsize() != -1) 
        {
        	oldStr.setPsize(oldStr.getPsize());
        }
        
        return oldStr;
    }
    

    @Override
    public void deleteRstring(int id){
        Rstring oldR = rstrDAO.getOne(id);
        rstrDAO.deleteById(id);
       
    }
    
    
    
    
    static final String URL= "http://host.docker.internal:8085/readString";
	

	
	
   	public Rstring getPalindrom() throws Exception
   	{
   		  JSONObject json = readJsonFromUrl(URL);
   		  System.out.println(json.toString());
   		  System.out.println(json.get("str"));
   		  
   		  String str = json.get("str").toString();
   		  String lPalindrom = longestPalindrome(str);
   		 int palindromSize = lPalindrom.length();
   		 Rstring rstr = new Rstring(str, lPalindrom, palindromSize);
   				 
   	return rstr ;	
   	
   	}	
   	
   	 private static String readAll(Reader rd) throws IOException 
   	 {
   		    StringBuilder sb = new StringBuilder();
   		    int cp;
   		    while ((cp = rd.read()) != -1) {
   		      sb.append((char) cp);
   		    }
   		    return sb.toString();
   		  }

   		  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
   		    InputStream is = new URL(url).openStream();
   		    try {
   		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
   		      String jsonText = readAll(rd);
   		      JSONObject json = new JSONObject(jsonText);
   		      return json;
   		    } finally {
   		      is.close();
   		    }
   		  }
   	
   		  /**
   		   * return longest palindorm itself
   		   * @param s
   		   * @return
   		   */
   			public static String longestPalindrome(String s) {
   			    if(s==null || s.length()<=1)
   			        return s;
   			 
   			    int len = s.length();
   			    int maxLen = 1;
   			    boolean [][] dp = new boolean[len][len];
   			 
   			    String longest = null;
   			    for(int l=0; l<s.length(); l++){
   			        for(int i=0; i<len-l; i++){
   			            int j = i+l;
   			            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
   			                dp[i][j]=true;
   			 
   			                if(j-i+1>maxLen){
   			                   maxLen = j-i+1; 
   			                   longest = s.substring(i, j+1);
   			                }
   			            }
   			        }
   			    }
   			 
   			    return longest;
   			}
    
    
    
    
    
    
    
    
    
    
    
    
    


}