package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EletroEletronicos;
import model.Radio;

public class RadioDAO {

	private Connection con;
	
	public RadioDAO(Connection con) {
		this.con = con;
	}
	
	public boolean inserir(Radio radio) throws SQLException{
		String sql = "INSERT INTO RADIO (RAD_CODIGO, RAD_MARCA, RAD_VOLUME) VALUES (SEQ_RAD.nextval, ?, ?)";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, radio.getMarca());
		statement.setInt(2, radio.getVolume());
		 
		return statement.executeUpdate() > 0;
	}
	
	public boolean aumentarVolumeRadio(Integer codigo) throws SQLException{
		String sql = "UPDATE RADIO SET VOLUME = VOLUME + 1 WHERE RAD_CODIGO = ?";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, codigo);
		 
		return statement.executeUpdate() > 0;
	}
	
	public boolean abaixarVolumeRadio(Integer codigo) throws SQLException{
		String sql = "UPDATE RADIO SET VOLUME = VOLUME - 1 WHERE RAD_CODIGO = ?";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, codigo);
		 
		return statement.executeUpdate() > 0;
	}
	
	public boolean excluir(Integer codigo) throws SQLException{
		String sql = "DELETE RADIO WHERE RAD_CODIGO = ?";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, codigo);
		 
		return statement.executeUpdate() > 0;
	}
	
	public List<EletroEletronicos> listaRadio() throws SQLException {
		List<EletroEletronicos> lRadios = new ArrayList<>();

		String sql = "select * from RADIO";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int codigo = rs.getInt("RAD_CODIGO");
					int volume = rs.getInt("RAD_VOLUME");
					String marca = rs.getString("RAD_MARCA");
					
					Radio radio = new Radio(codigo, volume, marca);
					
					lRadios.add(radio);
				}
			}
		}

		return lRadios;

	}
}
