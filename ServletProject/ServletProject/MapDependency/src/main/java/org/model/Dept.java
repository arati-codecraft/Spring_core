package org.model;
import java.util.*;

public class Dept 
{
	private Map<Integer,String> map;
	public void setDept(Map<Integer,String> map) 
	{
		this.map=map;
	}
	public void showList() 
	{
		Set<Map.Entry<Integer, String>> set=map.entrySet();
		for(Map.Entry<Integer,String> m:set) 
		{
			System.out.println(m.getKey()+"\t"+m.getValue());
		}
	}

}
