package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Model implements Serializable {
    private final Map<Integer, User> users = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger();
    private static Model instance;

    private Model() {
        add(new User("Ivan", "Ivanov", 100000));
        add(new User("Petr", "Petrov", 125000));
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public void add(User user) {
        users.put(counter.incrementAndGet(), user);
    }

    public User getUser(int id) {
        return users.get(id);
    }
}
