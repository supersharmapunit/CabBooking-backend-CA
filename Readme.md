# Cab Booking Application

The Cab Booking Application is a Java-based application built using Spring Boot. It allows users to book rides with available drivers and manage the cab booking process.

## Features

- User onboarding: Users can register themselves in the system.
- Driver onboarding: Drivers can onboard themselves with their vehicle details and current location.
- Ride booking: Users can search and book available rides based on their source and destination locations.

## System Design

The application is designed with a modular and extensible architecture, consisting of the following components:

1. **User Management**: Responsible for user onboarding and registration.
2. **Driver Management**: Responsible for driver onboarding and tracking their current location.
3. **Ride Booking**: Responsible for finding and booking available rides based on user's requirements.

The key entities in the system are:

- **User**: Represents a user of the cab booking application.
- **Driver**: Represents a driver providing cab services.
- **Ride**: Represents a ride booked by a user.

The system uses in-memory data structures (e.g., `HashMap`, `List`) to store and manage the user, driver, and ride information. For production use, a persistent storage solution (e.g., database, NoSQL store) can be integrated.

## Project Information

The application will start running on `http://localhost:8080/`.

## Testing

The project includes unit tests for the key components of the application. To run the tests.

The tests cover the following scenarios:

- User onboarding
- Driver onboarding
- Ride finding and booking
- Concurrency handling (bonus)
## Future Enhancements

- **Persistence**: Implement a persistent storage solution (e.g., database, file system) to store user, driver, and ride information.
- **Ride Cancellation**: Allow users to cancel their booked rides.
- **Ride History**: Maintain a history of all the rides taken by users.
- **Ride Tracking**: Allow users to track the status of their booked rides.
- **Rider Ratings**: Implement a rating system for riders and drivers.
- **Surge Pricing**: Implement dynamic pricing based on demand and supply.
- **Notifications**: Implement push notifications for users and drivers regarding ride updates.