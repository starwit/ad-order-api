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
 * Identifies the system or client that issued an order
 */

@Schema(name = "OrderSource", description = "Identifies the system or client that issued an order")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-07T23:24:20.986589197+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class OrderSource {

  /**
   * Whether the order originated from an onboard HMI or a backend system
   */
  public enum TypeEnum {
    ONBOARD_HMI("onboard_hmi"),
    
    BACKEND("backend");

    private final String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TypeEnum type;

  private String id;

  public OrderSource() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderSource(TypeEnum type, String id) {
    this.type = type;
    this.id = id;
  }

  public OrderSource type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Whether the order originated from an onboard HMI or a backend system
   * @return type
   */
  @NotNull 
  @Schema(name = "type", description = "Whether the order originated from an onboard HMI or a backend system", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(TypeEnum type) {
    this.type = type;
  }

  public OrderSource id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the specific HMI instance or backend service
   * @return id
   */
  @NotNull 
  @Schema(name = "id", example = "hmi-driver-console-1", description = "Identifier of the specific HMI instance or backend service", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderSource orderSource = (OrderSource) o;
    return Objects.equals(this.type, orderSource.type) &&
        Objects.equals(this.id, orderSource.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderSource {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

