package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.starwit.adorder.model.RideOrder;
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
 * ListOrders200Response
 */

@JsonTypeName("listOrders_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-01T11:19:45.250413236+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class ListOrders200Response {

  private List<@Valid RideOrder> items = new ArrayList<>();

  private Integer total;

  public ListOrders200Response() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ListOrders200Response(List<@Valid RideOrder> items, Integer total) {
    this.items = items;
    this.total = total;
  }

  public ListOrders200Response items(List<@Valid RideOrder> items) {
    this.items = items;
    return this;
  }

  public ListOrders200Response addItemsItem(RideOrder itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
   */
  @NotNull @Valid 
  @Schema(name = "items", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("items")
  public List<@Valid RideOrder> getItems() {
    return items;
  }

  @JsonProperty("items")
  public void setItems(List<@Valid RideOrder> items) {
    this.items = items;
  }

  public ListOrders200Response total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
   */
  @NotNull 
  @Schema(name = "total", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("total")
  public Integer getTotal() {
    return total;
  }

  @JsonProperty("total")
  public void setTotal(Integer total) {
    this.total = total;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListOrders200Response listOrders200Response = (ListOrders200Response) o;
    return Objects.equals(this.items, listOrders200Response.items) &&
        Objects.equals(this.total, listOrders200Response.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListOrders200Response {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

