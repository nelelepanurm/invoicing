package com.schoolproject.invoicing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createUser(String userName, String password){
        String sql = "INSERT INTO newuser (user_name, password) VALUES (:userName, :password)";
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("userName",userName);
        paramMap.put("password",password);
        jdbcTemplate.update(sql, paramMap);

    }

    public String getPassword(String userName){
        String sql = "SELECT password FROM newuser WHERE user_name = :userName";
        Map<String,Object>paramMap= new HashMap<>();
        paramMap.put("userName", userName);
        String result = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return result;
    }
}