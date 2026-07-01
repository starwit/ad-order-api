package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Machine-readable reason code when status is `rejected` or `failed`
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-01T11:42:33.323681150+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public enum RejectionReason {
  
  TARGET_UNREACHABLE("target_unreachable"),
  
  VEHICLE_UNAVAILABLE("vehicle_unavailable"),
  
  VEHICLE_IN_FAULT_STATE("vehicle_in_fault_state"),
  
  OUTSIDE_OPERATIONAL_DOMAIN("outside_operational_domain"),
  
  OTHER("other");

  private final String value;

  RejectionReason(String value) {
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
  public static RejectionReason fromValue(String value) {
    for (RejectionReason b : RejectionReason.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

