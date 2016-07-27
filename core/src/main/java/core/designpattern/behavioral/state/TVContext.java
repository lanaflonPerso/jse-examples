package core.designpattern.behavioral.state;

public class TVContext implements State {

    /*
     * (non-Javadoc)
     * 
     * @see State#doAction()
     */
    private State tvState;

    public State getState() {
        return this.tvState;
    }

    public void setState(State state) {
        this.tvState = state;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }

}
