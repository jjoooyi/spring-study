package me.joy.examplespring.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.joy.examplespring.config.exception.BaseException;
import me.joy.examplespring.config.http.BaseResponse;
import me.joy.examplespring.config.http.BaseResponseCode;
import me.joy.examplespring.mvc.domain.Board;
import me.joy.examplespring.mvc.parameter.BoardParameter;
import me.joy.examplespring.mvc.service.BoardService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시판 controller
 * @author joy
 */
@Slf4j
@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {

    @Autowired
    private BoardService boardService;

    /**
     * 목록 리턴
      * @return
     */
    @GetMapping
    @ApiOperation(value = "목록 조회", notes = "게시물 목록 정보를 조회할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "23")
    })
    public BaseResponse<List<Board>> getList() {
        return new BaseResponse<>(boardService.getList());
    }

    /**
     * 상세 정보 리턴
     * @param boardSeq
     * @return
     */
    @GetMapping("/{boardSeq}")
    @ApiOperation(value = "상세 조회", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있습니다.")
    public BaseResponse<Board> get(@PathVariable int boardSeq) {
        Board board = boardService.get(boardSeq);
        //null 처리
        if (board == null) {
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[]{ "게시물" });
        }
        return new BaseResponse<>(board);
    }

    /**
     * 등록/수정 처리
     * @param parameter
     */
    @PutMapping("/save")
    @ApiOperation(value = "등록 / 수정 처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트가 가능합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
            @ApiImplicitParam(name = "title", value = "제목", example = "spring"),
            @ApiImplicitParam(name = "contents", value = "내용", example = "spring study")
    })
    public BaseResponse<Integer> save(BoardParameter parameter) {
        //제목 필수 체크
        if(!StringUtils.hasLength(parameter.getTitle())) {
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[]{"title", "제목"});
        }
        //내용 필수 체크
        if(!StringUtils.hasLength(parameter.getContents())) {
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[]{"contents", "내용"});
        }
        boardService.save(parameter);
        return new BaseResponse<>(parameter.getBoardSeq());
    }

    /**
     * 대용량 등록 처리1
     */
    @ApiOperation(value = "대용량 등록처리1", notes = "대용량 등록처리1")
    @PutMapping("/saveList1")
    public BaseResponse<Boolean> saveList1() {

        //테스트를 위한 랜덤 1000건의 데이터 생성
        int count = 0;
        List<BoardParameter> list = new ArrayList<>();
        while (true) {
            count++;
            String title = RandomStringUtils.randomAlphabetic(10);
            String contents = RandomStringUtils.randomAlphabetic(10);

            list.add(new BoardParameter(title, contents));
            if(count >= 10000) {
                break;
            }
        }
        //====================================

        long start = System.currentTimeMillis();
        boardService.saveList1(list);
        long end = System.currentTimeMillis();
        log.info("실행시간 : {}", (end-start) / 1000.0);
        return new BaseResponse<>(true);
    }

    /**
     * 대용량 등록 처리2
     */
    @ApiOperation(value = "대용량 등록처리2", notes = "대용량 등록처리2")
    @PutMapping("/saveList2")
    public BaseResponse<Boolean> saveList2() {

        //테스트를 위한 랜덤 1000건의 데이터 생성
        int count = 0;
        List<BoardParameter> list = new ArrayList<>();
        while (true) {
            count++;
            String title = RandomStringUtils.randomAlphabetic(10);
            String contents = RandomStringUtils.randomAlphabetic(10);
            list.add(new BoardParameter(title, contents));
            if(count >= 10000) {
                break;
            }
        }
        //====================================

        long start = System.currentTimeMillis();
        boardService.saveList2(list);
        long end = System.currentTimeMillis();
        log.info("실행시간 : {}", (end-start) / 1000.0);
        return new BaseResponse<>(true);
    }

    /**
     * 삭제 처리
     * @param boardSeq
     */
    @DeleteMapping("/{boardSeq}")
    @ApiOperation(value = "삭제 처리", notes = "게시물 번호에 해당하는 정보를 삭제합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "23"),
    })
    public BaseResponse<Boolean> delete(@PathVariable  int boardSeq) {
        Board board = boardService.get(boardSeq);
        if (board == null) {
            return new BaseResponse<>(false);
        }
        boardService.delete(boardSeq);
        return new BaseResponse<>(true);
    }
}
