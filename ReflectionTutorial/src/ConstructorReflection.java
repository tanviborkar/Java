import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class ConstructorReflection {

	public static void main(String[] args) {
		try {
			Class stringClass = Class.forName("java.lang.String");
			
			//code to get all constructors of a class
			Constructor[] stringConstructors = stringClass.getConstructors();
			if(stringConstructors.length != 0){
				System.out.println("Constructors: ");
				for (Constructor constructorObj : stringConstructors) {
					System.out.println(constructorObj.toString());
					getParameterTypes(constructorObj);
				}
			}
			
			//code to get constructors depending on parameters
			Constructor specificConstructor = stringClass.getConstructor(new Class[]{String.class});
			System.out.println("Specific Constructor: "+specificConstructor.toString());
			
			//code to instantiate a new String object
			String testString = (String) specificConstructor.newInstance("This is the new object");
			System.out.println("New object created: "+testString);
			Constructor intConstructor = stringClass.getConstructor(new Class[]{char[].class, int.class, int.class});
			char[] numbers = {1, 2, 3, 4, 5};
			Object[] arguments = new Object[3];
			arguments[0] = numbers;
			arguments[1] = 2;
			arguments[2] = 1;
			String intString = (String)intConstructor.newInstance(numbers, 2, 3);
			System.out.println("Object using Integer constructor: "+intString);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getParameterTypes(Constructor currentConstructor){
		System.out.println("Parameters of above constructor: ");
		Class[] parameterList = currentConstructor.getParameterTypes();
		if(parameterList.length != 0){
			System.out.println("Constructors: ");
			for (Class parameterObj : parameterList) {
				System.out.println(parameterObj.toString());
			}
		}
	}
}
