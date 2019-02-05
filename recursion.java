import java.util.*;

public class recursion {


	public static double sqrtH(double n, double guess, double tolerance ){
		if( n == 0) {
			return 0;
		}
		else {
			if( guess * guess * (1+ tolerance / 100) > n && guess * guess * (1 - tolerance / 100) < n) {
				return guess;
			}
			else {
				return sqrtH(n, (n / guess + guess)/2, tolerance );
			}
		}
	}
	public static double sqrt(double n, double tolerance){
		return sqrtH(n,1,tolerance);
	}
	
	public static int fibH(int n, int f_1, int f_2){
		if(n == 0) {
			return f_1;
		}
		else {
			return fibH( n - 1, f_1 + f_2, f_1);
		}
    }
	public static int fib(int n){
		return fibH(n,0,1);
    }
	
	public static ArrayList<Integer> makeAllSums(int n){
		if(n == 1) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.add(0);
			newList.add(1);
			return newList;
		}
		ArrayList<Integer> newList = new ArrayList<Integer>();
		ArrayList<Integer> halfList = new ArrayList<Integer>();
		halfList = makeAllSums(n - 1);
		ArrayList<Integer> otherHalfList = new ArrayList<Integer>();
		for(int i = 0; i < halfList.size(); i ++) {
			otherHalfList.add(halfList.get(i) + n);
		}
		newList.addAll(halfList);
		newList.addAll(otherHalfList);

		return newList;
	
	}
	
	public static void main(String [] args)
	{
		System.out.println(sqrt(5,0.001));
		System.out.println(sqrt(4,0.0000000001));
		System.out.println(fib(4000));
		System.out.println(makeAllSums(10));
	}

}
