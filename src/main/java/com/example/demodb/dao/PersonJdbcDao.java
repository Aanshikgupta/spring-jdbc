package com.example.demodb.dao;


import com.example.demodb.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonJdbcDao{

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Student> findAll(){
        return jdbcTemplate.query("SELECT * FROM student",new BeanPropertyRowMapper<>(Student.class));
    }

    public void insert() {
        jdbcTemplate.execute("INSERT INTO  STUDENT VALUES(100,21,'Aanshik@gmail','aanshik gupta')");

        jdbcTemplate.execute("INSERT INTO  STUDENT VALUES(1001,24,'yash@gmail','Yash')");
    }
    
    public Student findById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Student WHERE id=?",new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));
    }

    public int deleteById(int id){
        return jdbcTemplate.update("DELETE FROM Student WHERE id=?",new Object[]{id});
    }

    public int insert(Student student){
        return jdbcTemplate.update("INSERT INTO  STUDENT VALUES "+ "(?,?,?,?)",new Object[]{student.getId(),student.getAge(),student.getName(),student.getEmail()});
    }

    public int update(Student student,int id){
        return jdbcTemplate.update("UPDATE STUDENT SET id=?,age=?,email=?,name=? WHERE ID=?",new Object[]{id,student.getAge(),student.getName(),student.getEmail(),id});
    }
}
