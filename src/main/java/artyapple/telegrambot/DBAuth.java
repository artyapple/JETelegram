package artyapple.telegrambot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class DBAuth {

	public DBAuth() {

	}

	public void estabConn() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://0.0.0.0:5432/telegramauth", "%login%", "%pw%");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM auth;");
			while (rs.next()) {
				int id = rs.getInt("id");;
				Date date = rs.getDate("last_entry");
				long chat_id = rs.getLong("char_id");
				boolean status = rs.getBoolean("active");
				System.out.println("ID = " + id);
				System.out.println("last entry = " + date);
				System.out.println("CHAT ID = " + chat_id);
				System.out.println("IS ACTIVE = " + status);
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}
}