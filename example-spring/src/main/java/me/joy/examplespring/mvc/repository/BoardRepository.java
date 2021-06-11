package me.joy.examplespring.mvc.repository;

import me.joy.examplespring.mvc.domain.Board;
import me.joy.examplespring.mvc.parameter.BoardParameter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 게시판 repository
 * @author joy
 */
@Repository
public interface BoardRepository {

    List<Board> getList();

    Board get(int boardSeq);

    void save(BoardParameter board);

    void saveList(Map<String, Object> paramMap);

    void update(BoardParameter board);

    void delete(int boardSeq);
}
