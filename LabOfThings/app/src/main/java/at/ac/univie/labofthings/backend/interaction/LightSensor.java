package at.ac.univie.labofthings.backend.interaction;

import at.ac.univie.labofthings.backend.interaction.InteractionObject;

/**
 * Created by Patrick on 13/05/2016.
 */
public class LightSensor extends InteractionObject {
    private Boolean lightIntensityAvailable = false;

    private int lightIntensity;

    public int getLightIntensity() throws Exception {
        if(!lightIntensityAvailable)
            throw new Exception("Light Intensity not available");

        return lightIntensity;
    }

    public void setLightIntensity(int lightIntensity) throws Exception {
        if(!lightIntensityAvailable)
            throw new Exception("Light Intensity not available");

        this.lightIntensity = lightIntensity;
    }

    public LightSensor(Boolean onOffState, String name, String description, Boolean lightIntensityAvailable) {
        super(onOffState, name, description);
        this.lightIntensityAvailable = lightIntensityAvailable;

    }


}
