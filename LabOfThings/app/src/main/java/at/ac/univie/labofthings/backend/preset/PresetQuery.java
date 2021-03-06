package at.ac.univie.labofthings.backend.preset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.ac.univie.labofthings.backend.interaction.Camera;
import at.ac.univie.labofthings.backend.interaction.Drone;
import at.ac.univie.labofthings.backend.interaction.InteractionObject;
import at.ac.univie.labofthings.backend.interaction.LightSensor;
import at.ac.univie.labofthings.backend.interaction.SpeechRecognition;

/**
 * Created by Patrick on 17/05/2016.
 */

/**
 * Provides method to query different presets
 */
public class PresetQuery {

    /**
     * Gets an interaction object
     * @param number number of the sensor actor
     * @return an interaction object
     */
    public static InteractionObject generateRandomInterActionObject(int number)
    {
        int rd = new Random().nextInt(4);

        if(rd == 0)
        {
            return new Camera(new Random().nextBoolean(), "Camera " + number, "A Camera");
        }
        else if(rd == 1)
        {
            return new Drone(new Random().nextBoolean(), "Drone " + number, "A Drone");
        }
        else if(rd == 2)
        {
            return new LightSensor(new Random().nextBoolean(), "Light Sensor " + number, "A light sensor", new Random().nextBoolean(),
                    new Random().nextBoolean());
        }
        else if(rd == 3)
        {
            return new SpeechRecognition(new Random().nextBoolean(), "Speech " + number, "A speech recognition");
        }
        return null;
    }

    /**
     * Gets a list of presets
     * @return a list of presets
     */
    public static List<Preset> getPresetList()
    {
        List<Preset> presets = new ArrayList<>();
        int presetCount = new Random().nextInt(50) + 5;

        for(int i = 0; i < presetCount; i++)
        {
            Preset preset = new Preset();
            preset.Name = "Preset " + i;
            int objectsCount = new Random().nextInt(50) + 5;
            for(int j = 0; j < objectsCount; j++)
            {
                preset.addObject(generateRandomInterActionObject(j));
            }
            presets.add(preset);
        }
        return presets;
    }

}
