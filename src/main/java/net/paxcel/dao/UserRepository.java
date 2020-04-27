package net.paxcel.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import net.paxcel.model.*;

@Repository
public interface UserRepository extends JpaRepository< UserModel , String >{


}
