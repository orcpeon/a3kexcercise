package colortables.controllers;

import colortables.database.Votes;
import colortables.database.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VotesUpdaterController {

    @Autowired
    private VotesRepository votesRepository;

    @GetMapping("/upd")
    @ResponseBody
    private String updVotes(@RequestParam(name = "color") String color, Model model) {
        return getVotes(color);
    }

    private String getVotes(String color) {
        int i = 0;
        List<Votes> suitableEntries = votesRepository.findByColorIgnoreCase(color);
        for (Votes v : suitableEntries) {
            i += v.getVotes();
        }
        return Integer.toString(i);
    }
}
