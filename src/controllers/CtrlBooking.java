package controllers;

import java.util.ArrayList;

import data.DataBooking;
import entity.Booking;
import entity.People;

public class CtrlBooking {
	
	private DataBooking dataBook;
	private ArrayList<Booking> res;
	private CtrlABMPeople ctrlp = new CtrlABMPeople(); 
	
	public CtrlBooking() {
		dataBook = new DataBooking();
		res = new ArrayList<Booking>();
	}
	
	public void add(Booking b) throws Exception {
		dataBook.add(b);
	}
	
	public void deleteById(int id) throws Exception {
		dataBook.delete(id);
	}
	
	
	public void update(Booking b) throws Exception {
		dataBook.update(b);
	}
	
	public ArrayList<Booking> getList() throws Exception {
		return dataBook.getAll();
	}
	
	public ArrayList<Booking> getReservasByPerson(String dni) throws Exception {
		People p = new People();
		p = ctrlp.getByDni(dni);
		return dataBook.getReservasByPerson(p);
	}
	
	
}
