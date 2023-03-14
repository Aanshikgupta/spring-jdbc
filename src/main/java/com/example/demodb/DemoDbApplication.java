package com.example.demodb;

import com.example.demodb.Models.Student;
import com.example.demodb.dao.PersonJdbcDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;


@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
public class DemoDbApplication implements CommandLineRunner {

    @Autowired
    PersonJdbcDao personJdbcDao;

    private org.slf4j.Logger logger= (org.slf4j.Logger) LoggerFactory.getLogger(this.getClass());
    public static void main(String[] args) {
        SpringApplication.run(DemoDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personJdbcDao.insert();
        logger.info("All users -> {}",personJdbcDao.findAll());
        logger.info("All users with id 1001 -> {}",personJdbcDao.findById(1001));
        logger.info("Update user with id 1001 -> {}",personJdbcDao.update(new Student(1001,"Golu",20,"Golu@gmail.com"),1001));
        logger.info("Insert new user -> {}",personJdbcDao.insert(new Student(1004,"HelloMe",22,"gg@gmail.com")));
        logger.info("Delete users with id 1001 -> {}",personJdbcDao.deleteById(1001));
    }
}
