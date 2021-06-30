package me.joy.vote;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.joy.vote.domain.VoteOption;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
public class VoteParam {
    private Long voteId;
    private String voteTitle;
    private String voteType;
    private int voteRange;
    private int voteStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String voteContent;
    private List<VoteOption> options;
}
