package at.ac.univie.labofthings.backend.interaction;

/**
 * Created by Patrick on 17/05/2016.
 */

/**
 * Class for a camera object
 */
public class Camera extends InteractionObject {
    public Camera(Boolean onOffState, String name, String description) {
        super(onOffState, name, description);
    }

    /**
     * Takes a photo
     * @return a base 64 string
     * @throws Exception
     */
    public String takePhotoAsBase64() throws Exception {
        if(!super.getOnOffState())
            throw new Exception(super.onOffError);

        return "base64base64base64";

    }
    @Override
    public TypOfCategory getCatgory()
    {
        return TypOfCategory.Display;
    }
}
