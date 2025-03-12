package reportgeneratorservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ReportActivator implements BundleActivator {
	
	private ServiceRegistration<?> reportGeneratorService;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Report Generator Service : Started");
		
		// Register the service
		ReportService service = new ReportServiceImpl();
		reportGeneratorService = context.registerService(
        ReportService.class.getName(), 
        service,                 
        null                               
        );
        
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		reportGeneratorService.unregister();
		System.out.println("Report Generator Service : Stoped");
	}

}
