package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.starwit.adorder.model.RideOrderRequestConstraintsAvoidAreasInner;
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
 * Optional operational constraints for the drive
 */

@Schema(name = "RideOrderRequest_constraints", description = "Optional operational constraints for the drive")
@JsonTypeName("RideOrderRequest_constraints")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-01T11:19:45.250413236+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class RideOrderRequestConstraints {

  private @Nullable BigDecimal maxSpeedKph;

  private List<@Valid RideOrderRequestConstraintsAvoidAreasInner> avoidAreas = new ArrayList<>();

  public RideOrderRequestConstraints maxSpeedKph(@Nullable BigDecimal maxSpeedKph) {
    this.maxSpeedKph = maxSpeedKph;
    return this;
  }

  /**
   * Optional speed cap for this order
   * minimum: 0
   * @return maxSpeedKph
   */
  @Valid @DecimalMin(value = "0") 
  @Schema(name = "maxSpeedKph", description = "Optional speed cap for this order", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxSpeedKph")
  public @Nullable BigDecimal getMaxSpeedKph() {
    return maxSpeedKph;
  }

  @JsonProperty("maxSpeedKph")
  public void setMaxSpeedKph(@Nullable BigDecimal maxSpeedKph) {
    this.maxSpeedKph = maxSpeedKph;
  }

  public RideOrderRequestConstraints avoidAreas(List<@Valid RideOrderRequestConstraintsAvoidAreasInner> avoidAreas) {
    this.avoidAreas = avoidAreas;
    return this;
  }

  public RideOrderRequestConstraints addAvoidAreasItem(RideOrderRequestConstraintsAvoidAreasInner avoidAreasItem) {
    if (this.avoidAreas == null) {
      this.avoidAreas = new ArrayList<>();
    }
    this.avoidAreas.add(avoidAreasItem);
    return this;
  }

  /**
   * Optional list of areas to avoid, e.g. geofenced zones under maintenance
   * @return avoidAreas
   */
  @Valid 
  @Schema(name = "avoidAreas", description = "Optional list of areas to avoid, e.g. geofenced zones under maintenance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avoidAreas")
  public List<@Valid RideOrderRequestConstraintsAvoidAreasInner> getAvoidAreas() {
    return avoidAreas;
  }

  @JsonProperty("avoidAreas")
  public void setAvoidAreas(List<@Valid RideOrderRequestConstraintsAvoidAreasInner> avoidAreas) {
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
    RideOrderRequestConstraints rideOrderRequestConstraints = (RideOrderRequestConstraints) o;
    return Objects.equals(this.maxSpeedKph, rideOrderRequestConstraints.maxSpeedKph) &&
        Objects.equals(this.avoidAreas, rideOrderRequestConstraints.avoidAreas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxSpeedKph, avoidAreas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RideOrderRequestConstraints {\n");
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

