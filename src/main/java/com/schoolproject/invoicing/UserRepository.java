package com.schoolproject.invoicing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Integer createUser(String userName, String password){
        String sql = "INSERT INTO newuser (user_name, password) VALUES (:userName, :password)";
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("userName",userName);
        paramMap.put("password",password);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        return (Integer) keyHolder.getKeys().get("id");

    }

    public String getPassword(String userName){
        String sql = "SELECT password FROM newuser WHERE user_name = :userName";
        Map<String,Object>paramMap= new HashMap<>();
        paramMap.put("userName", userName);
        String result = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return result;
    }

    public UserDTO findUserByName (String userName) {
        String sql = "SELECT * FROM newuser WHERE user_name = :userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        UserDTO result = jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(UserDTO.class));
        return result;
    }
}
