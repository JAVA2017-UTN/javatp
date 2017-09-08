package controllers;

import java.util.ArrayList;

import data.DataBookableItems;
import entity.BookableItems;

public class CtrlBookableItems {
	
private DataBookableItems databi;
	
	public CtrlBookableItems(){
		databi = new DataBookableItems();
	}
	
	/*public void add(BookableItems bi) throws Exception{
		databi.add(bi);
	}
	
	public void delete(BookableItems bi)throws Exception{
		databi.delete(bi);
	}
	
	public void update(BookableItems bi)throws Exception{
		databi.update(bi);
	}*/
	
	public ArrayList<String> getAllNames(int id_tipoEle) throws Exception{
		
		return databi.getAllNames(id_tipoEle);
	}
	
	/*public ArrayList<BookableItems> getAll()throws Exception{
		return databi.getAll();
	}*/
	
}
