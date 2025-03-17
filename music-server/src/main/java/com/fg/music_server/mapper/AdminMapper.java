package com.fg.music_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fg.music_server.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
