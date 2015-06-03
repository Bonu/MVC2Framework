package mum.edu.framework.factory;

 
public class DomainObjectFactory {

	private DomainObjectFactory() {
		
	}
	/**
	 * Automatically a "singleton" as DispatcherServlet is ONLY one to call it
	 * @param controllerName
	 * @return
	 */

 	public static final Object getInstance(Class domain) {
		Object domainObject = null;
 		
 		try {
 			// using the Reflection API get the class(forName); get the default Constructor; create an instance...
  			domainObject = (Object)  domain.newInstance();			
 		
 		}
 		catch (Exception e){
	    	e.printStackTrace();
 		}
 		
		return (domainObject);
 			

 	}
}
