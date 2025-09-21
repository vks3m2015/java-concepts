package concepts.exception;

public class returnTryCatchFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("in main ="+ method());
		
	   method2();
		
		//System.out.println("in main " +returnTryCatchFinally.method3());
		
		//System.out.println("in main " +returnTryCatchFinally.method4());

        //System.out.println("return value = " + method5());
	}

	//return value - 2
	 public static int method() {
		 try {
             System.out.println(" inside try....");
			 return 1;
		 } catch(Exception e) {
		 }
		 finally {
			 System.out.println(" outside finally....");
			 return 2;
		 }
		// System.out.println(" outside finally....");
		// return 1;
		 
	 }
	 
	 public static void method2() {
		try{
            try {
                int a = 0;
                int b = 100/a;
            }catch (ArithmeticException ex){
                System.out.println(" Inner catch");
            }
            int[] arr = {1,2};
            arr[2] = 5;
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(" outer catch");
        }
	 }
	 
	 
	 /*
	  * In this method Arithmetic Exception occur but is not handled. 
	  * In finally block this exception is overridden due to 'return' statement
	  * so this method will return 12 as output that's why it is not recommend to place return statement in finally block as
	  *  we will not be able to know actual exception in this scenario
	  */
	 public static int method3() {
		 try {
			 System.out.println(" inside try....");
			 int a = 10/0;
		 }
		 catch(NullPointerException e) {
			 System.out.println(" inside catch block....");
		 }
		 finally {
			 System.out.println(" inside finally....");
		     return 12; 
		 }
		 
		//System.out.println(" outside finally....");
		 //return 1;
		 
	 }
	 
	 
	 /*
	  * this function will return value returned by catch block i.e. 2
	  * 
	  */
	 public static int method4() {
		 try {
			 System.out.println(" inside try....");
			 int b = 10/0;
		 }
		 catch(ArithmeticException e) {
			 System.out.println(" inside catch block....");
			 return 2;
		 }
		 finally {
			 System.out.println(" inside finally....");
		 }
		 System.out.println(" outside finally....");
		 return 4;
	 }

     //return value will be - 3
    public static int method5() {
        try {
            System.out.println(" inside try....");
            int b = 10/0;
            return 1;
        }
        catch(ArithmeticException e) {
            System.out.println(" inside catch block....");
            return 2;
        }
        finally {
            System.out.println(" inside finally....");
            return 3;
        }
    }
	 
}
