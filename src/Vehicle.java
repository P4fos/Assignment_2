public abstract class Vehicle implements Servicable {
    private int id;
    private static int idGen = 1;
    private String model;
    private int year;
    private double basePrice;

    protected Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model != null && !model.trim().isEmpty()) {
            this.model = model;
        } else {
            throw new IllegalArgumentException("Error: Model cannot be empty.");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1885 && year < 2100) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Error: Invalid year.");
        }
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice > 0) {
            this.basePrice = basePrice;
        } else {
            throw new IllegalArgumentException("Error: Base price must be positive.");
        }
    }

    public int getAge(int currentYear) {
        return currentYear - this.year;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return "ID: " + id + ", Model: " + model + ", Year: " + year + ", Base Price: $" + basePrice;
    }
}