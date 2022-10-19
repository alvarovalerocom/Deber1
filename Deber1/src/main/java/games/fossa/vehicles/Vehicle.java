package games.fossa.vehicles;

public class Vehicle {
    private String name;
    private int maxSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
/*
    @Override
    public int compareTo(Vehicle v){
        return this.getMaxSpeed()- v.getMaxSpeed();
    }*/
}
