package net.paxcel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.paxcel.model.AuthoritiesModel;

@Repository
public interface AuthoritiesRepository extends JpaRepository< AuthoritiesModel, String >{

}
