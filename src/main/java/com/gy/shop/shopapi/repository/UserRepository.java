package com.gy.shop.shopapi.repository;

import com.gy.shop.shopapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gaoyun
 * 2018/4/18 11:01
 * 描述:
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByAccount(String account);
}
