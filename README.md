# Hospital Management System (OSGi)

## Overview
This is a simple CLI-based Hospital Management System built using the Eclipse Equinox OSGi framework. It's a university assignment to practice Microkernel Architecture by implementing modular and extensible services.

## Features
The system includes the following services:
- **Surgery Schedule Service**: Manages surgery scheduling.
  - **Surgery Room Allocation Service**: Allocates surgery rooms based on availability.
  - **Surgeon Allocation Service**: Assigns surgeons to scheduled surgeries.
  - **Report Generation Service**: Generates reports related to surgeries and resource allocation.

## Technologies Used
- **Java**
- **Eclipse Equinox OSGi Framework**
- **Microkernel Architecture**

## Project Structure
```
HospitalManagementSystem/
├── SurgeryScheduleService/  # Manages surgery scheduling
├── SurgeryRoomAllocationService/  # Allocates rooms
├── SurgeonAllocationService/  # Assigns surgeons
└── ReportGenerationService/  # Generates surgery reports
```

## Installation & Setup
### Running on Eclipse
1. Open **Eclipse IDE** and install the **OSGi Development Tools Plugin** if not already installed.
2. Import the project into Eclipse:
   - Click **File** → **Import** → **Existing Projects into Workspace**.
   - Select the project folder and click **Finish**.
3. Configure the **Run Configuration**:
   - Go to **Run** → **Run Configurations**.
   - Create a new **OSGi Framework** configuration.
   - Select all the required bundles.
   - Click **Apply** and then **Run**.
4. Open the OSGi console in Eclipse to interact with the system.

## Usage
- Interact with the CLI to schedule surgeries, allocate rooms and surgeons, and generate reports.
- Ensure all required bundles are installed and started before running operations.
