package model;

import java.util.List;

import dao.ChatDao;

public class GetchatLogic {

  public List<Chat> execute() {
    ChatDao dao = new ChatDao();
    List<Chat> chatList = dao.findAll();
    return chatList;
  }
}