package com.nowcoder.community.actuator;

import com.nowcoder.community.util.CommunityUtil;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
@Endpoint(id = "database")
public class DatabaseEndpoint {
    private Logger logger= LoggerFactory.getLogger(DatabaseEndpoint.class);
    @Autowired
    DataSource dataSource;
    @ReadOperation
    private String CheckConnection(){
        try( Connection connection = dataSource.getConnection()){
            return CommunityUtil.getJSONString(0,"成功");
        }catch (SQLException e){
            logger.error("获取数据库连接失败"+e.getMessage());
            return CommunityUtil.getJSONString(1,"失败");
        }
    }
}
