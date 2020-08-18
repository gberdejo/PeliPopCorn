package Mantenimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.CallableStatement;

import Class.Compra;
import Class.ListaFactura;
import Class.ListaTicket;
import Class.Proyecciones;
import Utils.MySQLConexion;

public class CompraM {
	private Connection con;
	private CallableStatement call;
	private ArrayList<ListaTicket> listaCompraTicket;
	private ArrayList<ListaFactura> listaFactura;
	private int rs;
	private ResultSet res;
	MySQLConexion mysql;
	
	public CompraM(){
		
		mysql = new MySQLConexion();
	}
	public ArrayList<ListaTicket> ListarTicket(){
		listaCompraTicket = new ArrayList<>();
		try {
			con = mysql.getConection();
			call = (CallableStatement) con.prepareCall("call ListarComprarTicket()");
			res = call.executeQuery();
			while(res.next()){
				ListaTicket lista = new ListaTicket(res.getInt(1),
													res.getString(2), 
													res.getInt(3), 
													res.getString(4), 
													res.getString(5),
													res.getString(6),
													res.getDouble(7), 
													res.getInt(8), 
													res.getDouble(9), 
													res.getString(10));
				listaCompraTicket.add(lista);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(con != null){
					con.close();
				}
				if(call != null){
					call.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaCompraTicket;
	}
	public ArrayList<ListaFactura> ListarFactura(){
		listaFactura = new ArrayList<>();
		try {
			con = mysql.getConection();
			call = (CallableStatement) con.prepareCall("call ListarGenerarFactura()");
			res = call.executeQuery();
			while(res.next()){
				ListaFactura lista = new ListaFactura(res.getInt(1), res.getString(2), 
						res.getString(3), res.getDouble(4), res.getInt(5), res.getDouble(6), res.getString(7));
				
				listaFactura.add(lista);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(con != null){
					con.close();
				}
				if(call != null){
					call.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaFactura;
	}
	public void ComprarTicket(Compra compra){
		try {
			con = mysql.getConection();
			call = (CallableStatement) con.prepareCall("call ComprarTicket(?,?,?)");
			call.setInt(1, compra.getIdCliente());
			call.setInt(2, compra.getIdProyeccion());
			call.setInt(3, compra.getCantidadTicket());
			rs = call.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "se ha Generado un  nuevo ticket");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(con != null){
					con.close();
				}
				if(call != null){
					call.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void GenerarTicketyBocado(Compra compra){
		try {
			con = mysql.getConection();
			call = (CallableStatement) con.prepareCall("call GenerarTicketyFactura(?,?,?,?,?)");
			call.setInt(1, compra.getIdCliente());
			call.setInt(2, compra.getIdProyeccion());
			call.setInt(3, compra.getCantidadTicket());
			call.setInt(4, compra.getIdBocado());
			call.setInt(5, compra.getCantidadBocado());
			rs = call.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Se he genera un ticket con su bocado correspondiente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(con != null){
					con.close();
				}
				if(call != null){
					call.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}