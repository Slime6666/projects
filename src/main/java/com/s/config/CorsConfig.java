package com.s.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
//@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //*表示可以访问所有地址
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        //最终的结果是可以 在跨域请求的时候获取同一个 session
        corsConfiguration.setAllowCredentials(true);
    return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //配置访问地址
        source.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(source);
    }
}
