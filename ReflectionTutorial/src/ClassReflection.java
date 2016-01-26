import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassReflection {
	public static void main(String args[]){
		//code to get class using the Classname
		Class intClass = Integer.class;
		System.out.println("Integer class compile time: "+intClass.toString());
		try {
			//code to get the class at runtime using the fully qualified name passed as a string
			Class arrayClass = Class.forName("java.util.Arrays");
			System.out.println("Array class run time: "+arrayClass.toString());
			
			//code to get the name of the class fetched
			String fullyQualifiedClassName = arrayClass.getName();
			System.out.println("Fully Qualified Name: "+fullyQualifiedClassName);
			String className = arrayClass.getSimpleName();
			System.out.println("Class Name: "+className);
			
			//code to get the modifiers of the class
			getModifierInformation(arrayClass.getModifiers());
			
			//code to get package of a class
			Package classPackage = arrayClass.getPackage();
			System.out.println("Package: "+classPackage.toString());
			
			//code to get superclass of the class
			Class parentClass = arrayClass.getSuperclass();
			System.out.println("Superclass: "+parentClass.toString());
			
			//code to get interfaces of a class
			Class[] interfaces = arrayClass.getInterfaces();
			if(interfaces.length != 0){
				System.out.println("Interfaces Implemented: ");
				for (Class interfaceObj : interfaces) {
					System.out.println(interfaceObj.toString());
				}
			}
			
			//code to get constructors of the class
			Constructor[] constructors = arrayClass.getConstructors();
			if(constructors.length != 0){
				System.out.println("Constructors: ");
				for (Constructor constructorObj : constructors) {
					System.out.println(constructorObj.toString());
				}
			}
			
			//code to get methods of a class
			Method[] methods = arrayClass.getMethods();
			if(methods.length != 0){
				System.out.println("Methods: ");
				for (Method methodObj : methods) {
					System.out.println(methodObj.toString());
				}
			}
			
			//code to get fields of a class
			Field[] fields = arrayClass.getFields();
			if(fields.length != 0){
				System.out.println("Fields: ");
				for (Field fieldObj : fields) {
					System.out.println(fieldObj.toString());
				}
			}
			
			//code to get annotations of a class
			Annotation[] annotations = arrayClass.getAnnotations();
			if(annotations.length != 0){
				System.out.println("Annotations: ");
				for (Annotation annotationObj : annotations) {
					System.out.println(annotationObj.toString());
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getModifierInformation(int classModifier){
		System.out.println("Abstract: "+Modifier.isAbstract(classModifier));
		System.out.println("Final: "+Modifier.isFinal(classModifier));
		System.out.println("Interface: "+Modifier.isInterface(classModifier));
		System.out.println("Native: "+Modifier.isNative(classModifier));
		System.out.println("Private: "+Modifier.isPrivate(classModifier));
		System.out.println("Protected: "+Modifier.isProtected(classModifier));
		System.out.println("Public: "+Modifier.isPublic(classModifier));
		System.out.println("Static: "+Modifier.isStatic(classModifier));
		System.out.println("Strict: "+Modifier.isStrict(classModifier));
		System.out.println("Synchronized: "+Modifier.isSynchronized(classModifier));
		System.out.println("Transient: "+Modifier.isTransient(classModifier));
		System.out.println("Volatile: "+Modifier.isVolatile(classModifier));
	}
}
