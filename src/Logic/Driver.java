package Logic;

import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Logic l= new Logic();
		l.createNodes(100);
		int bound= l.getNodeList().size();
		Random rand= new Random();
		for(int i=0;i<(bound/3);i++){
			int num1=(rand.nextInt(bound)+1);
			int num2=(rand.nextInt(bound)+1);
			l.union(num1, num2);			
		}
		Scanner sc= new Scanner(System.in);
		while(true){
		System.out.println("Enter the first node number");
		int num1= sc.nextInt();
		System.out.println("Enter the Second node number");
		int num2= sc.nextInt();
		System.out.println("Connected: " + l.isConnected(num1, num2));}
		

	}

}
