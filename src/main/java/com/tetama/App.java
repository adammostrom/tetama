package com.example.tetama;

import com.example.tetama.services.BoardService;
import com.example.tetama.services.TaskService;

/** Hello world! */
public class App {
  public static void main(String[] args) {

    BoardService boardService = new BoardService();

    boardService.createBoard("Trial");

    boardService.showBoards();



  }
}
