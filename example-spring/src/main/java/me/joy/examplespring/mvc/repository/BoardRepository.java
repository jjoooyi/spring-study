package me.joy.examplespring.mvc.repository;

import me.joy.examplespring.mvc.domain.Board;
import me.joy.examplespring.mvc.parameter.BoardParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 게시판 repository
 * @author joy
 */
@Repository
public interface BoardRepository {

    List<Board> getList();

    Board get(int boardSeq);

    void save(BoardParameter board);

    void update(BoardParameter board);

    void delete(int boardSeq);
}
