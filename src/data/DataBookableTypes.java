package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.BookableTypes;
import util.AppDataException;

public class DataBookableTypes {
	public ArrayList<BookableTypes> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<BookableTypes> booktypes= new ArrayList<BookableTypes>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from bookable_types");
			if(rs!=null){
				while(rs.next()){
					BookableTypes bt =new BookableTypes();
							bt.setId(Integer.parseInt(rs.getString("id")));
							bt.setNombre(rs.getString("nombre"));
							bt.setCantReservasPendientes(Integer.parseInt(rs.getString("cantReservas")));
					
					
					booktypes.add(bt);
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
		
		return booktypes;
		
	}
	
	/*public People getByDni(People per) throws Exception{
		People p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, apellido, dni, usuario, contrasenia, estado  from people where dni=?");
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					p=new People();
					p.setPeople(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("usuario"),
							rs.getString("contrasenia"), rs.getBoolean("estado"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return p;
	}*/
	
	public void add(BookableTypes bt) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into bookable_types(nombre, cantReservasPendientes) values (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, bt.getNombre());
			stmt.setString(2, String.valueOf((bt.getCantReservasPendientes())));
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				bt.setId(keyResultSet.getInt(1));
			}
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
