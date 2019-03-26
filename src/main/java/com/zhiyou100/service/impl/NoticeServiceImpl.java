package com.zhiyou100.service.impl;

import com.zhiyou100.dao.NoticeDao;
import com.zhiyou100.model.Notice;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.util.SqlSessionNew;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/25 15:17
 */
public class NoticeServiceImpl implements NoticeService {
    SqlSessionNew sqlSession=new SqlSessionNew();
    NoticeDao noticeDao=sqlSession.getSqlSession().getMapper(NoticeDao.class);
    @Override
    public List<Notice> searchByKeyWord(String searchField,String keyword) throws SQLException {
        List<Notice> list;
        Notice n=new Notice();
        if(keyword!=""||!keyword.equals("")) {
            if (searchField.equals("subject")) {
                n.setSubject("subject");
            } else if (searchField.equals("text")) {
                n.setText("text");
            }
            n.setKeyword("%" + keyword + "%");
        }
        list = noticeDao.searchByKeyWord(n);
        sqlSession.subimt();
        return list;
    }

    @Override
    public boolean add(Notice notice) {
        boolean a=noticeDao.add(notice);
        sqlSession.subimt();
        System.out.println(a);
        return a;
    }

    @Override
    public Notice findById(int noticeId) throws SQLException {
        Notice u=noticeDao.findById(noticeId);
        sqlSession.subimt();
        return u;
    }

    @Override
    public boolean update(Notice notice) {
        boolean a=noticeDao.update(notice);
        sqlSession.subimt();
        return a;
    }

    @Override
    public boolean deleteById(int noticeId) {
        boolean a=noticeDao.deleteById(noticeId);
        sqlSession.subimt();
        return a;
    }
}
