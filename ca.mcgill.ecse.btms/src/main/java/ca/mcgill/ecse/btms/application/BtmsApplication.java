package ca.mcgill.ecse.btms.application;

import java.util.Calendar;

import ca.mcgill.ecse.btms.model.*;

public class BtmsApplication {
	
	private static BTMS btms;

	private static int counter = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Step 1
		// TODO
		BTMS btms = new BTMS();
		printBtmsStatistics(btms);
		
		// Step 2
		// TODO
		BusVehicle vehicle = new BusVehicle("first-license-plate", false, btms);
		Route route = new Route(1, btms);
		Driver driver = new Driver("first-driver", false, btms);
		btms.addVehicle(vehicle);
		btms.addRoute(route);
		btms.addDriver(driver);
		printBtmsStatistics(btms);
		BusVehicle bus1 = btms.getVehicle(0);
		Route route1 = btms.getRoute(0);
		Driver driver1 = btms.getDriver(0);
		// Step 3
		// TODO
		printBtmsStatistics(btms);
		// Step 4
		// TODO
		BusVehicle bus2 = new BusVehicle("second-license-plate", true, btms);
		Route route2 = new Route(2, btms);
		Driver driver2 = new Driver("second-driver", true, btms);
		printBtmsStatistics(btms);
		
		// Step 5
		// TODO
		Calendar calender = Calendar.getInstance();
		java.util.Date currentDate = calender.getTime();
		java.util.Date date = new java.util.Date(currentDate.getTime());
		RouteAssignment agmnt1 = new RouteAssignment(date, bus1, route1, btms);
		RouteAssignment agmnt2 = new RouteAssignment(currentDate, bus2, route2, btms);
		
		printBtmsStatistics(btms);
		
		// Step 6
		// TODO
		printBtmsStatistics(btms);
		
		// Step 7
		// TODO
		printBtmsStatistics(btms);
		
		// Step 8
		// TODO
		printBtmsStatistics(btms);
		
		// Step 9
		// TODO
		printBtmsStatistics(btms);
		
		// Step 10
		// TODO
		printBtmsStatistics(btms);
	}
	
	public static int increaseCounter() {
		return counter++;
	}
	
	private static void printBtmsStatistics(BTMS btms) {
		System.out.println("===== BTMS: Step " + increaseCounter() +" =====");
		System.out.println("Date: " + btms.getCurrentDate());
		System.out.println("Number of buses: " + btms.getVehicles().size());
		System.out.println("Number of routes: " + btms.getRoutes().size());
		System.out.println("Number of drivers: " + btms.getDrivers().size());
		System.out.println("Number of assignments: " + btms.getAssignments().size());
		System.out.println("Number of schedules: " + btms.getSchedule().size());
		for (BusVehicle bus : btms.getVehicles()) {
			System.out.println("Bus: " + bus.getLicencePlate() + " (in repair: " + bus.getInRepairShop() + ") / #Assignments: " + bus.getRouteAssignments().size());
		}
		for (Route route : btms.getRoutes()) {
			System.out.println("Route: " + route.getNumber() + " / #Assignments: " + route.getRouteAssignments().size());
		}
		for (Driver driver : btms.getDrivers()) {
			System.out.println("Driver: " + driver.getName() + " (sick: " + driver.getOnSickLeave() + ") / #Schedules: " + driver.getDriverSchedules().size());
		}
		for (RouteAssignment assignment : btms.getAssignments()) {
			System.out.println("Assignment: " + assignment.getBus().getLicencePlate() + ", " + assignment.getRoute().getNumber() + ", Date: " + assignment.getDate() +
					" / #Schedules: " + assignment.getDriverSchedules().size());
		}
		for (DriverSchedule schedule : btms.getSchedule()) {
			System.out.println("Schedule: " + schedule.getDriver().getName() + ", " + schedule.getAssignment().getBus().getLicencePlate() + 
					", " + schedule.getAssignment().getRoute().getNumber() + ", Date: " + schedule.getAssignment().getDate() + " " + schedule.getShift().toString());
		}
		System.out.println("========================");
	}

	public static BTMS getBtms() {
		if (btms == null) {
			btms = new BTMS();
		}
 		return btms;
	}
	
}
