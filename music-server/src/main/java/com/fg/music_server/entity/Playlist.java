package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("playlist")
public class Playlist {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 歌单id
    private String name; // 歌单名称
    private String cover; // 封面图片url
    private Long userId; // 创建用户id（外键）
    private String description; // 歌单描述
    private LocalDateTime createTime; // 创建时间
}
