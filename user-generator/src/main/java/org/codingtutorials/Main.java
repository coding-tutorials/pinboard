package org.codingtutorials;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var generator = new Generator();
        var userList = generator.generate();

        var queue = new Queue();

        for (var i = 0; i < userList.size(); i++) {
            queue.sendUserToQueue(userList.get(i));
            System.out.println("Hello world!" + " " + userList.get(i).getName());
        }

        Thread.sleep(5000);

        var registeredUsers = queue.getUsersFromQueue();

        for (var i = 0; i < registeredUsers.size(); i++) {
            System.out.println("Received user" + " " + registeredUsers.get(i));
        }
    }
}