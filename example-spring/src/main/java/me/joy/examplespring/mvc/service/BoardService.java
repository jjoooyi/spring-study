package me.joy.examplespring.mvc.service;

import me.joy.examplespring.mvc.domain.Board;
import me.joy.examplespring.mvc.parameter.BoardParameter;
import me.joy.examplespring.mvc.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 게시판 service
 * @author joy
 */
@Service
public class BoardService {

    @Autowired
    private BoardRepository repository;

    /**
     * 목록 리턴
      * @return
     */
    public List<Board> getList() {
        return repository.getList();
    }

    /**
     * 상세 정보 리턴
     * @param boardSeq
     * @return
     */
    public Board get(int boardSeq) {
        return repository.get(boardSeq);
    }

    /**
     * 등록/업데이트 처리
     * @param parameter
     */
    public void save(BoardParameter parameter) {
        Board board = repository.get(parameter.getBoardSeq());
        if (board == null) {
            repository.save(parameter);
        } else {
            repository.update(parameter);
        }
    }

    /**
     * 단순 반복문을 이용한 등록 처리
     */
    public void saveList1(List<BoardParameter> boardList) {
        for(BoardParameter parameter : boardList) {
            repository.save(parameter);
        }
    }

    /**
     * 100개씩 배열에 담아서 일괄 등록 처리
     */
    public void saveList2(List<BoardParameter> boardList) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("boardList", boardList);
        repository.saveList(paramMap);
    }
    
    /**
     * 삭제 처리
     * @param boardSeq
     */
    public void delete(int boardSeq) {
        repository.delete(boardSeq);
    }
}
