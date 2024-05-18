Fpackage com.java.transport.model;

import java.util.Objects;

public class Vehicles {
	private int vehicleId;
	private String model;
	private double capacity;
	private String type;
	private String status;
	private String fuel_type;
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Vehicles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicles(int vehicleId, String model, double capacity, String type, String status, String fuel_type) {
		super();
		this.vehicleId = vehicleId;
		this.model = model;
		this.capacity = capacity;
		this.type = type;
		this.status = status;
		this.fuel_type = fuel_type;
	}
	@Override
	public String toString() {
		return "Vehicles [vehicleId=" + vehicleId + ", model=" + model + ", capacity=" + capacity + ", type=" + type
				+ ", status=" + status + ", fuel_type=" + fuel_type + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(vehicleId,model,capacity,type,status,fuel_type);
	}
	
	@Override
	public boolean equals(Object obj) {
		Vehicles vehicle = (Vehicles)obj;
		
		if(vehicle.getVehicleId()==vehicleId && vehicle.getModel()==model && vehicle.getCapacity()==capacity &&
				vehicle.getType()==type && vehicle.getStatus()==status && vehicle.getFuel_type()==fuel_type) {
			return true;
		}
		return false;
			
	}
	
}
