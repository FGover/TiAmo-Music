package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user_follow")
public class UserFollow {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 关注ID
    private Long userId; // 用户ID
    private Long singerId; // 歌手ID
    private LocalDateTime createTime; // 关注时间
}
