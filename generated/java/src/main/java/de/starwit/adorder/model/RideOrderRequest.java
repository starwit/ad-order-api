package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.starwit.adorder.model.GeoPoint;
import de.starwit.adorder.model.OrderSource;
import de.starwit.adorder.model.RideOrderRequestConstraints;
import java.time.OffsetDateTime;
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
 * Payload to request a new ride order
 */

@Schema(name = "RideOrderRequest", description = "Payload to request a new ride order")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-01T11:42:33.323681150+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class RideOrderRequest {

  private OrderSource source;

  private GeoPoint target;

  /**
   * Optional priority hint, relevant if a queuing mechanism is added later
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

  private @Nullable RideOrderRequestConstraints constraints;

  public RideOrderRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RideOrderRequest(OrderSource source, GeoPoint target) {
    this.source = source;
    this.target = target;
  }

  public RideOrderRequest source(OrderSource source) {
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

  public RideOrderRequest target(GeoPoint target) {
    this.target = target;
    return this;
  }

  /**
   * Destination the AD stack should drive to. Current position is taken from the vehicle's live state at acceptance time, not supplied by the client.
   * @return target
   */
  @NotNull @Valid 
  @Schema(name = "target", description = "Destination the AD stack should drive to. Current position is taken from the vehicle's live state at acceptance time, not supplied by the client.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("target")
  public GeoPoint getTarget() {
    return target;
  }

  @JsonProperty("target")
  public void setTarget(GeoPoint target) {
    this.target = target;
  }

  public RideOrderRequest priority(PriorityEnum priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Optional priority hint, relevant if a queuing mechanism is added later
   * @return priority
   */
  
  @Schema(name = "priority", description = "Optional priority hint, relevant if a queuing mechanism is added later", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("priority")
  public PriorityEnum getPriority() {
    return priority;
  }

  @JsonProperty("priority")
  public void setPriority(PriorityEnum priority) {
    this.priority = priority;
  }

  public RideOrderRequest clientOrderId(@Nullable String clientOrderId) {
    this.clientOrderId = clientOrderId;
    return this;
  }

  /**
   * Optional idempotency key / client-side reference for correlating with external systems (e.g. a backend job ID)
   * @return clientOrderId
   */
  
  @Schema(name = "clientOrderId", example = "fleet-job-88421", description = "Optional idempotency key / client-side reference for correlating with external systems (e.g. a backend job ID)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientOrderId")
  public @Nullable String getClientOrderId() {
    return clientOrderId;
  }

  @JsonProperty("clientOrderId")
  public void setClientOrderId(@Nullable String clientOrderId) {
    this.clientOrderId = clientOrderId;
  }

  public RideOrderRequest notBeforeTimestamp(@Nullable OffsetDateTime notBeforeTimestamp) {
    this.notBeforeTimestamp = notBeforeTimestamp;
    return this;
  }

  /**
   * Optional earliest time at which the AD stack should begin executing the order
   * @return notBeforeTimestamp
   */
  @Valid 
  @Schema(name = "notBeforeTimestamp", description = "Optional earliest time at which the AD stack should begin executing the order", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("notBeforeTimestamp")
  public @Nullable OffsetDateTime getNotBeforeTimestamp() {
    return notBeforeTimestamp;
  }

  @JsonProperty("notBeforeTimestamp")
  public void setNotBeforeTimestamp(@Nullable OffsetDateTime notBeforeTimestamp) {
    this.notBeforeTimestamp = notBeforeTimestamp;
  }

  public RideOrderRequest constraints(@Nullable RideOrderRequestConstraints constraints) {
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
  public @Nullable RideOrderRequestConstraints getConstraints() {
    return constraints;
  }

  @JsonProperty("constraints")
  public void setConstraints(@Nullable RideOrderRequestConstraints constraints) {
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
    RideOrderRequest rideOrderRequest = (RideOrderRequest) o;
    return Objects.equals(this.source, rideOrderRequest.source) &&
        Objects.equals(this.target, rideOrderRequest.target) &&
        Objects.equals(this.priority, rideOrderRequest.priority) &&
        Objects.equals(this.clientOrderId, rideOrderRequest.clientOrderId) &&
        Objects.equals(this.notBeforeTimestamp, rideOrderRequest.notBeforeTimestamp) &&
        Objects.equals(this.constraints, rideOrderRequest.constraints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, target, priority, clientOrderId, notBeforeTimestamp, constraints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RideOrderRequest {\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
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

