package at.ac.univie.labofthings.backend.interaction;

import java.util.Random;

/**
 * Created by Patrick on 17/05/2016.
 */
public class SpeechRecognition extends InteractionObject {
    private Boolean listenIsActive = false;

    public SpeechRecognition(Boolean onOffState, String name, String description) {
        super(onOffState, name, description);
    }
    public void listen()
    {
        this.listenIsActive = true;
    }
    public void stop()
    {
        this.listenIsActive = false;
    }
    public String getData() throws Exception {
        if(!this.listenIsActive)
            throw new Exception("No Active listing...");

        Random rd = new Random();
        int length = rd.nextInt(100);
        for(int i = 0; i < length; i++)
        {

        }

        return "";
    }
}
