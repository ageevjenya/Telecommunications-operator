package com.netcracker.app.domain.messages;

import com.netcracker.app.domain.requests.Request;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesRestController {

    @Autowired
    MessagesRepo messagesRepo;

    @Autowired
    UserRepo userRepo;

    @PostMapping(value = "/requests/messages", headers = {"Content-type=application/json"})
    public Iterable<Message> messagesOnRequest(@RequestBody Request request) {
        Iterable<Message> messages = messagesRepo.findByRequest(request);

        return messages ;
    }

    @PostMapping(value = "/requests/messages/quantity", headers = {"Content-type=application/json"})
    public Iterable<Message> quantityMessagesOnRequest(@RequestBody Request request) {
        Iterable<Message> messages = messagesRepo.findByRequest(request);
        return messages ;
    }

//    @MessageMapping("/message")
//    @SendTo("/chat/messages")
    @PostMapping(value = "/requests/messages/send", headers = {"Content-type=application/json"})
    public Iterable<Message> saveNewMessage(@RequestBody MessageTextAndRequestId messageTextAndRequestId) {
        Message message = new Message(messageTextAndRequestId.getText());
        Request request = new Request(messageTextAndRequestId.getId());
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        message.setRequest(request);
        message.setUser(user);
        messagesRepo.save(message);
        Iterable<Message> messages = messagesRepo.findByRequest(request);
        return messages;
    }
}
