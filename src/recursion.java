
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
	public static void main(String [] args)
	{
		System.out.println(sqrt(5,0.001));
		System.out.println(sqrt(4,0.0000000001));
	}

}
