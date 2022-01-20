package com.pushok.shop.repo;

import com.pushok.shop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {


    UserEntity findUserEntityByEmail(String email);
    UserEntity findUserEntityByUsername(String username);


}
