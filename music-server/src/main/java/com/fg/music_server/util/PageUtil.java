package com.fg.music_server.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageUtil {

    // 创建分页对象
    public static <T> Page<T> createPage(int pageNum, int pageSize) {
        return new Page<>(pageNum, pageSize);
    }

    // 创建分页结果
    public static <T> Result<Page<T>> createPageResult(Page<T> page) {
        return Result.success(page);
    }
}
