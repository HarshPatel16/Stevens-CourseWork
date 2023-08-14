import java.util.*; 

public class smallest {

	public static void main(String[] args) {
		
		/*This is main function*/
		
		Scanner sc = new Scanner(System.in);
		double[] a = new double[10];
		System.out.println("Enter 10 numbers separated by one space: ");
		for(int i=0; i<10;i++) {
			a[i]=sc.nextDouble();
		}
		System.out.println("Minimum is: "+ min(a));
		System.out.println("Index is: "+indexOfSmallestElement(a));
		System.out.println("Sorted array: ");
		a= sort(a);
		for(int i=0;i<10;i++) {
			System.out.print(a[i]+ " ");
		}
	}
	public static double min(double[] a) {
		
		/*This function returns minimum of provided array*/
		
		double minimum=a[0];
		for(int i=0;i<10;i++) {
			if(a[i]<minimum) {
				minimum=a[i];
			}
		}
		return minimum;
	}
	public static int indexOfSmallestElement(double[] a) {
		
		/*This function returns index of smallest element of an array*/
		
		double b=min(a);
		int ind=0;
		for(int i=0;i<10;i++) {
			if(b==a[i]) {
				ind=i;
			}
		}
		return ind;
	}
	public static double[] sort(double[] a) {
		
		/*This function takes an array and returns sorted array*/
		
		for(int i=0;i<10;i++){
			for(int j=i+1;j<10;j++) {
				double temp=0;
				if(a[i]>a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		return a;
	}
 
}

