package com.fg.music_server.config;

import com.fg.music_server.Interceptor.JwtAdminInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtAdminInterceptor jwtAdminInterceptor;

    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册拦截器");
        registry.addInterceptor(jwtAdminInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns(
                        "/api/admin/login",
                        "/api/admin/register",
                        "/v3/api-docs",
                        "/v3/api-docs/*",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/v3/api-docs/swagger-config"  // 允许访问 Swagger 配置
                );
    }

    /**
     * 配置跨域
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 允许所有接口跨域
                .allowedOrigins("http://localhost:5173", "http://localhost:5174")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 允许所有请求方法
                .allowedHeaders("*")  // 允许所有请求头
                .maxAge(3600);  // 预检请求的缓存时间
    }
}
