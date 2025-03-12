package surgeryscheduleservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import roomallocationservice.RoomAllocationService;
import surgeonavailabilityservice.SurgeonAvailabilityService;

import reportgeneratorservice.ReportService;

public class SurgeryScheduleActivator implements BundleActivator {

	// Refer services
    private ServiceReference<SurgeonAvailabilityService> doctorReference;
    private ServiceReference<RoomAllocationService> roomReference;
    private ServiceReference<ReportService> reportServiceReference;
    

    @Override
    public void start(BundleContext context) throws Exception {
    	
        System.out.println("Surgery Scheduling System : Started ✅");

        // Get Doctor Availability Service
        doctorReference = context.getServiceReference(SurgeonAvailabilityService.class);
        if (doctorReference != null) {
            System.out.println("Surgeon Availability Service acquired 📌");
            context.getService(doctorReference);
        } else {
            System.out.println("Surgeon Availability Service not available ❎");
        }

        // Get Room Allocation Service
        roomReference = context.getServiceReference(RoomAllocationService.class);
        if (roomReference != null) {
            System.out.println("Surgery Room Allocation Service acquired 📌");
            context.getService(roomReference);
        } else {
            System.out.println("Surgery Room Allocation Service not available ❎");
        }
        
        
        // Get File Writer Service (Report Generator)
        reportServiceReference = context.getServiceReference(ReportService.class);
        if (reportServiceReference != null) {
            System.out.println("📌 Report Generator Service acquired 📌");
            context.getService(reportServiceReference);
        } else {
            System.out.println("Report Generator Service not available ❎");
        }
        
        
        // Initialize Surgery Scheduling Service
        SurgerySchedulingService schedulingService = new SurgerySchedulingService();
        schedulingService.sugeryScheduler(context);

    }

    @Override
    public void stop(BundleContext context) throws Exception {
    	
    	// Release Services
        if (doctorReference != null) {
            context.ungetService(doctorReference);
            System.out.println("Surgeon Availability Service released ❌");
        }

        if (roomReference != null) {
            context.ungetService(roomReference);
            System.out.println("Surgery Room Allocation Service released ❌");
        }

        System.out.println("Surgery Scheduling System : Stopped ❎");
    }
}
