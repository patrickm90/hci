package at.ac.univie.labofthings.backend.interaction;

/**
 * Created by Patrick on 13/05/2016.
 */
public class InteractionObject {
    private Boolean onOffState;
    private String name;
    private String description;

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
}
