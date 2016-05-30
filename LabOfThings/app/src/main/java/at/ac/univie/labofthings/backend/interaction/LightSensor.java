package at.ac.univie.labofthings.backend.interaction;

import at.ac.univie.labofthings.backend.interaction.InteractionObject;

/**
 * Created by Patrick on 13/05/2016.
 */

/**
 * Class for a light object
 */
public class LightSensor extends InteractionObject {
    private Boolean lightIntensityAvailable = false;
    private Boolean lightRGBColorCodeAvailable = false;

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

    public Boolean getLightRGBColorCodeAvailable() throws Exception {
        if(!lightRGBColorCodeAvailable)
            throw new Exception("Light RGB Code not available");

        return lightRGBColorCodeAvailable;
    }

    public void setLightRGBColorCodeAvailable(Boolean lightRGBColorCodeAvailable) throws Exception {
        if(!lightRGBColorCodeAvailable)
            throw new Exception("Light RGB Code not available");

        this.lightRGBColorCodeAvailable = lightRGBColorCodeAvailable;
    }

    public LightSensor(Boolean onOffState, String name, String description, Boolean lightIntensityAvailable,
                       Boolean lightRGBColorCodeAvailable) {
        super(onOffState, name, description);
        this.lightIntensityAvailable = lightIntensityAvailable;
        this.lightRGBColorCodeAvailable = lightRGBColorCodeAvailable;

    }
    @Override
    public TypOfCategory getCatgory()
    {
        return TypOfCategory.Light;
    }
}
