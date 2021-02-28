package model;

import dao.ChatDao;

public class PostchatLogic {
  public void execute(Chat chat) { // 引数を1つに変更
    ChatDao dao = new ChatDao();
    dao.create(chat);
  }
}