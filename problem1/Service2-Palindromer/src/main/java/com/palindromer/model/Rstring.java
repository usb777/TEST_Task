package com.palindromer.model;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rstring {
	
@Id
@Column(name = "rid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int rId;
	
@Column(name = "str")
	private String str;

@Column(name = "lpalindrom")
	private String lpalindrom;

@Column(name = "psize")
	private int psize;
	
	public Rstring() 
	{	super();	}

	public Rstring(String str, String lpalindrom, int psize) {
		super();
		this.str = str;
		this.lpalindrom = lpalindrom;
		this.psize = psize;
	}
	
	
	

	public Rstring(int rId, String str, String lpalindrom, int psize) 
	{
		super();
		this.rId = rId;
		this.str = str;
		this.lpalindrom = lpalindrom;
		this.psize = psize;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getLpalindrom() {
		return lpalindrom;
	}

	public void setLpalindrom(String lpalindrom) {
		this.lpalindrom = lpalindrom;
	}

	public int getPsize() {
		return psize;
	}

	public void setPsize(int psize) {
		this.psize = psize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lpalindrom == null) ? 0 : lpalindrom.hashCode());
		result = prime * result + psize;
		result = prime * result + rId;
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rstring other = (Rstring) obj;
		if (lpalindrom == null) {
			if (other.lpalindrom != null)
				return false;
		} else if (!lpalindrom.equals(other.lpalindrom))
			return false;
		if (psize != other.psize)
			return false;
		if (rId != other.rId)
			return false;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rstring [rId=" + rId + ", str=" + str + ", lpalindrom=" + lpalindrom + ", psize=" + psize + "]";
	}


	
	
	
	
	
	
	
	
}
