package com.fg.music_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // 关闭 CSRF 保护，否则 POST 请求可能会被拦截
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/admin/login",
                                "/api/admin/register",
                                "/v3/api-docs",
                                "/v3/api-docs/*",
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/swagger-config"  // 允许访问 Swagger 配置
                        ).permitAll()  // 允许无需认证
                        .anyRequest().authenticated()  // 其他接口需要认证
                )
                .formLogin(AbstractHttpConfigurer::disable) // 禁用默认表单登录
                .httpBasic(AbstractHttpConfigurer::disable); // 禁用 HTTP Basic 认证

        return http.build();
    }

    /**
     * 配置密码加密器，使用 BCrypt 加密
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
