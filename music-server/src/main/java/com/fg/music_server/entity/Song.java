package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("song")
public class Song {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Long singerId;
    private Long albumId;
    private Integer duration;
    private String lyrics;
    private String cover;
    private String playUrl;
    private LocalDateTime createTime;
}
