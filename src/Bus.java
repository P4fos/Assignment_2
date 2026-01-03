public class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        return getBasePrice() * 0.02 + (passengerCapacity * 100);
    }

    @Override
    public void performService() {
        System.out.println("Bus Service: Inspecting air brakes and seating for " + getModel());
    }

    @Override
    public int getServiceIntervalKm() {
        return 25000;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Bus, Capacity: " + passengerCapacity;
    }
}