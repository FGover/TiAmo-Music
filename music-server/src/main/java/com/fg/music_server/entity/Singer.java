package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("singer")
public class Singer {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 歌手id
    private String name; // 歌手名称
    private String avatar; // 歌手头像
    private String description; // 歌手简介
    private LocalDateTime createTime; // 创建时间
}
