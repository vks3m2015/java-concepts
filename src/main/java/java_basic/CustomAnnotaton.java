package java_basic;

import java.lang.annotation.*;


/*   https://www.youtube.com/watch?v=o9vn4No_ii4
 *   https://www.oracle.com/technetwork/articles/hunter-meta-2-098036.html
 *   https://dzone.com/articles/creating-custom-annotations-in-java
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

@interface MyAnnotation{
	int value() default -1;
	String message() default "This is default msg"; 
}

@MyAnnotation(value = 1, message = "This is passed message")
class AnnotaionDemo{
	
	public AnnotaionDemo()
	{
		System.out.println("inside AnnotaionDemo constructor.....");
	}
}


public class CustomAnnotaton {

	
	public static void main(String[] args) {
       		
		AnnotaionDemo annoDemo = new AnnotaionDemo();
		Class annoClass = annoDemo.getClass();
		Annotation anno =  annoClass.getAnnotation(MyAnnotation.class);
		MyAnnotation myAnno = (MyAnnotation)anno;
		System.out.println("  msg =="+myAnno.message());
	}

}
