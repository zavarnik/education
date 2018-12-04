package education.controller;

import education.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Sergey Shilov
 */
@Controller
public class TestController {

    private TestService service;

    @Autowired
    @Qualifier(value = "testService")
    public void setService(TestService service) { this.service = service; }

    @RequestMapping(value = "getQuestion")
    public String getQuestion(Model model) {
        model.addAttribute("question", service.getQuestion());
        return "quiz";
    }

    @RequestMapping(value = "checkAnswer")
    public String checkAnswer(@RequestParam("guess") String guess, Model model) {
        model.addAttribute("answer", service.checkAnswer(guess));
        return "quiz";
    }
}
