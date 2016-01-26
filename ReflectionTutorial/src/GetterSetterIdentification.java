import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import pojo.Student;

public class GetterSetterIdentification {

	public static void main(String[] args) {
		//checking getter/setters in built-in class 
		Class stringClass = String.class;
		Method[] stringMethods = stringClass.getMethods();
		for(Method method: stringMethods){
			System.out.println("Method Name: "+method.getName());
			System.out.println("isGetter: "+isGetter(method));
			System.out.println("isSetter: "+isSetter(method));
		}
		
		//checking getter/setter in user-defined class
		try {
			Class studentClass = Class.forName("pojo.Student");
			Method[] studentMethods = studentClass.getMethods();
			for(Method method : studentMethods){
				System.out.println("Method Name: "+method.getName());
				System.out.println("isGetter: "+isGetter(method));
				System.out.println("isSetter: "+isSetter(method));
			}
			//code to invoke the setter methods
			Student student = new Student();
			Method studentNameMethod = studentClass.getMethod("setStudentName", new Class[]{String.class});
			studentNameMethod.invoke(student, "Roger Federer");
			System.out.println("Student Name: "+student.getStudentName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static boolean isGetter(Method methodForIdentification){
		if(!methodForIdentification.getName().startsWith("get")){
			return false;
		}
		else if(void.class.equals(methodForIdentification.getReturnType())){
			return false;
		}
		else if(methodForIdentification.getParameterTypes().length > 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static boolean isSetter(Method methodForIdentification){
		if(!methodForIdentification.getName().startsWith("set")){
			return false;
		}
		else if(methodForIdentification.getParameterTypes().length != 1){
			return false;
		}
		else{
			return true;
		}
	}
}
