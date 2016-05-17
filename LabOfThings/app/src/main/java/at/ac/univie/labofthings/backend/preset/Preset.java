package at.ac.univie.labofthings.backend.preset;

import java.util.ArrayList;
import java.util.List;

import at.ac.univie.labofthings.backend.interaction.InteractionObject;

/**
 * Created by Patrick on 17/05/2016.
 */
public class Preset {
    public String Name;

    private List<InteractionObject> objects = new ArrayList<>();

    public void addObject(InteractionObject object)
    {
        objects.add(object);
    }
    public void removeObject(InteractionObject object)
    {
        objects.remove(object);
    }
    public List<InteractionObject> getObjects()
    {
        return objects;
    }
}
