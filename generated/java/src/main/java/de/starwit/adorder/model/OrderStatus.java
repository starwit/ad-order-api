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
 * Lifecycle status of a ride order. `pending` -> `accepted` -> `in_progress` -> `completed`, with `rejected`, `cancelled` and `failed` as alternative/terminal outcomes. 
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-01T11:19:45.250413236+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public enum OrderStatus {
  
  PENDING("pending"),
  
  ACCEPTED("accepted"),
  
  REJECTED("rejected"),
  
  IN_PROGRESS("in_progress"),
  
  COMPLETED("completed"),
  
  CANCELLED("cancelled"),
  
  FAILED("failed");

  private final String value;

  OrderStatus(String value) {
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
  public static OrderStatus fromValue(String value) {
    for (OrderStatus b : OrderStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

