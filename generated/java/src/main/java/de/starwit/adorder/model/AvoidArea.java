package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.starwit.adorder.model.GeoPoint;
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
 * A geofenced area the vehicle should avoid
 */

@Schema(name = "AvoidArea", description = "A geofenced area the vehicle should avoid")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T21:10:51.076418484+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class AvoidArea {

  private @Nullable String label;

  private List<@Valid GeoPoint> polygon = new ArrayList<>();

  public AvoidArea() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AvoidArea(List<@Valid GeoPoint> polygon) {
    this.polygon = polygon;
  }

  public AvoidArea label(@Nullable String label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
   */
  
  @Schema(name = "label", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("label")
  public @Nullable String getLabel() {
    return label;
  }

  @JsonProperty("label")
  public void setLabel(@Nullable String label) {
    this.label = label;
  }

  public AvoidArea polygon(List<@Valid GeoPoint> polygon) {
    this.polygon = polygon;
    return this;
  }

  public AvoidArea addPolygonItem(GeoPoint polygonItem) {
    if (this.polygon == null) {
      this.polygon = new ArrayList<>();
    }
    this.polygon.add(polygonItem);
    return this;
  }

  /**
   * Closed polygon defined as an ordered list of GeoPoints
   * @return polygon
   */
  @NotNull @Valid @Size(min = 3) 
  @Schema(name = "polygon", description = "Closed polygon defined as an ordered list of GeoPoints", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("polygon")
  public List<@Valid GeoPoint> getPolygon() {
    return polygon;
  }

  @JsonProperty("polygon")
  public void setPolygon(List<@Valid GeoPoint> polygon) {
    this.polygon = polygon;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvoidArea avoidArea = (AvoidArea) o;
    return Objects.equals(this.label, avoidArea.label) &&
        Objects.equals(this.polygon, avoidArea.polygon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, polygon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvoidArea {\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    polygon: ").append(toIndentedString(polygon)).append("\n");
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

