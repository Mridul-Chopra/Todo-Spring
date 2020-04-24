package net.paxcel.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.paxcel.model.UserLoginModel;

public interface UserLoginRepository extends JpaRepository<UserLoginModel,String> {

	Optional<UserLoginModel> findByUsername(String userName);
}
