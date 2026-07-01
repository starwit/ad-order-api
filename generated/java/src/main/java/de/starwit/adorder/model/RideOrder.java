package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.starwit.adorder.model.GeoPoint;
import de.starwit.adorder.model.OrderSource;
import de.starwit.adorder.model.OrderStatus;
import de.starwit.adorder.model.RejectionReason;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
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
 * A ride order and its current execution state
 */

@Schema(name = "RideOrder", description = "A ride order and its current execution state")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-01T11:42:33.323681150+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class RideOrder {

  private UUID orderId;

  private @Nullable String clientOrderId;

  private OrderSource source;

  private GeoPoint target;

  private @Nullable GeoPoint startPosition;

  private OrderStatus status;

  private @Nullable RejectionReason rejectionReason;

  private @Nullable String statusDetail;

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

  private @Nullable PriorityEnum priority;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime acceptedAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startedAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime completedAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime estimatedArrival;

  private @Nullable BigDecimal distanceRemainingMeters;

  public RideOrder() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RideOrder(UUID orderId, OrderSource source, GeoPoint target, OrderStatus status, OffsetDateTime createdAt) {
    this.orderId = orderId;
    this.source = source;
    this.target = target;
    this.status = status;
    this.createdAt = createdAt;
  }

  public RideOrder orderId(UUID orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
   */
  @NotNull @Valid 
  @Schema(name = "orderId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("orderId")
  public UUID getOrderId() {
    return orderId;
  }

  @JsonProperty("orderId")
  public void setOrderId(UUID orderId) {
    this.orderId = orderId;
  }

  public RideOrder clientOrderId(@Nullable String clientOrderId) {
    this.clientOrderId = clientOrderId;
    return this;
  }

  /**
   * Get clientOrderId
   * @return clientOrderId
   */
  
  @Schema(name = "clientOrderId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientOrderId")
  public @Nullable String getClientOrderId() {
    return clientOrderId;
  }

  @JsonProperty("clientOrderId")
  public void setClientOrderId(@Nullable String clientOrderId) {
    this.clientOrderId = clientOrderId;
  }

  public RideOrder source(OrderSource source) {
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

  public RideOrder target(GeoPoint target) {
    this.target = target;
    return this;
  }

  /**
   * Get target
   * @return target
   */
  @NotNull @Valid 
  @Schema(name = "target", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("target")
  public GeoPoint getTarget() {
    return target;
  }

  @JsonProperty("target")
  public void setTarget(GeoPoint target) {
    this.target = target;
  }

  public RideOrder startPosition(@Nullable GeoPoint startPosition) {
    this.startPosition = startPosition;
    return this;
  }

  /**
   * Position of the vehicle at the time the order was accepted, recorded by the AD stack
   * @return startPosition
   */
  @Valid 
  @Schema(name = "startPosition", description = "Position of the vehicle at the time the order was accepted, recorded by the AD stack", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startPosition")
  public @Nullable GeoPoint getStartPosition() {
    return startPosition;
  }

  @JsonProperty("startPosition")
  public void setStartPosition(@Nullable GeoPoint startPosition) {
    this.startPosition = startPosition;
  }

  public RideOrder status(OrderStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @NotNull @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public OrderStatus getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public RideOrder rejectionReason(@Nullable RejectionReason rejectionReason) {
    this.rejectionReason = rejectionReason;
    return this;
  }

  /**
   * Get rejectionReason
   * @return rejectionReason
   */
  @Valid 
  @Schema(name = "rejectionReason", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rejectionReason")
  public @Nullable RejectionReason getRejectionReason() {
    return rejectionReason;
  }

  @JsonProperty("rejectionReason")
  public void setRejectionReason(@Nullable RejectionReason rejectionReason) {
    this.rejectionReason = rejectionReason;
  }

  public RideOrder statusDetail(@Nullable String statusDetail) {
    this.statusDetail = statusDetail;
    return this;
  }

  /**
   * Free-text detail, e.g. fault description when status is `failed`
   * @return statusDetail
   */
  
  @Schema(name = "statusDetail", description = "Free-text detail, e.g. fault description when status is `failed`", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statusDetail")
  public @Nullable String getStatusDetail() {
    return statusDetail;
  }

  @JsonProperty("statusDetail")
  public void setStatusDetail(@Nullable String statusDetail) {
    this.statusDetail = statusDetail;
  }

  public RideOrder priority(@Nullable PriorityEnum priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Get priority
   * @return priority
   */
  
  @Schema(name = "priority", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("priority")
  public @Nullable PriorityEnum getPriority() {
    return priority;
  }

  @JsonProperty("priority")
  public void setPriority(@Nullable PriorityEnum priority) {
    this.priority = priority;
  }

  public RideOrder createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
   */
  @NotNull @Valid 
  @Schema(name = "createdAt", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("createdAt")
  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public RideOrder acceptedAt(@Nullable OffsetDateTime acceptedAt) {
    this.acceptedAt = acceptedAt;
    return this;
  }

  /**
   * Get acceptedAt
   * @return acceptedAt
   */
  @Valid 
  @Schema(name = "acceptedAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("acceptedAt")
  public @Nullable OffsetDateTime getAcceptedAt() {
    return acceptedAt;
  }

  @JsonProperty("acceptedAt")
  public void setAcceptedAt(@Nullable OffsetDateTime acceptedAt) {
    this.acceptedAt = acceptedAt;
  }

  public RideOrder startedAt(@Nullable OffsetDateTime startedAt) {
    this.startedAt = startedAt;
    return this;
  }

  /**
   * When the AD stack began physically executing the drive
   * @return startedAt
   */
  @Valid 
  @Schema(name = "startedAt", description = "When the AD stack began physically executing the drive", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startedAt")
  public @Nullable OffsetDateTime getStartedAt() {
    return startedAt;
  }

  @JsonProperty("startedAt")
  public void setStartedAt(@Nullable OffsetDateTime startedAt) {
    this.startedAt = startedAt;
  }

  public RideOrder completedAt(@Nullable OffsetDateTime completedAt) {
    this.completedAt = completedAt;
    return this;
  }

  /**
   * Get completedAt
   * @return completedAt
   */
  @Valid 
  @Schema(name = "completedAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("completedAt")
  public @Nullable OffsetDateTime getCompletedAt() {
    return completedAt;
  }

  @JsonProperty("completedAt")
  public void setCompletedAt(@Nullable OffsetDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public RideOrder estimatedArrival(@Nullable OffsetDateTime estimatedArrival) {
    this.estimatedArrival = estimatedArrival;
    return this;
  }

  /**
   * AD stack's current ETA estimate, updated while in_progress
   * @return estimatedArrival
   */
  @Valid 
  @Schema(name = "estimatedArrival", description = "AD stack's current ETA estimate, updated while in_progress", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("estimatedArrival")
  public @Nullable OffsetDateTime getEstimatedArrival() {
    return estimatedArrival;
  }

  @JsonProperty("estimatedArrival")
  public void setEstimatedArrival(@Nullable OffsetDateTime estimatedArrival) {
    this.estimatedArrival = estimatedArrival;
  }

  public RideOrder distanceRemainingMeters(@Nullable BigDecimal distanceRemainingMeters) {
    this.distanceRemainingMeters = distanceRemainingMeters;
    return this;
  }

  /**
   * Remaining distance estimate while in_progress
   * @return distanceRemainingMeters
   */
  @Valid 
  @Schema(name = "distanceRemainingMeters", description = "Remaining distance estimate while in_progress", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distanceRemainingMeters")
  public @Nullable BigDecimal getDistanceRemainingMeters() {
    return distanceRemainingMeters;
  }

  @JsonProperty("distanceRemainingMeters")
  public void setDistanceRemainingMeters(@Nullable BigDecimal distanceRemainingMeters) {
    this.distanceRemainingMeters = distanceRemainingMeters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RideOrder rideOrder = (RideOrder) o;
    return Objects.equals(this.orderId, rideOrder.orderId) &&
        Objects.equals(this.clientOrderId, rideOrder.clientOrderId) &&
        Objects.equals(this.source, rideOrder.source) &&
        Objects.equals(this.target, rideOrder.target) &&
        Objects.equals(this.startPosition, rideOrder.startPosition) &&
        Objects.equals(this.status, rideOrder.status) &&
        Objects.equals(this.rejectionReason, rideOrder.rejectionReason) &&
        Objects.equals(this.statusDetail, rideOrder.statusDetail) &&
        Objects.equals(this.priority, rideOrder.priority) &&
        Objects.equals(this.createdAt, rideOrder.createdAt) &&
        Objects.equals(this.acceptedAt, rideOrder.acceptedAt) &&
        Objects.equals(this.startedAt, rideOrder.startedAt) &&
        Objects.equals(this.completedAt, rideOrder.completedAt) &&
        Objects.equals(this.estimatedArrival, rideOrder.estimatedArrival) &&
        Objects.equals(this.distanceRemainingMeters, rideOrder.distanceRemainingMeters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, clientOrderId, source, target, startPosition, status, rejectionReason, statusDetail, priority, createdAt, acceptedAt, startedAt, completedAt, estimatedArrival, distanceRemainingMeters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RideOrder {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    clientOrderId: ").append(toIndentedString(clientOrderId)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    startPosition: ").append(toIndentedString(startPosition)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    rejectionReason: ").append(toIndentedString(rejectionReason)).append("\n");
    sb.append("    statusDetail: ").append(toIndentedString(statusDetail)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    acceptedAt: ").append(toIndentedString(acceptedAt)).append("\n");
    sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
    sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
    sb.append("    estimatedArrival: ").append(toIndentedString(estimatedArrival)).append("\n");
    sb.append("    distanceRemainingMeters: ").append(toIndentedString(distanceRemainingMeters)).append("\n");
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

