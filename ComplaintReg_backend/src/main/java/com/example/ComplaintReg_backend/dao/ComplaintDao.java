package com.example.ComplaintReg_backend.dao;

import com.example.ComplaintReg_backend.model.ComplaintModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository<ComplaintModel,Integer> {


    @Query(value = "SELECT u.`dob`, u.`email`, u.`name`, u.`username`, c.`complaint` FROM `user` u JOIN complaints c ON c.user_id = u.id;",nativeQuery = true)
    List<Map<String,String>> Complaints();
}
