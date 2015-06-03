package mum.edu.framework.factory;


public class  InjectionFactory {

	private InjectionFactory() {
		
	}
	/**
	 * Automatically a "singleton" as DispatcherServlet is ONLY one to call it
	 * Assumes CoC - the implementation name is an "extension" of the interface name
	 * @param dependencyObjectName
	 * @return
	 */

 	public static final Object getInstance(String interfaceName) {
		Object dependencyObject = null;
 		
		String classImplName = interfaceName + "Impl";

 		try {
 			// using the Reflection API get the class(forName); get the default Constructor; create an instance...
 			dependencyObject = (Object)  Class.forName(classImplName).getConstructor().newInstance();			
 		
 		}
 		catch (Exception e){
	    	e.printStackTrace();
 		}
 		
		return (dependencyObject);
 			

 	}
}
