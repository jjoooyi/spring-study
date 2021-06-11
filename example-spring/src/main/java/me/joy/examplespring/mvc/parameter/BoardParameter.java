package me.joy.examplespring.mvc.parameter;

import lombok.Data;
import me.joy.examplespring.mvc.domain.BoardType;

import java.util.Date;

@Data
public class BoardParameter {
    private int boardSeq;
    private BoardType boardType;
    private String title;
    private String contents;

    public BoardParameter() {}

    public BoardParameter(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
