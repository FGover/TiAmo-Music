package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user_favorite")
public class UserFavorite {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 自增ID
    private Long userId; // 用户ID（外键）
    private Long targetId; // 收藏或点赞对象ID
    private String type; // 类型（歌单/MV/歌曲）
    private String action; // 操作（点赞/收藏）
    private LocalDateTime createTime; // 创建时间
}
