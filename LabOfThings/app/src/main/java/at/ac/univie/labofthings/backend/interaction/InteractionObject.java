package at.ac.univie.labofthings.backend.interaction;

import java.util.Random;

/**
 * Created by Patrick on 13/05/2016.
 */
public class InteractionObject {

    public enum DamageState
    {
        Totally,
        Partial,
        None
    }

    private Boolean onOffState;
    private String name;
    private String description;

    protected final String onOffError = "Device not on!";

    public Boolean getOnOffState() {
        return onOffState;
    }

    public void setOnOffState(Boolean onOffState) {
        this.onOffState = onOffState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public InteractionObject(Boolean onOffState, String name, String description)
    {
        this.onOffState = onOffState;
        this.name = name;
        this.description = description;
    }
    public DamageState checkForPossibleDamage()
    {
        int state = new Random().nextInt(3);
        if(state == 0)
        {
            return DamageState.Totally;
        }
        else if(state == 1)
        {
            return DamageState.Partial;
        }
        else
        {
            return DamageState.None;
        }
    }
}
