package games.fossa;

import games.fossa.jsonStuff.JsonReaderPrinter;
import games.fossa.vehicles.AirVehicle;
import games.fossa.vehicles.GroundVehicle;
import games.fossa.vehicles.SeaVehicle;
import games.fossa.vehicles.Vehicle;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        GroundVehicle car = new GroundVehicle();
        car.setName("Volvo");
        car.setMaxSpeed(220);

        AirVehicle waterCesna = new AirVehicle();
        waterCesna.setMaxSpeed(260);
        waterCesna.setName("Cesna 110");

        SeaVehicle boat = new SeaVehicle();
        boat.setName("Wooden Boat");
        boat.setMaxSpeed(40);

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(car);
        vehicleList.add(waterCesna);
        vehicleList.add(boat);

        //El anticristo
        vehicleList.sort(Comparator.comparingInt(Vehicle::getMaxSpeed));
        //////
        Collections.reverse(vehicleList);

        System.out.println("Do you want to show list by max speed? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (answer.equals("y")) {
            for (Vehicle v : vehicleList) {
                System.out.println(v.getName() + " has a max speed of: " + v.getMaxSpeed());
            }
        }

        System.out.println("Do you want to print results to a file? (y/n)");
        answer = scanner.next();
        if (answer.equals("y")) {
            JsonReaderPrinter jrp = new JsonReaderPrinter();
            try {
                jrp.printIntoFile(vehicleList);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        System.out.println("Do you want to read the vehicles directly from the file? (y/n)");
        answer = scanner.next();
        if (answer.equals("y")) {
            JsonReaderPrinter jrp = new JsonReaderPrinter();
            jrp.readFromFile();

        }
    }
/*
    private static List<Vehicle> sortVehiclesBySpeed(List<Vehicle> vehicleList){
        List<Vehicle> x = new ArrayList<>();

        List<Integer> integerList = new ArrayList<>();
        for (Vehicle v : vehicleList){
            integerList.add(v.getMaxSpeed());
        }

        List<Integer> copyIntegerList = new ArrayList<>(integerList);

        for(Integer i : integerList){
            int maxIndex = integerList.indexOf(Collections.max(integerList));
            x.add(vehicleList.get(maxIndex));
            integerList.remove(i);
        }



        return x;
    }
*/
}