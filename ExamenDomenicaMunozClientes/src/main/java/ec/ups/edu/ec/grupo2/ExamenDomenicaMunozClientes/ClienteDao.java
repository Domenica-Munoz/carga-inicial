package ec.ups.edu.ec.grupo2.ExamenDomenicaMunozClientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao {
	
	private Connection con;
	
	public boolean insert(Cliente entity) throws SQLException {
		
		String sql="INSERT INTO Cliente(nombre,apellido,cedula,fecha_nacimiento)"+"(?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, entity.getNombre());
		ps.setString(2, entity.getApellido());
		ps.setString(3, entity.getCedula());
		ps.setString(4, entity.getFecha_nacimiento());
		
		ps.executeUpdate();
		ps.close();
		
		return true;
		
	}
	
	public boolean update(Cliente entity) throws SQLException {
		String sql="UPDATE Cliente SET nombre=?, cedula=? WHERE cedula=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, entity.getNombre());
		ps.setString(2, entity.getApellido());
		ps.setString(3, entity.getCedula());
		ps.setString(4, entity.getFecha_nacimiento());
		
		ps.executeUpdate();
		ps.close();
		
		return true;
	}

	public boolean delete(Cliente entity) throws SQLException {
		String sql="DELETE FROM cliente WHERE cedula=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, entity.getCedula());
		
		ps.executeUpdate();
		ps.close();
		return true;
	}
}
