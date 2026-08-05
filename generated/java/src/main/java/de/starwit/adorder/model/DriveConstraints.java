package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.starwit.adorder.model.AvoidArea;
import java.math.BigDecimal;
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
 * Optional operational constraints scoped to a single order
 */

@Schema(name = "DriveConstraints", description = "Optional operational constraints scoped to a single order")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T21:10:51.076418484+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class DriveConstraints {

  private @Nullable BigDecimal maxSpeedKph;

  private List<@Valid AvoidArea> avoidAreas = new ArrayList<>();

  public DriveConstraints maxSpeedKph(@Nullable BigDecimal maxSpeedKph) {
    this.maxSpeedKph = maxSpeedKph;
    return this;
  }

  /**
   * Speed cap for this order in km/h
   * minimum: 0
   * @return maxSpeedKph
   */
  @Valid @DecimalMin(value = "0") 
  @Schema(name = "maxSpeedKph", description = "Speed cap for this order in km/h", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxSpeedKph")
  public @Nullable BigDecimal getMaxSpeedKph() {
    return maxSpeedKph;
  }

  @JsonProperty("maxSpeedKph")
  public void setMaxSpeedKph(@Nullable BigDecimal maxSpeedKph) {
    this.maxSpeedKph = maxSpeedKph;
  }

  public DriveConstraints avoidAreas(List<@Valid AvoidArea> avoidAreas) {
    this.avoidAreas = avoidAreas;
    return this;
  }

  public DriveConstraints addAvoidAreasItem(AvoidArea avoidAreasItem) {
    if (this.avoidAreas == null) {
      this.avoidAreas = new ArrayList<>();
    }
    this.avoidAreas.add(avoidAreasItem);
    return this;
  }

  /**
   * Geofenced areas to avoid, e.g. zones under maintenance
   * @return avoidAreas
   */
  @Valid 
  @Schema(name = "avoidAreas", description = "Geofenced areas to avoid, e.g. zones under maintenance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avoidAreas")
  public List<@Valid AvoidArea> getAvoidAreas() {
    return avoidAreas;
  }

  @JsonProperty("avoidAreas")
  public void setAvoidAreas(List<@Valid AvoidArea> avoidAreas) {
    this.avoidAreas = avoidAreas;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DriveConstraints driveConstraints = (DriveConstraints) o;
    return Objects.equals(this.maxSpeedKph, driveConstraints.maxSpeedKph) &&
        Objects.equals(this.avoidAreas, driveConstraints.avoidAreas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxSpeedKph, avoidAreas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DriveConstraints {\n");
    sb.append("    maxSpeedKph: ").append(toIndentedString(maxSpeedKph)).append("\n");
    sb.append("    avoidAreas: ").append(toIndentedString(avoidAreas)).append("\n");
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

