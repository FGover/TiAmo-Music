package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("playlist_rating")
public class PlaylistRating {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 自增ID
    private Long userId; // 用户ID（外键）
    private Long playlistId; // 歌单ID（外键）
    private Integer rating; // 评分（1-5）
    private LocalDateTime createTime; // 评分时间
}
