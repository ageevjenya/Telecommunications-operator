package com.netcracker.app.domain.chat;


import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRestController {

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    AnswerRepo answerRepo;

    @Autowired
    FunctionChatRepo functionChatRepo;

    @Autowired
    UserRepo userRepo;

    @GetMapping(value = "/chat/question/first", headers = {"Content-type=application/json"})
    public Question questionNumberOne() {
        Question question = questionRepo.findByFirstQuestionNative();
        return question;
    }

    @PostMapping(value = "/chat/question", headers = {"Content-type=application/json"})
    public Question question(@RequestBody Question question) {
        Question questionBD = questionRepo.findById(question.getId()).get();
        return questionBD;
    }

    @PostMapping(value = "/chat/answers", headers = {"Content-type=application/json"})
    public Iterable<Answer> answersOnQuestion(@RequestBody Question question) {
        Iterable<Answer> answers = answerRepo.findByQuestionNative(question);
        return answers;
    }

    @PostMapping(value = "/chat/function", headers = {"Content-type=application/json"})
    public FunctionChat answersOnQuestion(@RequestBody FunctionChat functionChat) {
        FunctionChat functionChatBD = functionChatRepo.findById(functionChat.getId()).get();
        return functionChatBD;
    }

    @GetMapping(value = "/chat/balance", headers = {"Content-type=application/json"})
    public Float balance() {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Float balance =  (float) 0;
        return balance;
    }
}
