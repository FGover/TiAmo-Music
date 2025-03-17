package com.fg.music_server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fg.music_server.dto.AdminDTO;
import com.fg.music_server.entity.Admin;

public interface AdminService extends IService<Admin> {

    boolean register(AdminDTO adminDTO);

    boolean login(AdminDTO adminDTO);
}
