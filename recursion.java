import java.util.*;

public class recursion {

  public static boolean closeEnough(double n, double guess){
    if(n == 0){
      return true;
    }
    return ( guess-n)/n < 0.00001;
  }
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
  public static void testFib(int testcase){
  recursion r = new recursion();
  int[] input = {0,1,2,3,5,30};
  int[] output ={0,1,1,2,5,832040};
  int max = input.length;
  if(testcase < input.length){
    int in = input[testcase];
    try{

      int ans = r.fib(in);
      int correct = output[testcase];
      if(ans == correct){
        System.out.println("PASS test fib "+in+". "+correct);
      }
      else{
        System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test fib"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}


//testcase must be a valid index of your input/output array
  public static void testSqrt(int testcase){
    recursion r = new recursion();
    double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
    double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
    int max = input.length;
    if(testcase < input.length){
      double in = input[testcase];
      try{

        double ans = r.sqrt(in,.00001);
        double correct = Math.sqrt(in);
        if(closeEnough(ans,correct)){
          System.out.println("PASS test sqrt "+in+" "+ans);
        }
        else{
          System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }

	public static void main(String [] args)
	{
		for(int i=0;i<5;i++){
      testFib(i);
    }
    for(int i=0;i<8;i++){
      testSqrt(i);
    }
	}

}
