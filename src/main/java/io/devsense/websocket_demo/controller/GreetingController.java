package io.devsense.websocket_demo.controller;

import io.devsense.websocket_demo.model.Greeting;
import io.devsense.websocket_demo.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage helloMessage) throws Exception{
        Thread.sleep(1000);
        var greeting = new Greeting("Hello" + HtmlUtils.htmlEscape(helloMessage.getName()) + "!");
        return greeting;
    }
}
