package application;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class app {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("TESTE 1::: FindByID");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n TESTE 2::: FindByDepartment");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n TESTE 3::: FindAll");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n TESTE 4::: Seller Insert");
		Seller newSeller = new Seller(null, "Lebron James", "labron@mvp.com", new Date(30, 12, 1984), 9000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted new id: " + newSeller.getId());
		
		System.out.println("\n TESTE 5::: Seller Update");
		seller = sellerDao.findById(5);
		seller.setName("Cleo Buenos"); //Antes era Cleonice Buenos
		sellerDao.update(seller);
		System.out.println("Update completed !");
		
		System.out.println("\n TESTE 6::: Seller Delete");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
