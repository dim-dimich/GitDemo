import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");

		String host = "localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", "root", "root");

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("select * from employeeinfo where name = 'Sam'");

		while (rs.next()) {
			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("name"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("location"));
			System.out.println(rs.getInt("age"));
			
			// Dev 2 code
			System.out.println(rs.getInt("GitDemo1"));
			System.out.println(rs.getInt("GitDemo2"));
			
			// Dev 1 code
			System.out.println(rs.getInt("GitX1"));
			System.out.println(rs.getInt("GitX2"));
		}

	}
	
	public void gitTest() {
		System.out.println("Dev2 - 1");
	}
	
	public void gitTestA( ) {
		System.out.println("Dev1 - 1");
	}

}
