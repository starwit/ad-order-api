package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.starwit.adorder.model.GeoPoint;
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
 * A single waypoint in an order&#39;s route
 */

@Schema(name = "Stop", description = "A single waypoint in an order's route")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T21:10:51.076418484+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class Stop {

  private @Nullable UUID stopId;

  private GeoPoint location;

  private @Nullable Integer sequenceNumber;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime scheduledArrival;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PENDING("pending"),
    
    REACHED("reached"),
    
    SKIPPED("skipped");

    private final String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status = StatusEnum.PENDING;

  public Stop() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Stop(GeoPoint location) {
    this.location = location;
  }

  public Stop stopId(@Nullable UUID stopId) {
    this.stopId = stopId;
    return this;
  }

  /**
   * Assigned by the AD stack when the stop is added
   * @return stopId
   */
  @Valid 
  @Schema(name = "stopId", description = "Assigned by the AD stack when the stop is added", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("stopId")
  public @Nullable UUID getStopId() {
    return stopId;
  }

  @JsonProperty("stopId")
  public void setStopId(@Nullable UUID stopId) {
    this.stopId = stopId;
  }

  public Stop location(GeoPoint location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   */
  @NotNull @Valid 
  @Schema(name = "location", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("location")
  public GeoPoint getLocation() {
    return location;
  }

  @JsonProperty("location")
  public void setLocation(GeoPoint location) {
    this.location = location;
  }

  public Stop sequenceNumber(@Nullable Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
    return this;
  }

  /**
   * Position of this stop in the route. 0 is the first stop after departure. The AD stack may reorder stops if not supplied. 
   * minimum: 0
   * @return sequenceNumber
   */
  @Min(value = 0) 
  @Schema(name = "sequenceNumber", description = "Position of this stop in the route. 0 is the first stop after departure. The AD stack may reorder stops if not supplied. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sequenceNumber")
  public @Nullable Integer getSequenceNumber() {
    return sequenceNumber;
  }

  @JsonProperty("sequenceNumber")
  public void setSequenceNumber(@Nullable Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  public Stop scheduledArrival(@Nullable OffsetDateTime scheduledArrival) {
    this.scheduledArrival = scheduledArrival;
    return this;
  }

  /**
   * Optional target arrival time at this stop
   * @return scheduledArrival
   */
  @Valid 
  @Schema(name = "scheduledArrival", description = "Optional target arrival time at this stop", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("scheduledArrival")
  public @Nullable OffsetDateTime getScheduledArrival() {
    return scheduledArrival;
  }

  @JsonProperty("scheduledArrival")
  public void setScheduledArrival(@Nullable OffsetDateTime scheduledArrival) {
    this.scheduledArrival = scheduledArrival;
  }

  public Stop status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stop stop = (Stop) o;
    return Objects.equals(this.stopId, stop.stopId) &&
        Objects.equals(this.location, stop.location) &&
        Objects.equals(this.sequenceNumber, stop.sequenceNumber) &&
        Objects.equals(this.scheduledArrival, stop.scheduledArrival) &&
        Objects.equals(this.status, stop.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stopId, location, sequenceNumber, scheduledArrival, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stop {\n");
    sb.append("    stopId: ").append(toIndentedString(stopId)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    sequenceNumber: ").append(toIndentedString(sequenceNumber)).append("\n");
    sb.append("    scheduledArrival: ").append(toIndentedString(scheduledArrival)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

