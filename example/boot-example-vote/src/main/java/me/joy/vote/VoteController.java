package me.joy.vote;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joy.vote.domain.Vote;
import me.joy.vote.domain.VoteAnswer;
import me.joy.vote.domain.VoteOption;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;

    @GetMapping
    public String votes(Model model) {
        model.addAttribute("votes", voteService.getList());
        return "/vote/votes";
    }

    @GetMapping("/{voteId}")
    public String voteDetail(@PathVariable Long voteId, Model model) {
        Vote vote = voteService.getVote(voteId);

        //null 처리
        if(vote == null) {
        }

        List<VoteOption> options = voteService.getOptions(voteId);
        model.addAttribute("vote", vote);
        model.addAttribute("options", options);
        return "/vote/voteDetail";
    }

    @GetMapping("/form/{voteId}")
    public String voteForm(@PathVariable Long voteId, Model model) {
        model.addAttribute("vote", voteService.getVote(voteId));
        model.addAttribute("options", voteService.getOptions(voteId));
        return "vote/voteForm";
    }

    @PostMapping("/form")
    public String voteResult(VoteAnswer voteAnswer) {
        log.info("{}", voteAnswer.toString());
        voteService.saveAnswer(voteAnswer);
        return "redirect:/vote/success";
    }

    @GetMapping("success")
    public String success() {
        return "/vote/successVote";
    }

    @PostMapping("/check")
    @ResponseBody
    public boolean isExistAnswer(VoteAnswer voteAnswer) {
        return voteService.isExistAnswer(voteAnswer);
    }

    @GetMapping("/add")
    public String addForm() {
        return "/vote/addForm";
    }

    @PostMapping("/add")
    public String addVote(String param, RedirectAttributes redirectAttributes) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        VoteParam result = objectMapper.readValue(param, VoteParam.class);
        redirectAttributes.addAttribute("voteId", voteService.addVote(result));
        redirectAttributes.addAttribute("status", true);
        return "redirect:/vote/{voteId}";
    }

    @GetMapping("/edit/{voteId}")
    public String editForm(@PathVariable Long voteId, Model model) {
        Vote vote = voteService.getVote(voteId);
        List<VoteOption> options = voteService.getOptions(voteId);
        model.addAttribute("vote", vote);
        model.addAttribute("options", options);
        return "vote/editForm";
    }

    @PostMapping("/edit/{voteId}")
    public String editVote(@PathVariable Long voteId, String param, RedirectAttributes redirectAttributes) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        VoteParam result = objectMapper.readValue(param, VoteParam.class);
        voteService.updateVote(result);
        redirectAttributes.addAttribute("voteId", voteId);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/vote/{voteId}";
    }

    @GetMapping("/answer/{voteId}")
    public String checkAnswer(@PathVariable Long voteId, Model model) {
        model.addAttribute("answers", voteService.getAnswer(voteId));
        return "vote/checkAnswer";
    }

}
