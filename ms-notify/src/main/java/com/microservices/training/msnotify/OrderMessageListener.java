package com.microservices.training.msnotify;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "sms-message-q",durable = "true",autoDelete = "false"),
            exchange = @Exchange(name = "message-exchange",durable = "true",autoDelete = "false",type = ExchangeTypes.DIRECT),
            key = "sms-send"
    ))
    public void handleSMS(SendMessage message){
        System.out.println("Received SMS : " + message);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "sms-tr-message-q",durable = "true",autoDelete = "false"),
            exchange = @Exchange(name = "message-topic-exchange",durable = "true",autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "send.sms.#"
    ))
    public void handleTopicSMS(SendMessage message){
        System.out.println("Received Topic SMS : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "email-tr-message-q",durable = "true",autoDelete = "false"),
            exchange = @Exchange(name = "message-topic-exchange",durable = "true",autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "send.email.#"
    ))
    public void handleTopicEmail(SendMessage message){
        System.out.println("Received Topic EMAIL : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "all-tr-message-q",durable = "true",autoDelete = "false"),
            exchange = @Exchange(name = "message-topic-exchange",durable = "true",autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "send.#"
    ))
    public void handleAll(SendMessage message){
        System.out.println("Received All EMAIL : " + message);
    }

}
