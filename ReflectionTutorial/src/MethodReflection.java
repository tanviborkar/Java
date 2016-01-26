import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MethodReflection {

	public static void main(String[] args) {
		Class stringClass = String.class;
		
		//code to get all the methods of the class
		Method[] stringMethods = stringClass.getMethods();
		for(Method stringMethod : stringMethods){
			System.out.println("Method Name: "+stringMethod.getName());
			Parameter[] methodParameters = stringMethod.getParameters();
			for(Parameter parameter : methodParameters){
				System.out.println("Method Parameters: "+parameter.getName() + "-" + parameter.getType());
			}
			System.out.println("Method Return Type: "+stringMethod.getReturnType());
			System.out.println();
		}
		
		//code to get a specific method of the class
		try {
			Method indexOfMethod = stringClass.getMethod("indexOf", new Class[]{String.class, int.class});
			//code to invoke method
			String stringToManipulate = new String("misunderstanding");
			Object[] arguments = new Object[2];
			arguments[0] = "s";
			arguments[1] = 5;
			System.out.println("Invoking indexOf method "+indexOfMethod.invoke(stringToManipulate, arguments));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
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

}
