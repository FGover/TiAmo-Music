package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("notification")
public class Notification {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 通知ID
    private Long userId; // 接收通知的用户ID
    private Long formUserId; // 触发通知的用户ID
    private Long targetId; // 相关目标ID
    private String type; // 通知类型（comment_reply/comment_like）
    private String content; // 通知内容
    private Boolean isRead; // 是否已读
    private LocalDateTime createTime; // 通知时间
}
