package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("comment_like")
public class CommentLike {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 点赞ID
    private Long userId; // 用户ID（外键）
    private Long commentId; // 评论ID（外键）
    private LocalDateTime createTime; // 点赞时间
}
