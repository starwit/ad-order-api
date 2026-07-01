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
 * VehicleState
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-01T11:42:33.323681150+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class VehicleState {

  private GeoPoint position;

  private Boolean adStackReady;

  /**
   * Gets or Sets adStackMode
   */
  public enum AdStackModeEnum {
    IDLE("idle"),
    
    EXECUTING_ORDER("executing_order"),
    
    FAULT("fault"),
    
    MANUAL_OVERRIDE("manual_override"),
    
    INITIALIZING("initializing");

    private final String value;

    AdStackModeEnum(String value) {
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
    public static AdStackModeEnum fromValue(String value) {
      for (AdStackModeEnum b : AdStackModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable AdStackModeEnum adStackMode;

  private @Nullable UUID activeOrderId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  public VehicleState() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public VehicleState(GeoPoint position, Boolean adStackReady, OffsetDateTime timestamp) {
    this.position = position;
    this.adStackReady = adStackReady;
    this.timestamp = timestamp;
  }

  public VehicleState position(GeoPoint position) {
    this.position = position;
    return this;
  }

  /**
   * Get position
   * @return position
   */
  @NotNull @Valid 
  @Schema(name = "position", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("position")
  public GeoPoint getPosition() {
    return position;
  }

  @JsonProperty("position")
  public void setPosition(GeoPoint position) {
    this.position = position;
  }

  public VehicleState adStackReady(Boolean adStackReady) {
    this.adStackReady = adStackReady;
    return this;
  }

  /**
   * Whether the AD stack is currently able to accept new orders
   * @return adStackReady
   */
  @NotNull 
  @Schema(name = "adStackReady", description = "Whether the AD stack is currently able to accept new orders", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("adStackReady")
  public Boolean getAdStackReady() {
    return adStackReady;
  }

  @JsonProperty("adStackReady")
  public void setAdStackReady(Boolean adStackReady) {
    this.adStackReady = adStackReady;
  }

  public VehicleState adStackMode(@Nullable AdStackModeEnum adStackMode) {
    this.adStackMode = adStackMode;
    return this;
  }

  /**
   * Get adStackMode
   * @return adStackMode
   */
  
  @Schema(name = "adStackMode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("adStackMode")
  public @Nullable AdStackModeEnum getAdStackMode() {
    return adStackMode;
  }

  @JsonProperty("adStackMode")
  public void setAdStackMode(@Nullable AdStackModeEnum adStackMode) {
    this.adStackMode = adStackMode;
  }

  public VehicleState activeOrderId(@Nullable UUID activeOrderId) {
    this.activeOrderId = activeOrderId;
    return this;
  }

  /**
   * ID of the order currently being executed, if any
   * @return activeOrderId
   */
  @Valid 
  @Schema(name = "activeOrderId", description = "ID of the order currently being executed, if any", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("activeOrderId")
  public @Nullable UUID getActiveOrderId() {
    return activeOrderId;
  }

  @JsonProperty("activeOrderId")
  public void setActiveOrderId(@Nullable UUID activeOrderId) {
    this.activeOrderId = activeOrderId;
  }

  public VehicleState timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
   */
  @NotNull @Valid 
  @Schema(name = "timestamp", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  @JsonProperty("timestamp")
  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleState vehicleState = (VehicleState) o;
    return Objects.equals(this.position, vehicleState.position) &&
        Objects.equals(this.adStackReady, vehicleState.adStackReady) &&
        Objects.equals(this.adStackMode, vehicleState.adStackMode) &&
        Objects.equals(this.activeOrderId, vehicleState.activeOrderId) &&
        Objects.equals(this.timestamp, vehicleState.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, adStackReady, adStackMode, activeOrderId, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleState {\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    adStackReady: ").append(toIndentedString(adStackReady)).append("\n");
    sb.append("    adStackMode: ").append(toIndentedString(adStackMode)).append("\n");
    sb.append("    activeOrderId: ").append(toIndentedString(activeOrderId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

