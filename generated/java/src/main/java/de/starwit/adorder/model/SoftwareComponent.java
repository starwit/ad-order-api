package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * A single versioned software component running in the AD stack
 */

@Schema(name = "SoftwareComponent", description = "A single versioned software component running in the AD stack")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-07T23:24:20.986589197+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class SoftwareComponent {

  private String name;

  private String version;

  private @Nullable String buildId;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    RUNNING("running"),
    
    DEGRADED("degraded"),
    
    STOPPED("stopped"),
    
    UNKNOWN("unknown");

    private final String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status = StatusEnum.UNKNOWN;

  private @Nullable String description;

  public SoftwareComponent() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SoftwareComponent(String name, String version) {
    this.name = name;
    this.version = version;
  }

  public SoftwareComponent name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Component name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", example = "perception-module", description = "Component name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  public SoftwareComponent version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Semantic version string
   * @return version
   */
  @NotNull 
  @Schema(name = "version", example = "2.4.1", description = "Semantic version string", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }

  @JsonProperty("version")
  public void setVersion(String version) {
    this.version = version;
  }

  public SoftwareComponent buildId(@Nullable String buildId) {
    this.buildId = buildId;
    return this;
  }

  /**
   * Optional build or commit identifier
   * @return buildId
   */
  
  @Schema(name = "buildId", example = "git-a3f9c12", description = "Optional build or commit identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("buildId")
  public @Nullable String getBuildId() {
    return buildId;
  }

  @JsonProperty("buildId")
  public void setBuildId(@Nullable String buildId) {
    this.buildId = buildId;
  }

  public SoftwareComponent status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public SoftwareComponent description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * Optional human-readable description of the component
   * @return description
   */
  
  @Schema(name = "description", example = "LiDAR-based obstacle detection pipeline", description = "Optional human-readable description of the component", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SoftwareComponent softwareComponent = (SoftwareComponent) o;
    return Objects.equals(this.name, softwareComponent.name) &&
        Objects.equals(this.version, softwareComponent.version) &&
        Objects.equals(this.buildId, softwareComponent.buildId) &&
        Objects.equals(this.status, softwareComponent.status) &&
        Objects.equals(this.description, softwareComponent.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, version, buildId, status, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SoftwareComponent {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    buildId: ").append(toIndentedString(buildId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

