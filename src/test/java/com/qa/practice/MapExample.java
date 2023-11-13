package com.qa.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		
		Map<String,String> map = new LinkedHashMap<>();
		
		map.put("firstname", "Marry");
		
		map.put("lastname", "Berry");
		System.out.println(map);
		
		String name=map.get("firstname");
		System.out.println(name);

	
	
	
	
	}

}
