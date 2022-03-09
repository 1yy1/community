package com.nowcoder.community.dao;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;
import sun.security.krb5.internal.Ticket;

@Mapper
@Deprecated
public interface LoginTicketMapper {
    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userid},#{ticket},#{status},#{expired}) "
    })
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);
    @Select({"select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket} "})
    LoginTicket selectByTicket(String ticket);
    @Update({
            "update login_ticket set status=#{status} ",
            "where ticket=#{ticket} "
    })
    int updateStatus(String ticket,int status);
    @Select({"select ticket,expired from login_ticket where user_id=#{userid}"})
    LoginTicket selectByUserid(int  userid);
}
