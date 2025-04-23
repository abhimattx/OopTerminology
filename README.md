# Car Management System

## Overview

The Car Management System is a comprehensive Java application designed to help users track, manage, and analyze their vehicles. With an intuitive console interface, the application allows users to record trips, schedule maintenance, and gain insights into their vehicle's performance and efficiency.

![Car Management System Logo](https://img.shields.io/badge/Car%20Management-System-blue)
![Java](https://img.shields.io/badge/Java-SE%2017-orange)
![Status](https://img.shields.io/badge/Status-Stable-green)

## Features

### Vehicle Management
- Store detailed information about multiple vehicles
- Track make, model, year, and current odometer reading
- Classify cars based on age (new, semi-used, used, old)

### Trip Tracking
- Record trip details including date, distance, fuel consumption, and travel time
- Calculate and display trip statistics:
  - Average speed
  - Fuel efficiency (km/L)
  - Total distance traveled

### Maintenance Records
- Log maintenance activities with service type, date, cost, and description
- Track maintenance history by vehicle
- Calculate total maintenance costs

### Analytics
- Calculate lifetime fuel efficiency
- Generate trip summaries with total distance and fuel consumption
- View maintenance expense breakdowns

## System Architecture

The application follows a clean architecture with separation of concerns:

```
com.carapp/
├── model/          # Data models (Car, Trip, Maintenance)
├── service/        # Business logic layer
├── ui/             # User interface components
├── util/           # Utility classes
└── DemoLauncher    # Application entry point with demo data
```

### Key Components

- **Car**: Core model representing a vehicle with its properties and history
- **Trip**: Model for trip information with calculation capabilities
- **Maintenance**: Model for maintenance record details
- **CarService**: Service layer handling business operations
- **CarApp**: Main UI controller for user interactions
- **InputValidator**: Utility for validating user input

## Getting Started

### Prerequisites
- Java SE 17 or higher
- Command line interface

### Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/username/car-management-system.git
   ```

2. Navigate to the project directory:
   ```bash
   cd car-management-system
   ```

3. Compile the project:
   ```bash
   javac com/carapp/model/*.java com/carapp/service/*.java com/carapp/ui/*.java com/carapp/util/*.java com/carapp/*.java
   ```

### Running the Application

#### Standard Launch
```bash
java com.carapp.ui.CarApp
```

#### Demo with Sample Data
```bash
java com.carapp.DemoLauncher
```

## Usage Guide

### Adding a New Car
1. Select option 1 from the main menu
2. Enter the requested details:
   - Make and model
   - Year of manufacture
   - Current odometer reading
   - Fuel type
   - Tank capacity

### Recording a Trip
1. Select option 2 from the main menu
2. Choose a car from the list
3. Enter trip details:
   - Date (YYYY-MM-DD format)
   - Starting and ending odometer readings
   - Fuel used in liters
   - Travel time in hours
   - Brief description

### Recording Maintenance
1. Select option 3 from the main menu
2. Choose a car from the list
3. Enter maintenance details:
   - Date of service
   - Type of service
   - Description
   - Cost
   - Odometer reading at time of service

### Viewing Information
- Option 4: View detailed car information
- Option 5: View trip history and statistics
- Option 6: View maintenance history and total costs

## Data Persistence

Currently, all data is stored in memory during application runtime. When the application is closed, all data will be lost. Future versions will implement JSON-based persistence.

## Future Enhancements

- Data persistence using JSON files
- Fuel price tracking and cost analysis
- Maintenance scheduling and reminders
- Graphical user interface (GUI)
- Mobile application integration
- Multi-user support with authentication

## Technical Implementation

The system demonstrates several important object-oriented programming concepts:

- **Encapsulation**: Private fields with getter/setter methods
- **Composition**: Car objects contain lists of Trip and Maintenance objects
- **Method Overriding**: Custom toString(), equals(), and hashCode() implementations
- **Separation of Concerns**: Clear division between data, business logic, and UI
- **Defensive Copying**: Returning copies of collections to preserve encapsulation

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Thanks to all contributors who participated in this project
- Special thanks to the Java community for their continued support

---

© 2025 Car Management System | Developed with ❤️ by Abhishek Singh