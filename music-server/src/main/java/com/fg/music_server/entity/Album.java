package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("album")
public class Album {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 专辑id
    private String name; // 专辑名称
    private Long singerId; // 歌手id（外键）
    private String cover; // 专辑封面图
    private LocalDate releaseDate; // 发行日期
    private LocalDateTime createTime; // 创建时间
}
