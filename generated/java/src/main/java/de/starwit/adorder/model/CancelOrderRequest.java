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
 * Optional payload when cancelling a ride order
 */

@Schema(name = "CancelOrderRequest", description = "Optional payload when cancelling a ride order")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-07T23:24:20.986589197+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class CancelOrderRequest {

  private @Nullable String reason;

  public CancelOrderRequest reason(@Nullable String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Free-text reason for cancellation (logged/audited only)
   * @return reason
   */
  
  @Schema(name = "reason", example = "Operator requested stop for maintenance", description = "Free-text reason for cancellation (logged/audited only)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reason")
  public @Nullable String getReason() {
    return reason;
  }

  @JsonProperty("reason")
  public void setReason(@Nullable String reason) {
    this.reason = reason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancelOrderRequest cancelOrderRequest = (CancelOrderRequest) o;
    return Objects.equals(this.reason, cancelOrderRequest.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CancelOrderRequest {\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

