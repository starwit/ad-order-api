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
 * A geographic position with optional heading
 */

@Schema(name = "GeoPoint", description = "A geographic position with optional heading")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-07T23:24:20.986589197+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class GeoPoint {

  private Double latitude;

  private Double longitude;

  private @Nullable Double headingDegrees;

  private @Nullable String label;

  public GeoPoint() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GeoPoint(Double latitude, Double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public GeoPoint latitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Get latitude
   * minimum: -90
   * maximum: 90
   * @return latitude
   */
  @NotNull @DecimalMin(value = "-90") @DecimalMax(value = "90") 
  @Schema(name = "latitude", example = "52.4226", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("latitude")
  public Double getLatitude() {
    return latitude;
  }

  @JsonProperty("latitude")
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public GeoPoint longitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Get longitude
   * minimum: -180
   * maximum: 180
   * @return longitude
   */
  @NotNull @DecimalMin(value = "-180") @DecimalMax(value = "180") 
  @Schema(name = "longitude", example = "10.7865", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("longitude")
  public Double getLongitude() {
    return longitude;
  }

  @JsonProperty("longitude")
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public GeoPoint headingDegrees(@Nullable Double headingDegrees) {
    this.headingDegrees = headingDegrees;
    return this;
  }

  /**
   * Compass heading in degrees (0 = north)
   * minimum: 0
   * maximum: 360
   * @return headingDegrees
   */
  @DecimalMin(value = "0") @DecimalMax(value = "360") 
  @Schema(name = "headingDegrees", example = "270.0", description = "Compass heading in degrees (0 = north)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("headingDegrees")
  public @Nullable Double getHeadingDegrees() {
    return headingDegrees;
  }

  @JsonProperty("headingDegrees")
  public void setHeadingDegrees(@Nullable Double headingDegrees) {
    this.headingDegrees = headingDegrees;
  }

  public GeoPoint label(@Nullable String label) {
    this.label = label;
    return this;
  }

  /**
   * Optional human-readable name for the location
   * @return label
   */
  
  @Schema(name = "label", example = "Gate B - Bay 3", description = "Optional human-readable name for the location", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("label")
  public @Nullable String getLabel() {
    return label;
  }

  @JsonProperty("label")
  public void setLabel(@Nullable String label) {
    this.label = label;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoPoint geoPoint = (GeoPoint) o;
    return Objects.equals(this.latitude, geoPoint.latitude) &&
        Objects.equals(this.longitude, geoPoint.longitude) &&
        Objects.equals(this.headingDegrees, geoPoint.headingDegrees) &&
        Objects.equals(this.label, geoPoint.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitude, longitude, headingDegrees, label);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoPoint {\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    headingDegrees: ").append(toIndentedString(headingDegrees)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
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

