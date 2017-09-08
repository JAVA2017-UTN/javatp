package controllers;

import java.util.ArrayList;

import data.DataBooking;
import entity.Booking;

public class CtrlBooking {
	
	private DataBooking dataBook;
	
	public CtrlBooking() {
		dataBook = new DataBooking();
	}
	
	public void add(Booking b) throws Exception {
		dataBook.add(b);
	}
	
	public void delete(Booking b) throws Exception {
		dataBook.delete(b);
	}
	
	public void update(Booking b) throws Exception {
		dataBook.update(b);
	}
	
	public ArrayList<Booking> getList() throws Exception {
		return dataBook.getAll();
	}

}
