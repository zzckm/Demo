package com.zhiyou100.dao;

import com.zhiyou100.model.Notice;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/25 15:22
 */
public interface NoticeDao  {
    public List<Notice> searchByKeyWord(Notice n) throws SQLException;

   public boolean add(Notice notice);

   public Notice findById(int noticeId) throws SQLException;

   public boolean update(Notice notice);

   public boolean deleteById(int noticeId);
}
