package com.fg.music_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("playlist_song")
public class PlaylistSong {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id; // 主键ID
    private Long playlistId; // 歌单ID（外键）
    private Long songId; // 歌曲ID（外键）
    private LocalDateTime createTime; // 创建时间
}
