import java.util.Scanner;


public class MyMain {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc1=new Scanner(System.in);
		  ProductMinMax p1=new ProductMinMax();

		
			System.out.println("SELECT MODE OF OPERATION");
			System.out.println("1: MAXIMUM PRODUCT PRICE");
			System.out.println("2: MINMUM PRODUCT PRICE");
			
			int choice=sc1.nextInt();
			
			switch(choice)
			{
				case 1: 
				 		p1.maxproduct();
					
				 		break;
				
				case 2:
						p1.minproduct();
						
						break;
				
			}

	}

}
