package com.zhiyou100.dao;

import com.zhiyou100.model.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/27 10:00
 */
public interface MessageDao {
   public boolean saveNew(Message m);

    public boolean saveOld(Message m);

   public List<Message> searchByKeyWord(Message message) throws SQLException;

   public boolean updateBystatus(int messageId);

   public boolean deleteById(int messageId);

   public List<Message> searchByKeyWordSave(Message message) throws SQLException;

   public List<Message> searchByKeyWordRemove(Message message) throws SQLException;

   public List<Message> searchByKeyWordRec(Message message) throws SQLException;

  public boolean updateByRec(int messageId);

   public Message findById(int messageId) throws SQLException;

   public String findByIdSendName(int messageId) throws SQLException;

   public String findByIdReceName(int messageId);
}
