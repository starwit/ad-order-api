package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.starwit.adorder.model.AdStackMode;
import de.starwit.adorder.model.BatteryStatus;
import de.starwit.adorder.model.GeoPoint;
import de.starwit.adorder.model.VehicleKinematics;
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
 * Complete snapshot of the vehicle&#39;s current status. Published on the MQTT /vehicle/status topic and also returned by the REST status endpoint. 
 */

@Schema(name = "VehicleStatus", description = "Complete snapshot of the vehicle's current status. Published on the MQTT /vehicle/status topic and also returned by the REST status endpoint. ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T21:10:51.076418484+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class VehicleStatus {

  private AdStackMode adStackMode;

  private @Nullable Boolean adStackReady;

  private @Nullable UUID activeOrderId;

  private VehicleKinematics kinematics;

  private GeoPoint position;

  private BatteryStatus battery;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  public VehicleStatus() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public VehicleStatus(AdStackMode adStackMode, VehicleKinematics kinematics, GeoPoint position, BatteryStatus battery, OffsetDateTime timestamp) {
    this.adStackMode = adStackMode;
    this.kinematics = kinematics;
    this.position = position;
    this.battery = battery;
    this.timestamp = timestamp;
  }

  public VehicleStatus adStackMode(AdStackMode adStackMode) {
    this.adStackMode = adStackMode;
    return this;
  }

  /**
   * Get adStackMode
   * @return adStackMode
   */
  @NotNull @Valid 
  @Schema(name = "adStackMode", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("adStackMode")
  public AdStackMode getAdStackMode() {
    return adStackMode;
  }

  @JsonProperty("adStackMode")
  public void setAdStackMode(AdStackMode adStackMode) {
    this.adStackMode = adStackMode;
  }

  public VehicleStatus adStackReady(@Nullable Boolean adStackReady) {
    this.adStackReady = adStackReady;
    return this;
  }

  /**
   * Whether the AD stack can currently accept new orders
   * @return adStackReady
   */
  
  @Schema(name = "adStackReady", description = "Whether the AD stack can currently accept new orders", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("adStackReady")
  public @Nullable Boolean getAdStackReady() {
    return adStackReady;
  }

  @JsonProperty("adStackReady")
  public void setAdStackReady(@Nullable Boolean adStackReady) {
    this.adStackReady = adStackReady;
  }

  public VehicleStatus activeOrderId(@Nullable UUID activeOrderId) {
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

  public VehicleStatus kinematics(VehicleKinematics kinematics) {
    this.kinematics = kinematics;
    return this;
  }

  /**
   * Get kinematics
   * @return kinematics
   */
  @NotNull @Valid 
  @Schema(name = "kinematics", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("kinematics")
  public VehicleKinematics getKinematics() {
    return kinematics;
  }

  @JsonProperty("kinematics")
  public void setKinematics(VehicleKinematics kinematics) {
    this.kinematics = kinematics;
  }

  public VehicleStatus position(GeoPoint position) {
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

  public VehicleStatus battery(BatteryStatus battery) {
    this.battery = battery;
    return this;
  }

  /**
   * Get battery
   * @return battery
   */
  @NotNull @Valid 
  @Schema(name = "battery", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("battery")
  public BatteryStatus getBattery() {
    return battery;
  }

  @JsonProperty("battery")
  public void setBattery(BatteryStatus battery) {
    this.battery = battery;
  }

  public VehicleStatus timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Time at which this snapshot was captured
   * @return timestamp
   */
  @NotNull @Valid 
  @Schema(name = "timestamp", description = "Time at which this snapshot was captured", requiredMode = Schema.RequiredMode.REQUIRED)
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
    VehicleStatus vehicleStatus = (VehicleStatus) o;
    return Objects.equals(this.adStackMode, vehicleStatus.adStackMode) &&
        Objects.equals(this.adStackReady, vehicleStatus.adStackReady) &&
        Objects.equals(this.activeOrderId, vehicleStatus.activeOrderId) &&
        Objects.equals(this.kinematics, vehicleStatus.kinematics) &&
        Objects.equals(this.position, vehicleStatus.position) &&
        Objects.equals(this.battery, vehicleStatus.battery) &&
        Objects.equals(this.timestamp, vehicleStatus.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adStackMode, adStackReady, activeOrderId, kinematics, position, battery, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleStatus {\n");
    sb.append("    adStackMode: ").append(toIndentedString(adStackMode)).append("\n");
    sb.append("    adStackReady: ").append(toIndentedString(adStackReady)).append("\n");
    sb.append("    activeOrderId: ").append(toIndentedString(activeOrderId)).append("\n");
    sb.append("    kinematics: ").append(toIndentedString(kinematics)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    battery: ").append(toIndentedString(battery)).append("\n");
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

