package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class helloController {  // Class name should be capitalized (convention)
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "World") String name) {
        // Insert a new message into the hello table
        jdbcTemplate.update("INSERT INTO hello (message) VALUES (?)", "Hello, " + name);

        // Retrieve the latest id and message
        String sql = "SELECT id, message FROM hello ORDER BY id DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                "ID: " + rs.getLong("id") + ", Message: " + rs.getString("message")
        );

    }
}
