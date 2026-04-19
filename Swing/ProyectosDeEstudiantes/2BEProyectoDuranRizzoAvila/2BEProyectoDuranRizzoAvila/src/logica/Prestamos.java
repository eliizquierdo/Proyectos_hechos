package logica;
import grafica.*;
import java.util.ArrayList;

import javax.swing.JTextField;
public class Prestamos {
	private int CIso; // Es la clave;
	private String nombreSo;
	private int telefonoSo;
	private String direccionSo;
	private Fecha fEnt;
	private Fecha fDev;
	
	
	public Prestamos(int CiSo, String NombreSo, int TelefonoSo, String DireccionSo, Fecha FechaEnt, Fecha FechaDev) {
		CIso = CiSo;
		this.nombreSo = NombreSo;
		this.telefonoSo = TelefonoSo;
		this.direccionSo = DireccionSo;
		this.fEnt = FechaEnt;
		this.fDev = FechaDev;
	}	

	public int getCIso() {
		return CIso;
	}


	public void setCIso(int CiSo) {
		CIso = CiSo;
	}


	public String getNombreSo() {
		return nombreSo;
	}


	public void setNombreSo(String NombreSo) {
		this.nombreSo = NombreSo;
	}


	public int getTelefonoSo() {
		return telefonoSo;
	}


	public void setTelefonoSo(int TelefonoSo) {
		this.telefonoSo = TelefonoSo;
	}


	public String getDireccionSo() {
		return direccionSo;
	}


	public void setDireccionSo(String DireccionSo) {
		this.direccionSo = DireccionSo;
	}


	public Fecha getfEnt() {
		return fEnt;
	}


	public void setfEnt(Fecha FechaEnt) {
		this.fEnt = FechaEnt;
	}


	public Fecha getfDev() {
		return fDev;
	}


	public void setfDev(Fecha FechaDev) {
		this.fDev = FechaDev;
	}


	@Override
	public String toString() {
		return "Prestamos [CIso=" + CIso + ", nombreSo=" + nombreSo + ", telefonoSo=" + telefonoSo + ", direccionSo="
				+ direccionSo + ", fEnt=" + fEnt + ", fDev=" + fDev + "]";
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
