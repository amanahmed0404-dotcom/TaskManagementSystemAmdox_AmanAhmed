package com.ayushi.Security;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class TokenBlockService {
	
		private final Set<String> blockListedToken = ConcurrentHashMap.newKeySet();
		
		public void blockToken(String token) {
			blockListedToken.add(token);
		}
		
		public boolean isBlockToken(String token) {
			return blockListedToken.contains(token);
		}
}