package com.nuwana.backend.controller;

import com.nuwana.backend.dto.FeedbackRequest;
import com.nuwana.backend.dto.FeedbackResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class FeedbackController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
        FeedbackRequest request=new FeedbackRequest(model, prompt);
        FeedbackResponse chatGptResponse = template.postForObject(apiURL, request, FeedbackResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}
