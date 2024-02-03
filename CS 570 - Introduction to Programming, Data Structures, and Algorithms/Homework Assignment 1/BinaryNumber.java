/***
 * Assignment : Homework Assigment 1
 * Name: Harsh Patel
 * Course: CS-570
 */


import java.util.*;
import java.lang.Math;

public class BinaryNumber 
{
    private int data[];
	private boolean overflow;
    
    /* Constructor BinaryNumber(int length) for creating a binary number of length length and consisting only of zeros */
	public BinaryNumber(int length) throws Exception{
        if(length<=0) throw new Exception("Invalid length"); // If input length is empty it thorws an Exception
        int[] data = new int[length];
        for(int i=0; i<length;i++) {
            data[i]=0;
        }
        this.data=data;
    }

    /* Constructor BinaryNumber(String str) for creating a binary number given a string. */
    public BinaryNumber(String str) throws Exception{
        int length = str.length();
        if(length==0) throw new Exception("Empty String"); // If input string is empty it throws an Exception
        
        int[] data = new int[length];
        for(int i=0;i<length;i++){
	        if(Character.getNumericValue(str.charAt(i))==1 || Character.getNumericValue(str.charAt(i))==0) {
                data[i]= Character.getNumericValue(str.charAt(i));
            } 
            else throw new Exception("Input number is not Binary"); // If inpiut string is not a binary number
        this.data=data;
        }
    }

    /*getLength method to retrieve length of the binary string*/
    public int getLength(){ 
        return data.length;
    }

    /*getDigit method to retrieve digit from index i */
    public int getDigit(int index) throws Exception{
        if(index<0 || index>=data.length) throw new Exception("Invalid Index");
        return data[index];
    }
    
    /*ShiftR method to shift binary number to right for given amount */
    public void shiftR(int amount) throws Exception{
        if(amount<0) throw new Exception("Invalid Amount");
        int x=data.length;
        data = Arrays.copyOf(data,(data.length + amount));
        int t = data.length;
        for(int i=x-1;i>=0;i--){
            data[t-1]=data[i];
            t--;
        }
        for(int i=0;i<amount;i++){
            data[i]=0;
        }
    }

    /*To add two binary numbers of same length */
    public void add(BinaryNumber aBinaryNumber) throws Exception{
		if(aBinaryNumber.data.length!=data.length) throw new Exception("Binary numbers doesn't have same length");
            int data1[] = new int[aBinaryNumber.getLength()];
			data1 = aBinaryNumber.data;
			int carry = 0;
				for(int i=0; i<data.length; i++) {
					int t = (carry + data[i] + data1[i]);
					if(t == 0) {
						data[i] = 0;
						carry = 0;
					} else if(t == 1) {
						data[i] = 1;
						carry = 0;
					} else if(t == 2) {
						data[i] = 0;
						carry = 1;
					} else if(t == 3) {
						data[i] = 1;
						carry = 1;
					}
				}
				if(carry == 1) {
					overflow = true;				
				}
			
    }

    /*To convert binary number to String */
    public String toString(){
        String str="";
        if(overflow==true){return "Overflow";}
        else{for(int i=0;i<data.length;i++){str+=data[i];}}
        return str;
    }

    /* To convert binary number to decimal number */
    public int toDecimal(){
        double value=0;
        int x=data.length-1;
	    for(int i=0;i<data.length;i++){
            value+=data[i]*Math.pow(2, x);
            x--;
        }
	    return (int)value;    
    }

    /*To clear the overflow*/
	public void clearOverflow() {
		this.overflow=false;
	}
	public static void main(String[] args) {

        try{
            BinaryNumber bn = new BinaryNumber(5);
            for(int i=0; i<bn.data.length;i++) {
            System.out.print(bn.data[i]);
            }
            System.out.println();
            BinaryNumber bn1 = new BinaryNumber(0); //Will throw an error
            }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            BinaryNumber bn= new BinaryNumber("1100");
            for(int i=0; i<bn.data.length;i++) {
                System.out.print(bn.data[i]);
            }
            System.out.println();
            System.out.println(bn.getLength());
            System.out.println(bn.getDigit(1));
            bn.shiftR(2);
            for(int i=0; i<bn.data.length;i++) {
                System.out.print(bn.data[i]);
            }
            System.out.println();
        }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            /* Try-Catch block for addition of binary numbers */
            BinaryNumber bn= new BinaryNumber("10110");
            BinaryNumber bn1= new BinaryNumber("11100");
            bn.add(bn1);
            for(int i=0; i<bn.data.length;i++) {
                System.out.print(bn.data[i]);
            }
            System.out.println();
            /* checking Overflow and tostring methods */
            System.out.println(bn.overflow);
            bn.clearOverflow();
            System.out.println(bn.overflow);
            System.out.print(bn.toString());
        }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            /*Try-catch block for converting binary to decimal */
            BinaryNumber bn= new BinaryNumber("0001");
            System.out.println();
            System.out.println(bn.toDecimal());
        }
        catch (Exception e){
            System.out.println(e);
        }
	}

}
