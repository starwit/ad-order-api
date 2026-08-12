package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Current battery / energy storage status
 */

@Schema(name = "BatteryStatus", description = "Current battery / energy storage status")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-07T23:24:20.986589197+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class BatteryStatus {

  private Double stateOfChargePercent;

  private @Nullable Double estimatedRangeKm;

  private @Nullable Boolean charging;

  private @Nullable Double healthPercent;

  public BatteryStatus() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BatteryStatus(Double stateOfChargePercent) {
    this.stateOfChargePercent = stateOfChargePercent;
  }

  public BatteryStatus stateOfChargePercent(Double stateOfChargePercent) {
    this.stateOfChargePercent = stateOfChargePercent;
    return this;
  }

  /**
   * State of charge as a percentage
   * minimum: 0
   * maximum: 100
   * @return stateOfChargePercent
   */
  @NotNull @DecimalMin(value = "0") @DecimalMax(value = "100") 
  @Schema(name = "stateOfChargePercent", example = "73.4", description = "State of charge as a percentage", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("stateOfChargePercent")
  public Double getStateOfChargePercent() {
    return stateOfChargePercent;
  }

  @JsonProperty("stateOfChargePercent")
  public void setStateOfChargePercent(Double stateOfChargePercent) {
    this.stateOfChargePercent = stateOfChargePercent;
  }

  public BatteryStatus estimatedRangeKm(@Nullable Double estimatedRangeKm) {
    this.estimatedRangeKm = estimatedRangeKm;
    return this;
  }

  /**
   * Estimated remaining range in kilometres
   * minimum: 0
   * @return estimatedRangeKm
   */
  @DecimalMin(value = "0") 
  @Schema(name = "estimatedRangeKm", example = "142.0", description = "Estimated remaining range in kilometres", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("estimatedRangeKm")
  public @Nullable Double getEstimatedRangeKm() {
    return estimatedRangeKm;
  }

  @JsonProperty("estimatedRangeKm")
  public void setEstimatedRangeKm(@Nullable Double estimatedRangeKm) {
    this.estimatedRangeKm = estimatedRangeKm;
  }

  public BatteryStatus charging(@Nullable Boolean charging) {
    this.charging = charging;
    return this;
  }

  /**
   * Whether the vehicle is currently charging
   * @return charging
   */
  
  @Schema(name = "charging", example = "false", description = "Whether the vehicle is currently charging", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("charging")
  public @Nullable Boolean getCharging() {
    return charging;
  }

  @JsonProperty("charging")
  public void setCharging(@Nullable Boolean charging) {
    this.charging = charging;
  }

  public BatteryStatus healthPercent(@Nullable Double healthPercent) {
    this.healthPercent = healthPercent;
    return this;
  }

  /**
   * Battery health as a percentage of design capacity
   * minimum: 0
   * maximum: 100
   * @return healthPercent
   */
  @DecimalMin(value = "0") @DecimalMax(value = "100") 
  @Schema(name = "healthPercent", example = "96.1", description = "Battery health as a percentage of design capacity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("healthPercent")
  public @Nullable Double getHealthPercent() {
    return healthPercent;
  }

  @JsonProperty("healthPercent")
  public void setHealthPercent(@Nullable Double healthPercent) {
    this.healthPercent = healthPercent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatteryStatus batteryStatus = (BatteryStatus) o;
    return Objects.equals(this.stateOfChargePercent, batteryStatus.stateOfChargePercent) &&
        Objects.equals(this.estimatedRangeKm, batteryStatus.estimatedRangeKm) &&
        Objects.equals(this.charging, batteryStatus.charging) &&
        Objects.equals(this.healthPercent, batteryStatus.healthPercent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateOfChargePercent, estimatedRangeKm, charging, healthPercent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatteryStatus {\n");
    sb.append("    stateOfChargePercent: ").append(toIndentedString(stateOfChargePercent)).append("\n");
    sb.append("    estimatedRangeKm: ").append(toIndentedString(estimatedRangeKm)).append("\n");
    sb.append("    charging: ").append(toIndentedString(charging)).append("\n");
    sb.append("    healthPercent: ").append(toIndentedString(healthPercent)).append("\n");
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

