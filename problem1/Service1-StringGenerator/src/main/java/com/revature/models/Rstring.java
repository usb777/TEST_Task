package com.revature.models;

import javax.validation.constraints.Size;

public class Rstring {
	
<<<<<<< HEAD
	@Size(min = 2, max = 1000)
=======
	@Size(min = 3, max = 1000)
>>>>>>> bf7590bc064ed0e7cd5925eb2ffd8fb5a5ef08de
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Rstring(String str)
	{
		super();
		this.str = str;
	}	
	
	public Rstring()
	{
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RString [str=" + str + "]";
	}	

	
	
	
	
}
