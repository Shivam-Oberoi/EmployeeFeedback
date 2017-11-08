package com.nagarro.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nagarro.model.User;

public class UserRowMapper implements RowMapper {

@Override
public Object mapRow(ResultSet rs, int arg1) throws SQLException {
	User project = new User();
	project.setId(rs.getInt(2));
	project.setName(rs.getString(1));
    return project;
}
}
