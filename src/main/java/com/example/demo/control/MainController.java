package com.example.demo.control;


import com.example.demo.config.WebSecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model){
        model.addAttribute("name",account);
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginPost")
    public @ResponseBody Map<String,Object> loginPost(String account,String password,HttpSession session){
        Map<String,Object> map = new HashMap<>();
        if(!"123456".equals(password)){
            map.put("success",false);
            map.put("message","密码错误");
            return map;
        }
        session.setAttribute(WebSecurityConfig.SESSION_KEY,account);
        map.put("success",true);
        map.put("message","登陆成功");
        return map;
    }

    @RequestMapping("/logout1")
    public String loginout(HttpSession session){
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
