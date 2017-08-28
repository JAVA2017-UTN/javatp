package controllers;

import java.util.ArrayList;

import data.DataPeople;
import entity.People;

public class CtrlABMPeople {

	private DataPeople dataPer;
	
	private ArrayList<People> pers;
	
	
	public CtrlABMPeople(){
		dataPer = new DataPeople();
		pers= new ArrayList<People>();
	}
	
	public void add(People p) throws Exception{
		//this.pers.add(p);
		dataPer.add(p);
	}
	
	public void delete(People p)throws Exception{
		//this.pers.remove(this.getByDni(p));
		this.pers.remove(p);
	}
	
	public void update(People p)throws Exception{
		this.delete(p);
		this.add(p);
	}
	
	public People getByDni(People p) throws Exception{
		return this.dataPer.getByDni(p);
		//return this.getByDni(p.getDni());
	}
	
	public People getByDni(String dni)throws Exception{
		People p=new People();
		p.setDni(dni);
		return getByDni(p);
		/*for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getDni().equals(dni)) {
				return pers.get(i);
				
			}
		}
		return null; //ver error si falta
		*/
	}
	
	public People getByNombreApellido(People p){
		
		for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre())
				&& pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())) {
				return pers.get(i);		
			}
		}
		return null; //ver error si falta
		
	}
	
	public ArrayList<People> getAll()throws Exception{
		//return this.pers;
		return dataPer.getAll();
	}
}