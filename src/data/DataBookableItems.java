package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.BookableItems;
import entity.People;
import util.AppDataException;

public class DataBookableItems {
	
	public ArrayList<String> getAllNames(int id_tipo) throws Exception{
			ResultSet rs=null;
			PreparedStatement stmt=null;
			ArrayList<String> names= new ArrayList<String>();
			try {
				stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"select *  from bookable_items where id_tipo_elemento=?");
				stmt.setInt(1, id_tipo);
				rs=stmt.executeQuery();
				if(rs!=null){
					while(rs.next()){
						names.add(rs.getString("nombre"));
					}
				}
			} catch (SQLException e) {
				
				throw e;
			} catch (AppDataException ade){
				throw ade;
			}
			
	
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return names;
			
		}

}
