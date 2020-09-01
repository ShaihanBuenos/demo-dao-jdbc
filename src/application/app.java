package application;

import java.sql.Date;

import model.entities.Department;
import model.entities.Seller;

public class app {

	public static void main(String[] args) {

		Department obj = new Department(1, "Books");
		Seller seller = new Seller(14, "Shaihan", "shaihan@hotmail.com", new Date(20, 6, 2000), 1200.0 , obj);
		System.out.println(seller);
	}
}
