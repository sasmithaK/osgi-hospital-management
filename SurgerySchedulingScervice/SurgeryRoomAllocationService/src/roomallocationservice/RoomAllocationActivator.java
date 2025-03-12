package roomallocationservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class RoomAllocationActivator implements BundleActivator {

	private ServiceRegistration<?> roomAllocationServiceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
    	
    	System.out.println("Surgery Room Allocation Service : Started ✅");
    	
    	// Register Room allocation service
        RoomAllocationService service = new RoomAllocationServiceImpl();
        roomAllocationServiceRegistration = context.registerService(
        		RoomAllocationService.class.getName(), 
        		service, 
        		null );
        
        System.out.println("Surgery Room Allocation Service Registered");
        
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    	
    	System.out.println("Surgery Room Allocation Service : Stopped ❎");
    	
    	// Unregister Room allocation service
    	roomAllocationServiceRegistration.unregister();
    	
        System.out.println("Surgery Room Allocation Service Unregistered.");
        
    }

}
