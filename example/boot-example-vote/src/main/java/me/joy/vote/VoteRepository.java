package me.joy.vote;

import me.joy.vote.domain.Vote;
import me.joy.vote.domain.VoteAnswer;
import me.joy.vote.domain.VoteOption;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VoteRepository {

    List<Vote> getList();

    Vote getVote(Long voteId);

    List<VoteOption> getOptions(Long voteId);

    List<Map<String, Object>> getAnswer(Long voteId);

    boolean isExistAnswer(VoteAnswer answer);

    void addVote(Vote vote);

    void addVoteOptions(List<VoteOption> options);

    void saveAnswer(VoteAnswer answer);

    void updateVote(Vote vote);

    void deleteAnswer(VoteAnswer answer);

    void deleteVote(Long voteId);

    void deleteOptions(Long voteId);

}
