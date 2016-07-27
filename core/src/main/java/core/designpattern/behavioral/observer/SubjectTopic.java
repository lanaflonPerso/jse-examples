package core.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectTopic implements Subject {

    private final Object MUTEX = new Object();
    private List<Observer> observersTopic;
    private String message;
    private boolean changed;

    public SubjectTopic() {
        this.observersTopic = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer observer) {
        if (observer == null)
            throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observersTopic.contains(observer))
                observersTopic.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        synchronized (MUTEX) {
            observersTopic.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observersTopic);
            this.changed = false;
        }
        for (Observer observer : observersLocal) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("Message Posted to SubjectTopic:" + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}