package colortables;

import colortables.database.ColorRepository;
import colortables.database.Colors;
import colortables.database.Votes;
import colortables.database.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HtmlServeController {

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private VotesRepository votesRepository;

    private List<String> revealedVotes = new ArrayList<>();

    @GetMapping("/")
    public String serve(Model model) {
        Iterable<Colors> colors = getAllColors();
        model.addAttribute("colors", colors);

        model.addAttribute("revealed", revealedVotes);
        return "a3k";
    }

    private Iterable<Colors> getAllColors() {
        return colorRepository.findAll();
    }

    @GetMapping("/upd") //TODO make this a default page, make revColor not required
    private String updateRevealed(@RequestParam(name = "revColor") String revColor, Model model) {
        revealedVotes.add(revColor);
        Iterable<Colors> colors = getAllColors();
        model.addAttribute("colors", colors);
        model.addAttribute("revColor", revColor);
        return "a3k";
    }

    private int getVotes(String color) {
        int i = 0;
        List<Votes> suitableEntries = votesRepository.findByColorIgnoreCase(color);
        //suitableEntries.forEach(() -> );
        for (Votes v : suitableEntries) {
            i += v.getVotes();
        }
        return i;
    }

}
