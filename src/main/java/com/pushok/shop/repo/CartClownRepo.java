package com.pushok.shop.repo;

import com.pushok.shop.entity.CartClown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartClownRepo extends JpaRepository<CartClown, Long> {

}
