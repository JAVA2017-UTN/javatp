package controllers;

import java.util.ArrayList;

import data.DataBookableTypes;
import entity.BookableTypes;

public class CtrlBookingTypes {
	
private DataBookableTypes databt;
	
	private ArrayList<BookableTypes> booktypes;
	
	
	public CtrlBookingTypes(){
		databt = new DataBookableTypes();
		booktypes = new ArrayList<BookableTypes>();
	}
	
	public void add(BookableTypes bt) throws Exception{
		databt.add(bt);
	}
	
	public void delete(BookableTypes bt)throws Exception{
		this.booktypes.remove(bt);
		databt.delete(bt);
	}
	
	public void update(BookableTypes bt)throws Exception{
		this.delete(bt);
		this.add(bt);
	}
	
	public BookableTypes getByNombre(BookableTypes bt) throws Exception{
		
		return this.databt.getByNombre(bt);
	}
	
	
	public BookableTypes getByNombre(String nombre) throws Exception{

		BookableTypes bt = new BookableTypes();
		bt.setNombre(nombre);
		
		return getByNombre(bt);

	}
	
	/*public BookableTypes getByNombre(BookableTypes bt){
		
		for (int i=0; i < this.booktypes.size(); i++){
			if(booktypes.get(i).getNombre().equalsIgnoreCase(bt.getNombre())) {
				return booktypes.get(i);		
			}
		}
		return null;
		
	}*/
	
	
	public ArrayList<BookableTypes> getAll()throws Exception{
		return databt.getAll();
	}
}
