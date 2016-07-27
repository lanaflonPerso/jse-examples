package core.designpattern.behavioral.state;

public class TVStartState implements State {

    /*
     * (non-Javadoc)
     * 
     * @see State#doAction()
     */

    @Override
    public void doAction() {
        System.out.println("TV is turned ON");
    }
}
