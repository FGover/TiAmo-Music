package com.fg.music_server.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fg.music_server.dto.AdminDTO;
import com.fg.music_server.entity.Admin;
import com.fg.music_server.exception.CustomException;
import com.fg.music_server.mapper.AdminMapper;
import com.fg.music_server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 注册
    @Override
    public boolean register(AdminDTO adminDTO) {
        // 判断数据库有无这个用户名
        Admin user = adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", adminDTO.getUsername()));
        if (user != null) {
            throw new CustomException(400, "用户名已存在");
        }
        Admin admin = new Admin();
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
        adminMapper.insert(admin);
        return true;
    }

    @Override
    public boolean login(AdminDTO adminDTO) {
        Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", adminDTO.getUsername()));
        if (admin == null) {
            throw new CustomException(400, "用户名不存在");
        }
        if (!passwordEncoder.matches(adminDTO.getPassword(), admin.getPassword())) {
            throw new CustomException(400, "密码错误");
        }
        return true;
    }
}
