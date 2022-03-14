package com.nowcoder.community.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Comment {
    private int id;
    private int userId;
    //评论的类型 1为帖子，2为评论，3为用户
    private int entityType;
    //帖子的id
    private int  entityId;
    //评论的目标
    private int targetId;
    private String content;
    private int status;
    private Date createTime;

}
