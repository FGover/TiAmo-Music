package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("mv")
public class Mv {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // mv id
    private String name; // mv名称
    private Long singerId; // 歌手id
    private String videoUrl; // mv地址
    private LocalDateTime createTime; // 创建时间
}
