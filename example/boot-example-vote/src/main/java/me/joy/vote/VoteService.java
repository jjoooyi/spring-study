package me.joy.vote;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joy.vote.domain.Vote;
import me.joy.vote.domain.VoteAnswer;
import me.joy.vote.domain.VoteOption;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;

    public List<Vote> getList() {
        return voteRepository.getList();
    }

    public Vote getVote(Long voteId) {
        return voteRepository.getVote(voteId);
    }

    public List<VoteOption> getOptions(Long voteId) {
        return voteRepository.getOptions(voteId);
    }

    public List<Map<String, Object>> getAnswer(Long voteId) {
        return voteRepository.getAnswer(voteId);
    }

    public Long addVote(VoteParam voteParam) {
        Vote vote = Vote.createVote(voteParam);
        voteRepository.addVote(vote);
        Long voteId = vote.getVoteId();
        List<VoteOption> options = voteParam.getOptions();
        options
                .forEach(option -> option.setVoteId(voteId));
        voteRepository.addVoteOptions(options);
        return voteId;
    }

    public void updateVote(VoteParam voteParam) {
        Vote vote = Vote.createVote(voteParam);
        Long voteId = voteParam.getVoteId();
        vote.setVoteId(voteId);

        log.info("{}", voteId);

        voteRepository.updateVote(vote);
        voteRepository.deleteOptions(voteId);
        voteRepository.addVoteOptions(voteParam.getOptions());
    }

    public void saveAnswer(VoteAnswer answer) {
        voteRepository.saveAnswer(answer);
    }

    public boolean isExistAnswer(VoteAnswer answer) {
        return voteRepository.isExistAnswer(answer);
    }

    public void deleteVote(Long voteId) {
        voteRepository.deleteVote(voteId);
    }

    private boolean checkStatus(VoteParam voteParam) {
        Date startDate = voteParam.getStartDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        Date today;
        Date tomorrow = null;
        try {
            today = sdf.parse(sdf.format(new Date()));
            cal.setTime(today);
            cal.add(Calendar.DATE, 1);
            tomorrow = sdf.parse(sdf.format(cal.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate.before(tomorrow);
    }
}
