/***
 * Assignment : Homework Assigment 2
 * Name: Harsh Patel
 * Course: CS-570
 */


public class Complexity {

    // A method that has time complexity O(n^2).
    public static void method1(int n){
        int counter=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println("Operation O(n^2)"+counter);counter++;    
            }
        }
    }

    // A method that has time complexity O(n^3).
    public static void method2(int n){
        int counter=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                System.out.println("Operation O(n^3)"+counter);counter++;    
                }
            }
        }
    }

    // A method that has time complexity O(log n).
    public static void method3(int n){
        int counter=0;
        for(int i=1;i<n+1;i=i*2){
                System.out.println("Operation O(log n)"+counter);counter++;    
        }
    }

    // A method that has time complexity O(n logn).
    public static void method4(int n){
        int counter=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<n+1;j=j*2){
                System.out.println("Operation O(n log n)"+counter);counter++;
            }
        }
    }

    // A method that has time complexity O(log logn).
    public static void method5(int n){
        int counter=0;
        for(int i=2;i<n+1;i=i*i){
                System.out.println("Operation O(log log n)"+counter);counter++;
        }
    }
    
    private static int counter=1;

    // A method that has time complexity O(2^n).
    public static int method6(int n){
        System.out.println("Operation O(2^n): " +counter); counter++;
        if(n<=1){return n;}
        else{return method6(n-1)+method6(n-1);}
    }


    public static void main(String[] args){
        method1(3);
        method2(2);
        method3(24);
        method4(2);
        method5(128);
        method6(5);
    }
}

