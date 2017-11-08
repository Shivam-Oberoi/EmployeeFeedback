package com.nagarro.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nagarro.model.Project;

public class ProjectRowMapper implements RowMapper {

@Override
public Object mapRow(ResultSet rs, int arg1) throws SQLException {
	Project project = new Project();
	project.setId(rs.getInt(1));
	project.setName(rs.getString(2));
    return project;
}
}
