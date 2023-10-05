import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numDevices = 0; // Initialize to an invalid value

        while (numDevices < 1 || numDevices > 20) {
            System.out.print("Enter the number of devices (1-20): ");
            numDevices = scanner.nextInt();
        }
        List<Device> devicesList = new ArrayList<>();

        for (int i = 0; i < numDevices; i++) {
            String[] deviceTypes = {"Smartphone", "Laptop", "Tablet"};
            String randomDeviceType = deviceTypes[ThreadLocalRandom.current().nextInt(deviceTypes.length)];
            double randomPrice = ThreadLocalRandom.current().nextDouble(100, 2000);
            double randomWeight = ThreadLocalRandom.current().nextDouble(200, 4000);

            if (randomDeviceType.equals("Smartphone")) {
                double randomScreenSize = ThreadLocalRandom.current().nextDouble(4.0, 7.0);
                int randomCameraResolution = ThreadLocalRandom.current().nextInt(8, 64);
                devicesList.add(new Smartphone(randomDeviceType, randomPrice, randomWeight, randomScreenSize, randomCameraResolution));
            } else if (randomDeviceType.equals("Laptop")) {
                String[] processors = {"Intel Core i5", "Intel Core i7", "AMD Ryzen 7"};
                String randomProcessor = processors[ThreadLocalRandom.current().nextInt(processors.length)];
                int randomRam = ThreadLocalRandom.current().nextInt(4, 32);
                devicesList.add(new Laptop(randomDeviceType, randomPrice, randomWeight, randomProcessor, randomRam));
            } else if (randomDeviceType.equals("Tablet")) {
                String[] operatingSystems = {"Android", "iOS", "Windows"};
                String randomOS = operatingSystems[ThreadLocalRandom.current().nextInt(operatingSystems.length)];
                boolean randomHasStylus = ThreadLocalRandom.current().nextBoolean();
                devicesList.add(new Tablet(randomDeviceType, randomPrice, randomWeight, randomOS, randomHasStylus));
            }
        }

        Set<String> distinctDeviceTypes = new HashSet<>();
        double totalDevicePrice = 0;
        double totalDeviceWeight = 0;

        for (Device device : devicesList) {
            distinctDeviceTypes.add(device.getType());
            totalDevicePrice += device.getPrice();
            totalDeviceWeight += device.getWeight();
        }

        System.out.println("Number of distinct device types created: " + distinctDeviceTypes.size());
        System.out.println("Total price of all devices: SOM" + totalDevicePrice);
        System.out.println("Total weight of all devices: " + totalDeviceWeight + "gr");

        scanner.close();
    }
}
