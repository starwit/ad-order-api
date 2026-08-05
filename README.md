# AD Stack Ride Order API

An OpenAPI specification and generated client/server stubs for submitting and managing ride orders to a vehicle's autonomous driving (AD) stack. It also defines data types to subscribe to vehicle status data.

## What this repo does

Defines the `AD Stack Ride Order API` (v0.0.1) — a REST API that runs on a vehicle's onboard network and serves exactly one vehicle. It covers:

- No API calls are defined in `spec/order-api.yaml`.



Onboard HMIs call the API directly; external backend systems reach it via an API gateway responsible for vehicle identification and routing. The API carries no customer or passenger data.

From the OpenAPI spec in `spec/ad-stack-api.yaml`, the Maven build generates:

| Target | Location |
|--------|----------|
| Java (Spring) model stubs | `generated/java/` |
| Rust (reqwest) client stubs | `generated/rust/` |

## Build & Run

**Prerequisites:** Java 25+, Maven 3.x

Generate all stubs:

```bash
mvn generate-sources
```

The generated sources are written to `generated/java/` and `generated/rust/` respectively. They are not compiled or packaged by this project — consume them as a dependency in your target service.

To regenerate after editing the spec:

```bash
mvn generate-sources
```

## License

This project is licensed under the **GNU Affero General Public License v3.0 (AGPL-3.0)**. See [LICENSE](LICENSE) for the full text.
