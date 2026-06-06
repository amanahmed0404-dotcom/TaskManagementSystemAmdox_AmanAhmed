package com.ayushi.DTO;

import com.ayushi.Enum.Role;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@Builder

public class RegisterRequestDTO {
	
	public String userName;
	public String userOfficialEmail;
	public String password;
	public Role role;
	
	
}
