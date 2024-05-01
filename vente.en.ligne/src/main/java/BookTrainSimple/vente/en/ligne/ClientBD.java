package BookTrainSimple.vente.en.ligne;

import java.util.ArrayList;
import java.util.List;



import java.sql.*;

public class ClientBD {
	Connection con =null;

	public ClientBD ()
	{
		String url ="jdbc:mysql://localhost:3306/clients";
		String username="root";
		String password="hamdi424+424";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Client> getClients()
	{
		List<Client> clients =new ArrayList<Client>();
		String sql = "select * from cli";
		try {
			Statement st =con.createStatement();
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {
				Client c =new Client();
				c.setId(rs.getInt(1));
				c.setFirstname(rs.getString(2));
				c.setLastname(rs.getString(3));
				c.setPhone(rs.getString(4));
				c.setAddress(rs.getString(5));
				
				
				clients.add(c);
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return clients;
	}
	

	public Client getClients(int id) {
		
		String sql = "select* from cli where id="+id;
		Client c =new Client();
		try {
			Statement st =con.createStatement();
			ResultSet rs =st.executeQuery(sql);
			if(rs.next()) {
				
				c.setId(rs.getInt(1));
				c.setFirstname(rs.getString(2));
				c.setLastname(rs.getString(3));
				c.setPhone(rs.getString(4));
				c.setAddress(rs.getString(5));
			}	
			
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		return c;
		
	}
    
	public void create(Client c1) {
		String sql ="insert into cli values(?,?,?,?,?)";
		try {
			PreparedStatement st =con.prepareStatement(sql);
			
            st.setInt(1, c1.getId());
            st.setString(2, c1.getFirstname());
            st.setString(3, c1.getLastname());
            st.setString(4, c1.getPhone());
            st.setString(5, c1.getAddress());
            
            
			
			st.executeUpdate();
			}
	
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public void update(Client c1) {
		String sql ="update cli set firstname=?,lastname=?,phone=? ,address=? where id=?";
		try {
			PreparedStatement st =con.prepareStatement(sql);
			
            
            st.setString(1, c1.getFirstname());
            st.setString(2, c1.getLastname());
            st.setString(3, c1.getPhone());
            st.setString(4, c1.getAddress());
            st.setInt(5, c1.getId());
			st.executeUpdate();
			}
	
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public void delete(int id) {
		String sql ="delete from cli where id=?";
		try {
			PreparedStatement st =con.prepareStatement(sql);
			
            st.setInt(1, id);
			st.executeUpdate();
			}
	
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
