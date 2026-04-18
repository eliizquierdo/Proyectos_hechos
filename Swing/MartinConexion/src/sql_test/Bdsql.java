package sql_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Bdsql extends JFrame implements ActionListener{

		private Connection cn;
		private ResultSet rs;
		private JTextArea txa,txasql;
		private JButton bsql;
		
	public Bdsql() {
		try{
			
			this.cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto","root","admin123");
			JOptionPane.showMessageDialog(null, "Conectado con base datos");
			
		}catch( Exception e) {
			
			e.printStackTrace();
		}
		
		this.setLayout(null);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.txa = new JTextArea();
		this.txa.setBounds(20,50,350,80);
		this.add(this.txa);
	
		this.txasql = new JTextArea();
		this.txasql.setBounds(20,135,350,220);
		this.add(this.txasql);
	
		
		this.bsql = new JButton("Ejecutar");
		this.bsql.setBounds(50,20,100,30);
		this.bsql.addActionListener(this);
		this.add(this.bsql);
		}

	@Override
	public void actionPerformed(ActionEvent e) {

		String sql = this.txa.getText();
		
		try{
			Statement st= this.cn.createStatement();
			this.rs = st.executeQuery(sql);

			String retSql= this.resultadoSql();
			this.txasql.setText(retSql);
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
	}

	private String resultadoSql() {
		String datos = "";
		
		try{
			
		while( this.rs.next()) {
			
			datos += rs.getInt(1) + " " + rs.getString(2) + 
					" " + rs.getString(3) + "\n";

		}
		}catch( Exception e) {
			
			e.printStackTrace();
		}
		
		return datos;
	}

	public static void main(String[] args) {
		
		Bdsql bd = new Bdsql();
		bd.setVisible(true);
	}
	
	
	
}


