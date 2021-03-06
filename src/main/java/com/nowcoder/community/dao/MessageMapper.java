package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    //查询当前用户的会话列表，针对每个会话返回一条最新的信息
    List<Message> selectConversations(int userId,int offset,int limit);
    //查询当前用户的会话数
    int selectConversationCount(int userId);
    //查询某个会话所包含的私信列表
    List<Message> selectLetters(String conversationId,int offset,int limit);
    //查询某个会话的私信数量
    int selectLetterCount(String conversationId);
    //查询未读数量
    int selectLetterUnreadCount(int userId,String conversationId);
    //新增私信
    int insertMessage(Message message);
    //更新已读状态
    int updateStatues(List<Integer> ids,int status);
    //查询某个主题下最新的通知
    Message selectLatestNotice(int userId,String topic);
    //某个主题下包含的通知数量
    int selectNotceCount(int userId,String topic);
    //查询未读的通知数量
    int selectNoticeUnreadCount(int userId,String topic);
    //查询某个主题所包含的通知列表
    List<Message> selectNotices(int userId,String topic,int offset,int limit);
}
