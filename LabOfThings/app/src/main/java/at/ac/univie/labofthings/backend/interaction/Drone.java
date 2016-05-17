package at.ac.univie.labofthings.backend.interaction;

/**
 * Created by Patrick on 17/05/2016.
 */
public class Drone extends InteractionObject {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Drone(Boolean onOffState, String name, String description) {
        super(onOffState, name, description);
    }
    public void moveRight() throws Exception {
        if(!super.getOnOffState())
            throw new Exception(super.onOffError);
        this.x = this.x+1;
    }
    public void moveLeft() throws Exception {
        if(!super.getOnOffState())
            throw new Exception(super.onOffError);
        this.x = this.x-1;
    }
    public void moveUp() throws Exception {
        if(!super.getOnOffState())
            throw new Exception(super.onOffError);
        this.y = this.y+1;
    }
    public void moveDown() throws Exception {
        if(!super.getOnOffState())
            throw new Exception(super.onOffError);
        this.y = this.y-1;
    }


}
