package com.zhiyou100.service.impl;

import com.zhiyou100.dao.MessageDao;
import com.zhiyou100.model.Message;
import com.zhiyou100.service.MessageService;
import com.zhiyou100.util.SqlSessionNew;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/27 10:00
 */
public class MessageServiceImpl implements MessageService {
    SqlSessionNew sqlSession=new SqlSessionNew();
    MessageDao messageDao=sqlSession.getSqlSession().getMapper(MessageDao.class);

    //写邮件
    @Override
    public boolean save(Message m,boolean send) {
        boolean a;
        if(send) {
            m.setSendStatus(2);
             a= messageDao.saveNew(m);
        }
        else {
            m.setSendStatus(0);
            a= messageDao.saveOld(m);
        }
        sqlSession.subimt();
        return a;
    }

    //发件箱
    @Override
    public List<Message> searchByKeyWord(String searchField, String keyword,int createId) throws SQLException {
        List<Message> list;
        Message u=new Message();
        if(keyword!=""||!keyword.equals("")) {
            if (searchField.equals("subject")) {
                u.setSubject("subject");
            } else if (searchField.equals("content")) {
                u.setContent("content");
            }
            u.setKeyword("%" + keyword + "%");
        }
        u.setSender(createId);
        list= messageDao.searchByKeyWord(u);
        for (Message m:list) {
            m.setReceiverName(m.getUser().getUsername());
        }
        sqlSession.subimt();
        return list;
    }
//修改删除状态send_delete=0
    @Override
    public boolean updateBystatus(int messageId) {
        boolean a=messageDao.updateBystatus(messageId);
        sqlSession.subimt();
        System.out.println("修改删除状态send_delete=0 "+a);
        return a;

    }

    @Override
    public boolean deleteById(int messageId) {
        boolean a=messageDao.deleteById(messageId);
        sqlSession.subimt();
        return a;
    }
    //草稿箱
    @Override
    public List<Message> searchByKeyWordSave(String searchField, String keyword,int createId) throws SQLException {
        List<Message> list;
        Message u=new Message();
        if(keyword!=""||!keyword.equals("")) {
            if (searchField.equals("subject")) {
                u.setSubject("subject");
            } else if (searchField.equals("content")) {
                u.setContent("content");
            }
            u.setKeyword("%" + keyword + "%");
        }
        u.setSender(createId);
        list= messageDao.searchByKeyWordSave(u);
        for (Message m:list) {
            m.setReceiverName(m.getUser().getUsername());
        }
        sqlSession.subimt();
        return list;
    }
    //垃圾箱
    @Override
    public List<Message> searchByKeyWordRemove(String searchField, String keyword,int createId) throws SQLException {
        List<Message> list;
        Message u=new Message();
        if(keyword!=""||!keyword.equals("")) {
            if (searchField.equals("subject")) {
                u.setSubject("subject");
            } else if (searchField.equals("content")) {
                u.setContent("content");
            }
            u.setKeyword("%" + keyword + "%");
        }        u.setSender(createId);

        list= messageDao.searchByKeyWordRemove(u);
        for (Message m:list) {
            m.setReceiverName(m.getUser().getUsername());
        }
        sqlSession.subimt();
        return list;
    }
    //收件箱
    @Override
    public List<Message> searchByKeyWordRec(String searchField, String keyword, int createId) throws SQLException {
        List<Message> list;
        Message u=new Message();
        if(keyword!=""||!keyword.equals("")) {
            if (searchField.equals("subject")) {
                u.setSubject("subject");
            } else if (searchField.equals("content")) {
                u.setContent("content");
            }
            u.setKeyword("%" + keyword + "%");
        }
        u.setSender(createId);
        list= messageDao.searchByKeyWordRec(u);
        for (Message m:list) {
            m.setSenderName(m.getUser().getUsername());
        }
        sqlSession.subimt();
        return list;
    }
    //删除收件箱的数据到垃圾箱中
    @Override
    public boolean updateByRec(int messageId) {
        boolean a=messageDao.updateByRec(messageId);
        sqlSession.subimt();
        return a;
    }

    @Override
    public Message findById(int messageId) throws SQLException {
        Message u=messageDao.findById(messageId);
        sqlSession.subimt();
        return u;
    }
    //查询根据id查名字
    @Override
    public String findByIdSendName(int messageId) throws SQLException {
        String u=messageDao.findByIdSendName(messageId);
        sqlSession.subimt();
        return u;
    }

    @Override
    public String findByIdReceName(int messageId) {
        String u=messageDao.findByIdReceName(messageId);
        sqlSession.subimt();
        return u;
    }
}
