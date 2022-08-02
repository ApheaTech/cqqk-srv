package com.aphea.cqqksrv.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author 航
 * @date 2022/7/22 10:17
 */
@Configuration
@MapperScan("com.aphea.cqqksrv.dao")
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {

        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        paginationInterceptor.setOverflow(true);
        paginationInterceptor.setLimit(500);

        return paginationInterceptor;
    }
}
