package com.nowcoder.community.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Message {
    private int id;
    private int fromId;
    private int toId;
    //会话对象 a_b之间
    private String conversationId;
    private String content;
    //已读，未读
    private int status;
    private Date createTime;
}
