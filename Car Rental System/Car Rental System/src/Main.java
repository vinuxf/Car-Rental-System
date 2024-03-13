import Entity.Brand;
import Entity.Vehicle;

import java.util.*;
public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Brand brand1 = new Brand();
        brand1.setBrandName("Mitsubishi");

        Brand brand2 = new Brand();
        brand2.setBrandName("Toyota");

        Brand brand3 = new Brand();
        brand3.setBrandName("Nissan");

        Brand brand4 = new Brand();
        brand4.setBrandName("Geely");


        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setPricePerDay(3000.00);
        vehicle1.setPricePerKm(120.00);
        vehicle1.setVehicleName("Lancer X");
        vehicle1.setIndex(1);
        vehicle1.setBrand(brand1);

        Vehicle vehicle11 = new Vehicle();
        vehicle11.setPricePerDay(4000.00);
        vehicle11.setPricePerKm(180.00);
        vehicle11.setVehicleName("Lancer viii");
        vehicle11.setIndex(2);
        vehicle11.setBrand(brand1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setPricePerDay(5000.00);
        vehicle2.setPricePerKm(100.00);
        vehicle2.setVehicleName("Aqua");
        vehicle2.setIndex(3);
        vehicle2.setBrand(brand2);

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setPricePerDay(15000.00);
        vehicle3.setPricePerKm(450.00);
        vehicle3.setVehicleName("GTR");
        vehicle3.setIndex(4);
        vehicle3.setBrand(brand3);

        Vehicle vehicle4 = new Vehicle();
        vehicle4.setPricePerDay(1500.00);
        vehicle4.setPricePerKm(150.00);
        vehicle4.setVehicleName("MX7");
        vehicle4.setIndex(5);
        vehicle4.setBrand(brand4);

        vehicles.add(vehicle1);
        vehicles.add(vehicle11);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);

        System.out.println("Select any vehicle ::: ");

        for(Vehicle vehicle : vehicles){
            System.out.println("To select ->  " + vehicle.getVehicleName() + ", Type -> " + vehicle.getIndex());
        }
        
        System.out.print("Type Here ::: ");
        String index = input.next();

        Vehicle selectedVehicle = null;
        //enhanced for loop
        for(Vehicle vehicle : vehicles){
            if(Integer.parseInt(index) == vehicle.getIndex()){
               selectedVehicle = vehicle;
               break;
            }
        }
        
        if(Objects.isNull(selectedVehicle)){
            System.out.println("Incorrect Input. Please try again!!!");
            main(args);
        }

        vehicleDetails(selectedVehicle, args);
    }

    private static void vehicleDetails(Vehicle selectedVehicle, String[] args){
        System.out.println("::: VEHICLE DETAILS :::");
        System.out.println("Vehicle Brand -> " + selectedVehicle.getBrand().getBrandName());
        System.out.println("Selected Vehicle -> " + selectedVehicle.getVehicleName());
        System.out.println("price per KM -> " + selectedVehicle.getPricePerKm());
        System.out.println("price per Day -> " + selectedVehicle.getPricePerDay());

        System.out.println("Want to proceed? Y/N");
        String charIn = input.next();

        if(charIn.equalsIgnoreCase("Y")){
            selectionResult(selectedVehicle);
        } else if (charIn.equalsIgnoreCase("n")){
            main(args);
        } else {
            System.out.println("Wrong input, Please try again!");
            vehicleDetails(selectedVehicle, args);
        }
    }
    private static void selectionResult(Vehicle selectedVehicle) {
        System.out.print("Enter milage : ");
        String milage = input.next();

        System.out.print("Enter days (If no days, enter 0) : ");
        String days = input.next();


        if(isStringInt(milage) && isStringInt(days)){
            System.out.println("::: Your selection details as follows :::");
            System.out.println("Selected Vehicle -> " + selectedVehicle.getVehicleName());
            System.out.println("Entered Milage -> " + milage);
            System.out.println("Entered Days -> " + days);
            System.out.println("Total cost -> " + selectedVehicle.calculateTotalPrice(Integer.parseInt(milage), Integer.parseInt(days)));
        } else {
            System.out.println("Invalid Input!");
            //recurring function call
            selectionResult(selectedVehicle);
        }
    }

    private static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
