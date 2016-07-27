package core.designpattern.behavioral.observer;

public interface Subject {

    public void register(Observer obj);

    public void unregister(Observer obj);

    // PUSH implementation
    public void notifyObservers();

    // PULL Implementation
    public Object getUpdate(Observer obj);

}
