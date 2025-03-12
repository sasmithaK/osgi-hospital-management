package surgeonavailabilityservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class SurgeonActivator implements BundleActivator {
	
	private ServiceRegistration<?> doctorServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		
System.out.println("Surgeon Availability Service : Started ✅");

	// Register Doctor availability service
	SurgeonAvailabilityService service = new SurgeonAvailabilityServiceImpl();
	doctorServiceRegistration = context.registerService(
	SurgeonAvailabilityService.class.getName(), 
	service, 
	null 
	);
		
	System.out.println("Surgeon Availability Service Registered");
		
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Surgeon Availability Service : Stopped ❎");
		
		// Unregister Doctor allocation service
		doctorServiceRegistration.unregister();
		
		System.out.println("Surgeon Availability Service Unregistered.");
		
	}

}
