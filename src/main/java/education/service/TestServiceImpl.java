package education.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Sergey Shilov
 */
@Service
public class TestServiceImpl implements TestService {

    private Integer index;
    private List<String> questions;
    private List<String> answers;

    public TestServiceImpl() {
        questions = new ArrayList<>();
        answers = new ArrayList<>();

        questions.add("Сто одёжек и все без застежек");
        questions.add("Сидит дед во сто шуб одет, кто его раздевает - слёзы проливает");
        questions.add("Ныряла, ныряла и хвост потеряла");
        answers.add("капуста");
        answers.add("лук");
        answers.add("игла");
        index = 0;
    }

    @Override
    public String getQuestion() {
        String result;
        if(index >= questions.size()) {
            result = "Загадки закончились.";
        }
        else {
            result = questions.get(index);
            index++;
        }
        return result;
    }

    @Override
    public String checkAnswer(String answer) {

        if(index >= answers.size()) {
            return "Мы не загадывали такой загадки";
        }
        return answers.get(index).equalsIgnoreCase(answer) ? "Правильный ответ!" : "Попробуйте ещё раз";
    }
}
