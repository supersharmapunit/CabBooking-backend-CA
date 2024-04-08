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

## API Routes

### Base URL - `http://localhost:8080/api/v1`

### CustomerController

#### POST /customers
- **Description:** Add a new customer
- **Request Body:** `@Valid UserDTO customer`
- **Response:** `ResponseDTO`
- Success: HTTP 201 Created
- Validation Error: HTTP 400 Bad Request
- Internal Error: HTTP 500 Internal Server Error

#### GET /customers
- **Description:** Get all customers
- **Response:** `ResponseDTO`
- Success: HTTP 200 OK

### DriverController

#### POST /drivers
- **Description:** Create a new driver
- **Request Body:** `DriverDTO driverDto`
- **Response:** `ResponseDTO`
- Success: HTTP 201 Created
- Error: HTTP 400 Bad Request

#### GET /drivers
- **Description:** Get all drivers
- **Response:** `ResponseDTO`
- Success: HTTP 200 OK
- Error: HTTP 400 Bad Request

### RideController

#### POST /rides/find
- **Description:** Find available rides
- **Request Body:** `FindRideRequestDTO findRideRequestDTO`
- **Response:** `ResponseDTO`
- Success: HTTP 200 OK
- No Rides Available: HTTP 404 Not Found
- Bad Request: HTTP 400 Bad Request
- Internal Error: HTTP 500 Internal Server Error

#### POST /rides/choose
- **Description:** Choose a ride
- **Request Parameters:** `String userId, String driverId`
- **Response:** `ResponseDTO`
- Success: HTTP 200 OK
- No Rides Available: HTTP 404 Not Found
- Bad Request: HTTP 400 Bad Request
- Internal Error: HTTP 500 Internal Server Error

### DTO Structures

#### DriverDTO
```json
{
  "name": "string",
  "gender": "string",
  "age": 0,
  "vehicleInfo": {
    "carType": "string",
    "registrationNumber": "string"
  },
  "location": {
    "x": 0,
    "y": 0
  }
}
```
#### UserDTO
```json
{
  "name": "string",
  "gender": "string",
  "age": 0
}
```

#### FindRideRequestDTO
```json
{
  "userId": "string",
  "source": {
    "x": 0,
    "y": 0
  },
  "destination": {
    "x": 0,
    "y": 0
  }
}
```

#### ResponseDTO
```json
{
  "success": true,
  "message": "string",
  "data": {},
  "error": "string"
}
```

#### ModelCreatedResponseDTO
```json
{
  "id": "string"
}
```
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