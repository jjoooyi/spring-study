package me.joy.vote.domain;

import lombok.Getter;
import lombok.Setter;
import me.joy.vote.VoteParam;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter @Setter
public class Vote {

    private Long voteId;
    private String voteTitle;
    private String voteContent;
    private String voteType;
    private int voteRange;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private int voteStatus;

    private Vote (){}

    public static Vote createVote(VoteParam voteParam) {
        Vote vote = new Vote();
        vote.setVoteTitle(voteParam.getVoteTitle());
        vote.setVoteContent(voteParam.getVoteContent());
        vote.setVoteType(voteParam.getVoteType());
        vote.setVoteRange(voteParam.getVoteRange());
        vote.setStartDate(voteParam.getStartDate());
        vote.setEndDate(voteParam.getEndDate());
        vote.setVoteStatus(voteParam.getVoteStatus());
        return vote;
    }

}
