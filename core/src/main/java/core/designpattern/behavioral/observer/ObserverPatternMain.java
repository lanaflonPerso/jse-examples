package core.designpattern.behavioral.observer;

public class ObserverPatternMain {

    public static void main(String...args) {
        // create subject
        SubjectTopic subjectTopic = new SubjectTopic();

        // create observers
        Observer obj1 = new SubscribeObserver("Obj1");
        Observer obj2 = new SubscribeObserver("Obj2");
        Observer obj3 = new SubscribeObserver("Obj3");

        // register observers to the subject
        subjectTopic.register(obj1);
        subjectTopic.register(obj2);
        subjectTopic.register(obj3);

        // attach observer to subject
        obj1.setSubject(subjectTopic);
        obj2.setSubject(subjectTopic);
        obj3.setSubject(subjectTopic);

        // check if any update is available
        obj1.update();

        // now send message to subject
        subjectTopic.postMessage("New Message");
    }

}