package com.test.ayard.Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.test.ayard.Repositories.UserRepository;
import com.test.ayard.entities.UserBean;
import com.test.ayard.entities.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/login")
    public Map<String,String> LoginController(@RequestBody UserBean user){
        Map<String, String> msg = new HashMap<>();
        if(user.getId().equals(0)) {
            msg.put("result", "success");
            return msg;
        }
        Optional<UserInfo> result = userRepository.findById(user.getId());
        if(result.isEmpty()) {
            msg.put("result", "not found");
            return msg;
        }
        String pw = result.get().getPassword();
        if(pw.equalsIgnoreCase(user.getPassword())) {
            msg.put("result", "success");
            return msg;
        }
        msg.put("result", "wrong password");
        return msg;
    }
    @GetMapping("/UserInfo")
    public Map<String,Object> getUser(@RequestBody UserBean user){
        Map<String, Object> msg = new HashMap<>();       
        Optional<UserInfo> result = userRepository.findById(user.getId());
        if(result.isEmpty()) {
            msg.put("result", "not found");
            return msg;
        }
        msg.put("UserInfo", result.get());
        return msg;
    }
    @PostMapping("/signup")
    public Map<String, String> signUser(@RequestBody UserInfo user) {
        Map<String, String> msg = new HashMap<>();
        Optional<UserInfo> result = userRepository.findById(user.getId());
        if(!result.isEmpty()) {
            msg.put("result", "existed");
            return msg;
        }
        userRepository.save(user);
        msg.put("result", "success");
        return msg;
    }
    @RequestMapping("/test")
    public String getTestIndo(){
        Map<String, String> msg = new HashMap<>();
        msg.put("hello", "test");
        return "Test";
    }
}
