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
 * Current motion state of the vehicle
 */

@Schema(name = "VehicleKinematics", description = "Current motion state of the vehicle")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T21:10:51.076418484+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class VehicleKinematics {

  private Double speedKph;

  private Double headingDegrees;

  private @Nullable Double accelerationMps2;

  public VehicleKinematics() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public VehicleKinematics(Double speedKph, Double headingDegrees) {
    this.speedKph = speedKph;
    this.headingDegrees = headingDegrees;
  }

  public VehicleKinematics speedKph(Double speedKph) {
    this.speedKph = speedKph;
    return this;
  }

  /**
   * Current speed in km/h
   * minimum: 0
   * @return speedKph
   */
  @NotNull @DecimalMin(value = "0") 
  @Schema(name = "speedKph", example = "24.5", description = "Current speed in km/h", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("speedKph")
  public Double getSpeedKph() {
    return speedKph;
  }

  @JsonProperty("speedKph")
  public void setSpeedKph(Double speedKph) {
    this.speedKph = speedKph;
  }

  public VehicleKinematics headingDegrees(Double headingDegrees) {
    this.headingDegrees = headingDegrees;
    return this;
  }

  /**
   * Current compass heading in degrees (0 = north)
   * minimum: 0
   * maximum: 360
   * @return headingDegrees
   */
  @NotNull @DecimalMin(value = "0") @DecimalMax(value = "360") 
  @Schema(name = "headingDegrees", example = "90.0", description = "Current compass heading in degrees (0 = north)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("headingDegrees")
  public Double getHeadingDegrees() {
    return headingDegrees;
  }

  @JsonProperty("headingDegrees")
  public void setHeadingDegrees(Double headingDegrees) {
    this.headingDegrees = headingDegrees;
  }

  public VehicleKinematics accelerationMps2(@Nullable Double accelerationMps2) {
    this.accelerationMps2 = accelerationMps2;
    return this;
  }

  /**
   * Current longitudinal acceleration in m/s²
   * @return accelerationMps2
   */
  
  @Schema(name = "accelerationMps2", example = "0.3", description = "Current longitudinal acceleration in m/s²", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accelerationMps2")
  public @Nullable Double getAccelerationMps2() {
    return accelerationMps2;
  }

  @JsonProperty("accelerationMps2")
  public void setAccelerationMps2(@Nullable Double accelerationMps2) {
    this.accelerationMps2 = accelerationMps2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleKinematics vehicleKinematics = (VehicleKinematics) o;
    return Objects.equals(this.speedKph, vehicleKinematics.speedKph) &&
        Objects.equals(this.headingDegrees, vehicleKinematics.headingDegrees) &&
        Objects.equals(this.accelerationMps2, vehicleKinematics.accelerationMps2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(speedKph, headingDegrees, accelerationMps2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleKinematics {\n");
    sb.append("    speedKph: ").append(toIndentedString(speedKph)).append("\n");
    sb.append("    headingDegrees: ").append(toIndentedString(headingDegrees)).append("\n");
    sb.append("    accelerationMps2: ").append(toIndentedString(accelerationMps2)).append("\n");
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

