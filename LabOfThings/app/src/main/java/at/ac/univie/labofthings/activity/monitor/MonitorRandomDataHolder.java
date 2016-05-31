package at.ac.univie.labofthings.activity.monitor;

import java.util.List;

import at.ac.univie.labofthings.backend.interaction.InteractionObject;

public class MonitorRandomDataHolder {
    private static List<InteractionObject> allSensors;
    private static InteractionObject.TypOfCategory category;

    //getter and setter
    public static InteractionObject.TypOfCategory getCategory() {
        return category;
    }

    public static void setCategory(InteractionObject.TypOfCategory category) {
        MonitorRandomDataHolder.category = category;
    }

    public static void setAllSensors(List<InteractionObject> allSensors) {
        MonitorRandomDataHolder.allSensors = allSensors;
    }

    public static List<InteractionObject> getAllSensors() {
        return allSensors;
    }

}
