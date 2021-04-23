import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Mainline {

	public static void main(String[] args) throws SQLException {

		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prsdb", "root", "Train@MAX");
			PreparedStatement stmt = conn.prepareStatement("SELECT * from user;");
			//stmt.setInt(1, 1);
			ResultSet rs = stmt.executeQuery();
			var users = new ArrayList<User>();
			while(rs.next()) {
				var user = new User();
				user.id = rs.getInt("id");
				user.username = rs.getString("username");
				user.password = rs.getString("password");
				user.firstname = rs.getString("password");
				user.lastname = rs.getString("password");
				user.phoneNumber = rs.getString("password");
				user.email = rs.getString("password");
				user.isReviewer = rs.getBoolean("isReviewer");
				user.isAdmin = rs.getBoolean("isAdmin");
				users.add(user);
			}
			for(var user : users)
				System.out.println(String.format("%s", user.username));
		
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
