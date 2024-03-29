package concepts.design_patterns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * 
 * 
 * //https://www.youtube.com/watch?v=GH5_lhFShfU
 */


class Singleton implements Serializable, Cloneable{
    
	
	private static final long serialVersionUID = 1L;
	private static Singleton singletonInstance = null;
	
	//private Constructor
	private Singleton(){
		if(singletonInstance != null )
			throw new RuntimeException("cann't create. Use getInstance() to create .. ");
		
		System.out.println(" Creating Singleton class object in Constructor....");
	}
	
	public static Singleton getInstance() {
		if (singletonInstance == null) {
			synchronized (Singleton.class) {
				if (singletonInstance == null) {
					System.out.println(" Creating Singleton class object in static method....");
					singletonInstance = new Singleton();
				}
			}
		}
		return singletonInstance;
	}
	
	private Object readResolve() throws ObjectStreamException{
		System.out.println(".. readResolve ...");
		return singletonInstance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
		//return super.clone();
	}
}

public class SingletonTest{
	
	public static void main(String[] args)throws Exception{
		
		//testCloneProof();
		testReflectionProof();
		//testSerializationProof();
	}
	
	//Cloning
	static void testCloneProof() throws CloneNotSupportedException {
		Singleton singletonObj1  = Singleton.getInstance();
		Singleton singletonObj5 = (Singleton)singletonObj1.clone();
		print("singletonObj5", singletonObj5);
	}
	
	// Serialization and DeSerialization
	static void testSerializationProof() throws FileNotFoundException, IOException, ClassNotFoundException {
		Singleton singletonObj1  = Singleton.getInstance();
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Files/SingletonObj"));
		oos.writeObject(singletonObj1);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Files/SingletonObj"));
		Singleton singletonObj4 = (Singleton) ois.readObject();

		print("singletonObj4", singletonObj4);

	}
	
	//Reflection
	static void testReflectionProof() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// Class singletonClass = Class.forName("javaConcepts.Singleton");
		Constructor<Singleton> cons = Singleton.class.getDeclaredConstructor();
		cons.setAccessible(true);
		Singleton singletonObj3 = (Singleton)cons.newInstance();
		print("singletonObj3", singletonObj3);
		print("singletonObj3_1", Singleton.getInstance());
	}
	
	public static void print(String name, Singleton singletonObj){
		System.out.println(" HashCode of "+name +" = "+ singletonObj.hashCode());
	}
}