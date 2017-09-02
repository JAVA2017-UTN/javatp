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
	}
	
	public void update(BookableTypes bt)throws Exception{
		this.delete(bt);
		this.add(bt);
	}
	
	/*public BookableTypes getByDni(BookableTypes bt) throws Exception{
		return this.databt.getByDni(bt);
		//return this.getByDni(p.getDni());
	}
	
	public People getByDni(String dni)throws Exception{
		People p=new People();
		p.setDni(dni);
		return getByDni(p);
	}*/
	
	/*public People getByNombreApellido(People p){
		
		for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre())
				&& pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())) {
				return pers.get(i);		
			}
		}
		return null; //ver error si falta
		
	}*/
	
	public ArrayList<BookableTypes> getAll()throws Exception{
		return databt.getAll();
	}
}
