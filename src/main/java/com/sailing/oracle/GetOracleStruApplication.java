package com.sailing.oracle;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sailing.oracle.mapper")
@EnableApolloConfig
public class GetOracleStruApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetOracleStruApplication.class, args);
    }

}
