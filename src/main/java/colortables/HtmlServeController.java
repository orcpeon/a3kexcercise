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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HtmlServeController {

    @Autowired
    private ColorRepository colorRepository;

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

/*    @GetMapping("/upd") //TODO make this a default page, make revColor not required
    private String updateRevealed(@RequestParam(name = "revColor") String revColor, Model model) {
        revealedVotes.add(revColor);
        Iterable<Colors> colors = getAllColors();
        model.addAttribute("colors", colors);
        model.addAttribute("revColor", revColor);
        return "a3k";
    }*/

}
