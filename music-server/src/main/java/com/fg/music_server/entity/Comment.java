package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("comment")
public class Comment {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 评论ID
    private Long userId; // 用户ID（外键）
    private Long targetId; // 目标ID（歌单或MV的ID）
    private String type; // 评论类型（playlist/mv）
    private Long parentId; // 父评论ID（用于回复）
    private String content; // 评论内容
    private LocalDateTime createTime; // 创建时间
}
