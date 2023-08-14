import java.util.*;

public class primenumbers {

	public static void main(String[] args) {
		
		/*This is main function*/
		
		Scanner sc= new Scanner(System.in);
		int n=2,count=0;
		System.out.println("First 50 Prime numbers");
		while(count<50){
			if(isPrime(n)) {
				System.out.print(n+" ");
				count++;
				if(count%8==0) {
					System.out.println();
				}
			}
			n++;
			}
		
		n=2;count=0;
		while(n<10000){
			if(isPrime(n)) {
				count++;
			}
			n++;
			}
		System.out.println();
		System.out.println("Number of prime numbers less than 10000: "+count);
		//System.out.println();
		System.out.println("Enter the number:");
		int x=sc.nextInt();
		if(isPrime(x)){
			System.out.println(x+" is a prime number");
		}
		else {
			int[] b = factors(x);
			System.out.print("Factors of "+x+" are: ");
			for(int i=0;i<b.length;i++) {
				if(b[i]!=0) {
				System.out.print(b[i]+ " ");
				}
			}
	
		}
	}
	public static boolean isPrime(int number) {
		
		/*This function checks if the number is prime or not and returns boolean*/
		
		for (int divisor = 2; divisor <= number / 2; divisor++) {
		 if (number % divisor == 0) { 
		 return false; 
		 }
		 }
		
		 return true; 
		 }
	
	public static int[] storing() {
		
		/*This function stores prime numbers that are in between 1 to 1000 in an array and returns that array*/
		
		int[] a = new int[168];
		int x=2,i=0;
		while(x<1000) {
			if(isPrime(x)) {
				a[i]=x;
				i++;
			}
			x++;
		}
		return a;
	}
	public static int[] factors(int n) {
		
		/*This function returns the factors of provided number*/
		
		int[] c = storing();
		int[] d= new int[168];
		int i=0,j=0;
		while(n>1) {
		if(n%c[i]==0){
			d[j]=c[i];
			j++;
			n=n/c[i];
		}
		else
			i++;
		}
		return d;
	}
}