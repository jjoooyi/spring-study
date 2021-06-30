package me.joy.vote.domain;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VoteOption {

    private Long optionId;
    private Long voteId;
    private String optionTitle;
    private String optionContent;

}
