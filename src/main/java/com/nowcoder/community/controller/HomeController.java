package com.nowcoder.community.controller;


import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.security.pkcs11.Secmod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;
    @RequestMapping(path="/go",method = RequestMethod.GET)
    public String getIndexPath(Model model, Page page){
        //方法调用前，springMVC会自动实例化Model和Page，并将Page注入Model
        //所以在themleft中可以直接访问Page对象的数据
        page.setRows(discussPostService.selectDiscussPostRows(0));//获取总行数
        page.setPath("/go");
        List<DiscussPost> list=discussPostService.findDiscussPost(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPost=new ArrayList<>();
        if (list!=null){
            for (DiscussPost post:list){
                Map<String,Object> map=new HashMap<>();
                map.put("post",post);
                User user=userService.selectById(post.getUserId());
                map.put("user",user);
                discussPost.add(map);
            }
        }

        model.addAttribute("discussposts",discussPost);




        return "/index";

    }

}
