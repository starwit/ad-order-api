package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.starwit.adorder.model.DriveConstraints;
import de.starwit.adorder.model.OrderSource;
import de.starwit.adorder.model.Stop;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Payload to create a new ride order
 */

@Schema(name = "CreateOrderRequest", description = "Payload to create a new ride order")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T21:10:51.076418484+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class CreateOrderRequest {

  private OrderSource source;

  private List<@Valid Stop> stops = new ArrayList<>();

  /**
   * Gets or Sets priority
   */
  public enum PriorityEnum {
    NORMAL("normal"),
    
    HIGH("high");

    private final String value;

    PriorityEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PriorityEnum fromValue(String value) {
      for (PriorityEnum b : PriorityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private PriorityEnum priority = PriorityEnum.NORMAL;

  private @Nullable String clientOrderId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime notBeforeTimestamp;

  private @Nullable DriveConstraints constraints;

  public CreateOrderRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateOrderRequest(OrderSource source, List<@Valid Stop> stops) {
    this.source = source;
    this.stops = stops;
  }

  public CreateOrderRequest source(OrderSource source) {
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
   */
  @NotNull @Valid 
  @Schema(name = "source", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("source")
  public OrderSource getSource() {
    return source;
  }

  @JsonProperty("source")
  public void setSource(OrderSource source) {
    this.source = source;
  }

  public CreateOrderRequest stops(List<@Valid Stop> stops) {
    this.stops = stops;
    return this;
  }

  public CreateOrderRequest addStopsItem(Stop stopsItem) {
    if (this.stops == null) {
      this.stops = new ArrayList<>();
    }
    this.stops.add(stopsItem);
    return this;
  }

  /**
   * Ordered list of stops the vehicle shall visit. Must contain at least one stop (the final destination). 
   * @return stops
   */
  @NotNull @Valid @Size(min = 1) 
  @Schema(name = "stops", description = "Ordered list of stops the vehicle shall visit. Must contain at least one stop (the final destination). ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("stops")
  public List<@Valid Stop> getStops() {
    return stops;
  }

  @JsonProperty("stops")
  public void setStops(List<@Valid Stop> stops) {
    this.stops = stops;
  }

  public CreateOrderRequest priority(PriorityEnum priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Get priority
   * @return priority
   */
  
  @Schema(name = "priority", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("priority")
  public PriorityEnum getPriority() {
    return priority;
  }

  @JsonProperty("priority")
  public void setPriority(PriorityEnum priority) {
    this.priority = priority;
  }

  public CreateOrderRequest clientOrderId(@Nullable String clientOrderId) {
    this.clientOrderId = clientOrderId;
    return this;
  }

  /**
   * Optional idempotency key / external system reference
   * @return clientOrderId
   */
  
  @Schema(name = "clientOrderId", example = "fleet-job-88421", description = "Optional idempotency key / external system reference", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientOrderId")
  public @Nullable String getClientOrderId() {
    return clientOrderId;
  }

  @JsonProperty("clientOrderId")
  public void setClientOrderId(@Nullable String clientOrderId) {
    this.clientOrderId = clientOrderId;
  }

  public CreateOrderRequest notBeforeTimestamp(@Nullable OffsetDateTime notBeforeTimestamp) {
    this.notBeforeTimestamp = notBeforeTimestamp;
    return this;
  }

  /**
   * Earliest time at which the AD stack should begin executing the order
   * @return notBeforeTimestamp
   */
  @Valid 
  @Schema(name = "notBeforeTimestamp", description = "Earliest time at which the AD stack should begin executing the order", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("notBeforeTimestamp")
  public @Nullable OffsetDateTime getNotBeforeTimestamp() {
    return notBeforeTimestamp;
  }

  @JsonProperty("notBeforeTimestamp")
  public void setNotBeforeTimestamp(@Nullable OffsetDateTime notBeforeTimestamp) {
    this.notBeforeTimestamp = notBeforeTimestamp;
  }

  public CreateOrderRequest constraints(@Nullable DriveConstraints constraints) {
    this.constraints = constraints;
    return this;
  }

  /**
   * Get constraints
   * @return constraints
   */
  @Valid 
  @Schema(name = "constraints", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("constraints")
  public @Nullable DriveConstraints getConstraints() {
    return constraints;
  }

  @JsonProperty("constraints")
  public void setConstraints(@Nullable DriveConstraints constraints) {
    this.constraints = constraints;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateOrderRequest createOrderRequest = (CreateOrderRequest) o;
    return Objects.equals(this.source, createOrderRequest.source) &&
        Objects.equals(this.stops, createOrderRequest.stops) &&
        Objects.equals(this.priority, createOrderRequest.priority) &&
        Objects.equals(this.clientOrderId, createOrderRequest.clientOrderId) &&
        Objects.equals(this.notBeforeTimestamp, createOrderRequest.notBeforeTimestamp) &&
        Objects.equals(this.constraints, createOrderRequest.constraints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, stops, priority, clientOrderId, notBeforeTimestamp, constraints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateOrderRequest {\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    stops: ").append(toIndentedString(stops)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    clientOrderId: ").append(toIndentedString(clientOrderId)).append("\n");
    sb.append("    notBeforeTimestamp: ").append(toIndentedString(notBeforeTimestamp)).append("\n");
    sb.append("    constraints: ").append(toIndentedString(constraints)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

