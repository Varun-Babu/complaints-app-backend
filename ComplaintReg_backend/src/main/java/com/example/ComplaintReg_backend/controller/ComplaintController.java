package com.example.ComplaintReg_backend.controller;

import com.example.ComplaintReg_backend.dao.ComplaintDao;
import com.example.ComplaintReg_backend.model.ComplaintModel;
import com.example.ComplaintReg_backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComplaintController {

    @Autowired
    private ComplaintDao cdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/complaint",consumes = "application/json", produces="application/json")
    public HashMap<String ,String> FileComplaint(@RequestBody ComplaintModel c){
        cdao.save(c);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/adminComplaint")
    public List<Map<String,String>> AdminComplaint(){
        return (List<Map<String,String>>) cdao.Complaints();

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/userComplaint")
    public List<Map<String,String>> UserComplaint(){
        return (List<Map<String,String>>) cdao.Complaints();
    }
}

