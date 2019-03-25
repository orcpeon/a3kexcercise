package colortables;

import colortables.database.ColorRepository;
import colortables.database.Colors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HtmlServeController {

    @Autowired
    private ColorRepository colorRepository;

    @GetMapping("/")
    public String serve(Model model) {
        Iterable<Colors> colors = getAllColors();
        model.addAttribute("colors", colors);
        return "a3k";
    }

    private Iterable<Colors> getAllColors() {
        return colorRepository.findAll();
    }

}
