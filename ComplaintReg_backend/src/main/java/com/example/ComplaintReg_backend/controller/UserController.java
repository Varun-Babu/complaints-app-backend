package com.example.ComplaintReg_backend.controller;

import com.example.ComplaintReg_backend.dao.UserDao;
import com.example.ComplaintReg_backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao udao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/SignUp",consumes = "application/json", produces="application/json")
    public HashMap<String ,String> SignUp(@RequestBody UserModel u){
        udao.save(u);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/Login",consumes = "application/json", produces="application/json")
    public HashMap<String ,String> Login(@RequestBody UserModel u) {
        List<UserModel> result = (List<UserModel>) udao.UserLogin(u.getEmail(), u.getPassword());
        HashMap<String,String> map = new HashMap<>();
        if(result.size() == 0){
            map.put("status","failed");
            map.put("message","user does not exist");
    }
        else{
            int id = result.get(0).getId();
            map.put("userId",String.valueOf(id));
            map.put("status","success");
            map.put("message","login successfull");
        }
        return map;
    }


}
