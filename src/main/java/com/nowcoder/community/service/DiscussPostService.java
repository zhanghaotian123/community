package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPost(int userId,int offset,int limit){
        return discussPostMapper.selectDiscussPost( userId, offset, limit);
    }
    public int selectDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
