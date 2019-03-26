package com.zhiyou100.service;

import com.zhiyou100.model.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 张峥
 * @Date: 2019/2/27 10:00
 */
public interface MessageService {
   public boolean save(Message m, boolean send);

   public List<Message> searchByKeyWord(String searchField, String keyword, int createId) throws SQLException;

   public boolean updateBystatus(int messageId);

   public boolean deleteById(int messageId);

  public List<Message> searchByKeyWordSave(String searchField, String keyword, int createId) throws SQLException;

  public List<Message> searchByKeyWordRemove(String searchField, String keyword, int createId) throws SQLException;

   public List<Message> searchByKeyWordRec(String searchField, String keyword, int createId) throws SQLException;

   public boolean updateByRec(int messageId);

   public Message findById(int messageId) throws SQLException;

   public String findByIdSendName(int messageId) throws SQLException;

   public String findByIdReceName(int messageId);
}
