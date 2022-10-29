package org.codingtutorials;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.ArrayList;
import java.util.List;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;

public class Queue {
    private SqsClient sqsClient;
    private CreateQueueRequest createQueueRequest;
    public Queue () {
        this.sqsClient = SqsClient.builder()
                .region(Region.EU_CENTRAL_1)
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();

        this.createQueueRequest = CreateQueueRequest.builder()
                .queueName("user-register")
                .build();
    }

    public void sendUserToQueue(User user) {
        sqsClient.createQueue(createQueueRequest);

        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl("https://sqs.eu-north-1.amazonaws.com/810028704317/user-register")
                .messageBody(user.getName())
                .delaySeconds(1)
                .build());
    }

    public List<String> getUsersFromQueue () {
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl("https://sqs.eu-north-1.amazonaws.com/810028704317/user-register")
                .maxNumberOfMessages(10)
                .build();

        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();

        var userList = new ArrayList<String>();

        for (var i = 0; i < messages.size(); i++) {
            userList.add(messages.get(i).body());
        }

        return userList;
    }
}
