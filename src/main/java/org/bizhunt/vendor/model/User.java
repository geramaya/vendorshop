package org.bizhunt.vendor.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public @Data class User {
	
	private String username, firstname, lastname, email;
	
	
	public int calc() {
		return 12 * 5;
	}

}
