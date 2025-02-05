package com.example.tetama.services;

import com.example.tetama.Board;
import com.example.tetama.Task;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.example.tetama.utils.Tuple;

public class BoardService {
  private TaskService taskService;
  private  DatabaseService databaseService;

  /** A collection of boards, handled by the BoardService */
  Map <Integer, Board> boards;


  public BoardService(){
    this.taskService = new TaskService();
    this.databaseService = new DatabaseService();
    this.boards = new HashMap<>();
    loadBoards();
  }

  // Load boards from the database and populate the map
  private void loadBoards() {
    List<Board> boardList = databaseService.getAllBoards();
    for (Board board : boardList) {
      boards.put(setId(), board);
    }
  }

  public void createBoard(String name){
    int id = setId();
    Board board = new Board(name, id);
    boards.put(id, board);
    databaseService.storeBoard(board);
  }

  public int setId() {
    for (int i = 0; i < 1000; i++) { // Wont have more than 1000 boards. If that is true, CLEAN UP!
      if (!boards.containsKey(i)) {
        return i;
      }
    }
    throw new IllegalStateException("No available IDs"); // Fallback in case all IDs are taken
  }



  public void createTask(List<String> args, Board board){
    int id = board.getLastAssignedId();
    Task task = taskService.createTask(args, getBoardId(board), id);
    board.addTaskToList(task);
  }

  public void showBoards() {

    List <Board> showBoards = databaseService.getAllBoards();
    for(Board board : showBoards){
      System.out.println(board.toString());
    }

  }


  public int getBoardId(Board board){
    return board.getId();
  }
}
