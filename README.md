# MC Gateway Transaction API

Spring Boot microservice powering the Mastercard Gateway.

## Endpoints
| Method | Path | Description |
|--------|------|-------------|
| POST | /api/v1/transactions | Authorise payment |
| GET | /api/v1/transactions/{id} | Get status |
| GET | /actuator/health | Health check |

## Build
```bash
./mvnw clean package && java -jar target/gateway-api.jar
```

## Owner
payments-engineering | MC Payments Network