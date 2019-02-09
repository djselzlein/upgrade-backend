# upgrade-backend

## Campsite Reservation API

### Postman example requests

https://www.getpostman.com/collections/ad8c2a36e968fc89a87d

### Reservation Concurrency

In order to handle concurrency in Reservation, Reserved Dates are stored so Dates have a Unique Constraint.
Application then handles constraint violation exceptions and returns proper error message. 

JMeter concurrency execution plan can be found in `src/main/resources`
