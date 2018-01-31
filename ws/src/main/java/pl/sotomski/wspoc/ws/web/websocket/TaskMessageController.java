package pl.sotomski.wspoc.ws.web.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
        import org.springframework.messaging.handler.annotation.SendTo;
        import org.springframework.stereotype.Controller;
@Controller
public class TaskMessageController {
    @MessageMapping("/hello")
    @SendTo("/topic/tasks")
    public TaskMessage greeting(TaskMessage message) throws Exception {
        return message;
    }

}
