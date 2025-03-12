package reportgeneratorservice;

import java.io.FileWriter;
import java.io.IOException;

public class ReportServiceImpl implements ReportService {

    @Override
    public void generateReport(String fileName, String data) {
    	
        // Get the user's Desktop path
        String userHome = System.getProperty("user.home");
        String filePath = userHome + "/Desktop/" + fileName; 

        // Generate report txt file
        try (FileWriter writer = new FileWriter(filePath, true)) {
        	writer.write("--------------------------------------\n");
            writer.write(data);
            writer.write("--------------------------------------\n");
            System.out.println("📂 Surgery details successfully saved to: " + filePath);
            
        } catch (IOException e) {
        	
            System.out.println("❌ Error writing to file: " + e.getMessage());
            
        }
    }
}
