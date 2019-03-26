package com.zhiyou100.service;

import com.zhiyou100.model.Notice;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/25 15:17
 */
public interface NoticeService {
    public List<Notice> searchByKeyWord(String field, String keyword) throws SQLException;

    public boolean add(Notice notice);

   public Notice findById(int noticeId) throws SQLException;

   public boolean update(Notice notice);

   public boolean deleteById(int noticeId);
}
