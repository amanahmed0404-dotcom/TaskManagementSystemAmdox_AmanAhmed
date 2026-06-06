package com.ayushi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushi.Entity.UserAuth;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth,Long> {
	
	Optional<UserAuth>findByUserOfficialEmail(String userOfficilEmail);
	Optional<UserAuth>findByResetToken(String resetToken);

}
