package titleAggregator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DataController {

    private final ArticleService articleService;

    public DataController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String getHeadlines(Model model) {
        List<Headline> headlines = articleService.fetchHeadlines();
        model.addAttribute("headlines", headlines);
        return "index";
    }
}
