package com.gy.shop.shopapi.service.impl;

import com.gy.shop.shopapi.entity.User;
import com.gy.shop.shopapi.jwt.utils.Audience;
import com.gy.shop.shopapi.jwt.utils.JwtUtils;
import com.gy.shop.shopapi.repository.UserRepository;
import com.gy.shop.shopapi.service.UserService;
import com.gy.shop.shopapi.service.support.Items;
import com.gy.shop.shopapi.service.support.OrderType;
import com.gy.shop.shopapi.service.support.PageQuery;
import com.gy.shop.shopapi.service.support.QueryUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoyun
 * 2018/4/18 10:57
 * 描述:
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Audience audienceEntity;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Audience audienceEntity) {
        this.userRepository = userRepository;
        this.audienceEntity = audienceEntity;
    }


    /**
     * @param userName 用户名
     * @return
     */
    @Override
    public User findByName(String userName) {
        return this.userRepository.findByAccount(userName);
    }

    @Override
    public String parseToken(String token) {
        String auth = token.substring(7, token.toString().length());
        Claims claims = JwtUtils.parseJWT(auth, audienceEntity.getBase64Secret());
        return (String) claims.get("loginUser");
    }
    @Override
    public String saveReturnId(User user) {
        this.userRepository.save(user);
        return user.getId();
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User saveReturnEntity(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteById(String s) {
        this.userRepository.deleteById(s);
    }

    @Override
    public User queryById(String s) throws Exception {
        return this.userRepository.getOne(s);
    }

    @Override
    public Items<User> query() {
        List<User> all = this.userRepository.findAll();
        long count = this.userRepository.count();
        return new Items<>(count, all);
    }

    @Override
    public PageQuery<User> query(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<User>().query(userRepository, currentPage, pageSize, orderType, sortField);
    }
}
