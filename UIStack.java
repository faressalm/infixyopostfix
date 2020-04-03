package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;

public class UIStack {
	private static int x;
	static Stack obj=new Stack();
   public static void print_options() {
	   System.out.println("Choose your option number:\n1: Push \n2: Pop \n3: Peek \n4: Get size \n5: Check if empty \n6: Close the program");
   }
   public static void options(int num) {
	   Scanner n=new Scanner(System.in);
	   
	   String y;
	   if(num<1||num>6) {
		   System.out.println("Wrong option please insert one of the following");
		   return;
	   }
	   if(num==1) {
		   System.out.println("Enter the value You want to insert:");
		   y=n.nextLine();
		   obj.push(y);
		   
	   }
	   else if(num==2) {
		  try { System.out.println("you have just remove \""+obj.pop()+"\" from your stack");
		  }
		   catch(Exception e)
			{
				
				System.out.println("Your stack is Empty");
			}
	   }
	   else if(num==3) {
		   
		   try {
			   System.out.println("the peek of your stack = "+obj.peek());
			}
			catch(Exception e)
			{
				
				System.out.println("Your stack is Empty");
			}
	   }
	   else if(num==4) {
		   System.out.println("the size of your stack = "+obj.size());
	   }
	   else if(num==5) {
		   if(obj.isEmpty()) {System.out.println("your stack is Empty");}
		   else {
		   System.out.println("your stack is not Empty");
		   
	   }
		   
		   }
	   else  {
		   System.out.print("\t\tEND");
		   x=1;
	   }
	   
   }
   
	public static void main(String[] args) {
	 	 x=0;
	 	 int num;
	 	 
		Scanner next=new Scanner(System.in);
		while(x!=1) {
			print_options();
			try{num=next.nextInt();
			options(num);
		}
		catch (Exception e){
			next.nextLine(); // swallow token 
			System.out.println("Wrong input,please enter a numeric number.");
		}	
		
		
		}
	 	 
	 	 
	 	 
	}

}
