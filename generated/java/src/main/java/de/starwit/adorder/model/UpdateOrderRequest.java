package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.starwit.adorder.model.DriveConstraints;
import de.starwit.adorder.model.Stop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Partial update to a ride order. Only supplied fields are modified. At least one field must be present. 
 */

@Schema(name = "UpdateOrderRequest", description = "Partial update to a ride order. Only supplied fields are modified. At least one field must be present. ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T21:10:51.076418484+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class UpdateOrderRequest {

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

  private @Nullable PriorityEnum priority;

  private @Nullable DriveConstraints constraints;

  public UpdateOrderRequest stops(List<@Valid Stop> stops) {
    this.stops = stops;
    return this;
  }

  public UpdateOrderRequest addStopsItem(Stop stopsItem) {
    if (this.stops == null) {
      this.stops = new ArrayList<>();
    }
    this.stops.add(stopsItem);
    return this;
  }

  /**
   * Replacement stop list. For in_progress orders only appending new stops (higher sequence numbers) is permitted. 
   * @return stops
   */
  @Valid @Size(min = 1) 
  @Schema(name = "stops", description = "Replacement stop list. For in_progress orders only appending new stops (higher sequence numbers) is permitted. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("stops")
  public List<@Valid Stop> getStops() {
    return stops;
  }

  @JsonProperty("stops")
  public void setStops(List<@Valid Stop> stops) {
    this.stops = stops;
  }

  public UpdateOrderRequest priority(@Nullable PriorityEnum priority) {
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

  public UpdateOrderRequest constraints(@Nullable DriveConstraints constraints) {
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
    UpdateOrderRequest updateOrderRequest = (UpdateOrderRequest) o;
    return Objects.equals(this.stops, updateOrderRequest.stops) &&
        Objects.equals(this.priority, updateOrderRequest.priority) &&
        Objects.equals(this.constraints, updateOrderRequest.constraints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stops, priority, constraints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateOrderRequest {\n");
    sb.append("    stops: ").append(toIndentedString(stops)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
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

