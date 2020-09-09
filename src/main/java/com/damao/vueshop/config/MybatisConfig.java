package com.damao.vueshop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 呆毛
 */

@Configuration
@MapperScan("com.damao.vue_shop.mapper")
public class MybatisConfig {
}
