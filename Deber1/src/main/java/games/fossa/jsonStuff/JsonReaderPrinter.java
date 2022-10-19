package games.fossa.jsonStuff;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import games.fossa.vehicles.Vehicle;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JsonReaderPrinter {
    public JsonReaderPrinter() {
    }

    public void printIntoFile(List<Vehicle>vehicleList) throws IOException {
        for(Vehicle v : vehicleList){

        }
        try(Writer writer = new FileWriter("Output.json")){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(vehicleList,writer);
        }
    }
    public void readFromFile() throws FileNotFoundException {
        String x = new String();
        File f = new File("Output.json");
        if(f.isFile()){
            System.out.println("File exists and can be read.");

            final Type VEHICLE_TYPE = new TypeToken<List<Vehicle>>(){}.getType();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonReader reader = new JsonReader(new FileReader("Output.json"));
            List<Vehicle> vehicleListX = gson.fromJson(reader, VEHICLE_TYPE);
            for (Vehicle v : vehicleListX){
                System.out.println(v.getName() + " speed: " + v.getMaxSpeed());
            }


        }else{
            System.out.println("File does not exist. Exiting program.");
        }

    }
}
