package Car;

import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class CarDriver {
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);

		Cardao dao=new Cardao();
		Cardto dto=new Cardto();
		
		for(;;) {
			System.err.println("1.Insert 2.Update 3.Show the unique car 4.Show all car 5.Delete 6.Exit");
			int choice=sc.nextInt();
			switch (choice) { 
			case 1:
			{
				System.out.println("Enter Details of Car: ");
				System.out.println("Enter Id: ");
				int id=sc.nextInt();
				System.out.println("Enter Name: ");
			    String name=sc.next();
				System.out.println("Enter Color: ");
				String color=sc.next();
				
			     dto.setId(id);
			     dto.setName(name);
			     dto.setColor(color);
			     
			     dao.save(dto);
			}
				break;

			case 2:
			{
				System.out.println("Enter Id of car :");
				int id=sc.nextInt();
				
        	    System.out.println("Enter new car name :");
				String newcar=sc.next();
				 
				 dto.setId(id);
				 dto.setName(newcar);
				 
				 dao.update(dto);
			}
				break;
				
			case 3:
			{
				System.out.println("Enter Id of car :");
				int id=sc.nextInt();
				
				dto.setId(id);
				
				dao.showcarbyid(dto);
			}
			    break;
			case 4:
			{
				dao.showallcar();
			}
			     break;
			 case 5:
			 {
				 System.out.println("Enter Id of car :");
				 int id=sc.nextInt();
					
			     dto.setId(id);
			     
			     dao.delete(id);
			 }
				break;
			 case 6:
			 {
				 System.err.println(" Application is closed....");
			 }
			}
		}		
	}
}

