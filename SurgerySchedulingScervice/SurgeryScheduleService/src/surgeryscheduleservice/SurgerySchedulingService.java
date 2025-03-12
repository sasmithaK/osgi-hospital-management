package surgeryscheduleservice;

import java.util.List;
import java.util.Scanner;
import org.osgi.framework.ServiceReference;
import roomallocationservice.Room;
import roomallocationservice.RoomAllocationService;
import surgeonavailabilityservice.Surgeon;
import surgeonavailabilityservice.SurgeonAvailabilityService;
import reportgeneratorservice.ReportService;
import org.osgi.framework.BundleContext;

public class SurgerySchedulingService {
	
    public void sugeryScheduler(BundleContext context) {
        
        // Get References 
        // Surgeon availability service
        ServiceReference<SurgeonAvailabilityService> doctorServiceRef = context.getServiceReference(SurgeonAvailabilityService.class);
        SurgeonAvailabilityService doctorService = context.getService(doctorServiceRef);
        
        // Surgery Room Allocation service
        ServiceReference<RoomAllocationService> roomServiceRef = context.getServiceReference(RoomAllocationService.class);
        RoomAllocationService roomService = context.getService(roomServiceRef);
        
        // Report Generator Service
        ServiceReference<ReportService> reportGenServiceRef = context.getServiceReference(ReportService.class);
        ReportService reportService = context.getService(reportGenServiceRef);
    
        // Initialize scanner
        Scanner read = new Scanner(System.in);
        
        String counter = "y";
        String surgeonName = null;
        String allocatedRoom = null;
        String allocatedTime = null;
        
        // Get Surgeons List
        List<Surgeon> availableDoctors = doctorService.getAvailableDoctors();

        // Prompts
        System.out.println("===============================================");
        System.out.println("  💡 Welcome to the Surgery Scheduling System  ");
        System.out.println("===============================================");

        do {
            String input;
            do {
                System.out.println("\n🏥 Schedule a surgery");
                System.out.println("Use the command : schedule");
                System.out.print("> ");
                input = read.nextLine();

                if (!input.equalsIgnoreCase("schedule")) {
                    System.out.println("❌ Invalid command! Please type 'schedule' command to proceed.");
                }
            } while (!input.equalsIgnoreCase("schedule"));  // Keep asking until "schedule" is entered correctly

            // Get patient details 
            System.out.print("Enter Patient Name : ");
            String patient_name = read.nextLine();
            
            System.out.println("\nAvailable Surgery Types:");
            System.out.println("1) Heart Surgery \n2) Neurosurgery \n3) Cardiac Surgery");
            
            System.out.print("\nEnter Surgery Type : ");
            String surgery_type = read.nextLine();
            System.out.println("\nSurgery Scheduling System Processing request...\n");
            
            System.out.println("🔄 Surgery scheduling for");
            System.out.println("🙎‍♂️ Patient : " + patient_name);
            System.out.println("🩺 Surgery Type : " + surgery_type);
            System.out.println(" ");

            // Check doctor availability
            if (doctorService != null) {
                System.out.println("🔄 Checking Surgeon availability...");
                
                if (availableDoctors.isEmpty()) {
                    System.out.println("❌ No Surgeon available at the moment.");
                } else {
                    System.out.println("===============================================");
                    System.out.println("        Available " + surgery_type + " Surgeons");
                    System.out.println("_______________________________________________");
                    System.out.println("\n  Surgeon ID | Surgeons Name");
                    System.out.println("_______________________________________________");

                    for (Surgeon doc : availableDoctors) {
                        if (doc.getSurgeryType().equalsIgnoreCase(surgery_type)) {
                            System.out.println("    " + doc.getDocID() + "   | " + doc.getName());
                        }
                    }

                    System.out.print("\nAssign a Surgeon for the surgery\nEnter Surgeon ID : ");
                    String doctorID = read.nextLine();
                    
                    for (Surgeon doc : availableDoctors) {
                        if (doc.getDocID().equalsIgnoreCase(doctorID)) {
                            surgeonName = doc.getName();
                            System.out.println("👨‍⚕️ " + doc.getName() + " has been assigned to patient " + patient_name + "'s " + surgery_type);
                            System.out.println(" ");
                        }
                    }
                }
                
            } else {
                System.out.println("❌ Surgeon AvailabilityService is not available!");
            }

            // Check available rooms
            if (roomService != null) {
                List<Room> availableRooms = roomService.getAvailableRooms(surgery_type);
                
                if (availableRooms.isEmpty()) {
                    System.out.println("❌ No rooms available for " + surgery_type + " at the moment.");
                } else {
                    Room assignedRoom = availableRooms.get(0);
                    System.out.println("✅ Room " + assignedRoom.getRoomNumber() + " has been assigned.");
                    System.out.println("📅 Available Date & Time: " + assignedRoom.getAvailableDateTime());
                    allocatedRoom = assignedRoom.getRoomNumber();
                    allocatedTime = assignedRoom.getAvailableDateTime();
                }
            } else {
                System.out.println("❌ Room Allocation Service is not available!");
            }

            // Send collected data to the Report Generator Service
            if (reportService != null) {
                String scheduleData = "Patient Name: " + patient_name + "\n" +
                                      "Surgery Type: " + surgery_type + "\n" +
                                      "Assigned Surgeon: " + surgeonName + "\n" +
                                      "Assigned Room: " + allocatedRoom + "\n" +
                                      "Room Available Date & Time: " + allocatedTime + "\n\n";
                
                String report_name = "Patient " + patient_name + "'s " + surgery_type + " Report.txt";

                reportService.generateReport(report_name, scheduleData);
                System.out.println("✅ Surgery details saved to report.");
            } else {
                System.out.println("❌ Report Service is not available!");
            }

            // Ask if user wants to continue
            System.out.println("\nContinue using this service? (Y/N)");
            String cont = read.nextLine();
            if (cont.equalsIgnoreCase("N")) {
                counter = "n";
            }

        } while (!counter.equalsIgnoreCase("n"));

        System.out.println("👋 Thank you for using the Surgery Scheduling System!");
        
        read.close();
    }
}
