package com.fg.music_server.controller;

import com.fg.music_server.dto.AdminDTO;
import com.fg.music_server.service.AdminService;
import com.fg.music_server.util.JwtUtil;
import com.fg.music_server.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
@Tag(name = "管理端接口")
public class AdminController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @Operation(summary = "管理员登录接口")
    public Result<Map<String, String>> login(@RequestBody AdminDTO adminDTO) {
        boolean flag = adminService.login(adminDTO);
        if (!flag) {
            return Result.error(400, "用户名或密码错误");
        }
        // 登录成功，生成token
        String token = "Bearer " + jwtUtil.generateToken(adminDTO.getUsername());
        log.info("用户{}登录成功，token为{}", adminDTO.getUsername(), token);
        Map<String, String> data = new HashMap<>();
        data.put("token", token);
        return Result.success(data);
    }

    @PostMapping("/register")
    @Operation(summary = "管理员注册接口")
    public Result<Void> register(@RequestBody AdminDTO adminDTO) {
        boolean flag = adminService.register(adminDTO);
        if (!flag) {
            return Result.error(400, "用户名已存在");
        }
        return Result.success();
    }
}
