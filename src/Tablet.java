class Tablet extends Device {
    private String operatingSystem;
    private boolean hasStylus;

    public Tablet(String type, double price, double weight, String operatingSystem, boolean hasStylus) {
        super(type, price, weight);
        this.operatingSystem = operatingSystem;
        this.hasStylus = hasStylus;
    }
}
