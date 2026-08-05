package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import de.starwit.adorder.model.SoftwareComponent;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * Full inventory of software components in the AD stack
 */

@Schema(name = "ComponentList", description = "Full inventory of software components in the AD stack")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T21:10:51.076418484+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class ComponentList {

  private List<@Valid SoftwareComponent> components = new ArrayList<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  public ComponentList() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ComponentList(List<@Valid SoftwareComponent> components, OffsetDateTime timestamp) {
    this.components = components;
    this.timestamp = timestamp;
  }

  public ComponentList components(List<@Valid SoftwareComponent> components) {
    this.components = components;
    return this;
  }

  public ComponentList addComponentsItem(SoftwareComponent componentsItem) {
    if (this.components == null) {
      this.components = new ArrayList<>();
    }
    this.components.add(componentsItem);
    return this;
  }

  /**
   * Get components
   * @return components
   */
  @NotNull @Valid 
  @Schema(name = "components", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("components")
  public List<@Valid SoftwareComponent> getComponents() {
    return components;
  }

  @JsonProperty("components")
  public void setComponents(List<@Valid SoftwareComponent> components) {
    this.components = components;
  }

  public ComponentList timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Time at which the inventory was captured
   * @return timestamp
   */
  @NotNull @Valid 
  @Schema(name = "timestamp", description = "Time at which the inventory was captured", requiredMode = Schema.RequiredMode.REQUIRED)
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
    ComponentList componentList = (ComponentList) o;
    return Objects.equals(this.components, componentList.components) &&
        Objects.equals(this.timestamp, componentList.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(components, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComponentList {\n");
    sb.append("    components: ").append(toIndentedString(components)).append("\n");
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

