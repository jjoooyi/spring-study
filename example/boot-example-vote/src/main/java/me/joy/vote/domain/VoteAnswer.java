package me.joy.vote.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class VoteAnswer {

    private Long voteId;
    private String memberId;
    private Long optionId;

}
