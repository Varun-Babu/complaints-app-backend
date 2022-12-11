package com.example.ComplaintReg_backend.dao;

import com.example.ComplaintReg_backend.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`, `dob`, `email`, `name`, `password`, `username` FROM `user` WHERE `email` =:email AND `password`=:password",nativeQuery = true)
    List<UserModel> UserLogin(@Param("email")String email,@Param("password")String password);
}
