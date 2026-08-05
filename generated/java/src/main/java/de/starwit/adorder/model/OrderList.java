package de.starwit.adorder.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Paginated list of ride orders
 */

@Schema(name = "OrderList", description = "Paginated list of ride orders")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-08-05T21:10:51.076418484+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
public class OrderList {

  private List<@Valid RideOrder> items = new ArrayList<>();

  private Integer total;

  public OrderList() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderList(List<@Valid RideOrder> items, Integer total) {
    this.items = items;
    this.total = total;
  }

  public OrderList items(List<@Valid RideOrder> items) {
    this.items = items;
    return this;
  }

  public OrderList addItemsItem(RideOrder itemsItem) {
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

  public OrderList total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Total number of orders matching the applied filter
   * @return total
   */
  @NotNull 
  @Schema(name = "total", description = "Total number of orders matching the applied filter", requiredMode = Schema.RequiredMode.REQUIRED)
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
    OrderList orderList = (OrderList) o;
    return Objects.equals(this.items, orderList.items) &&
        Objects.equals(this.total, orderList.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderList {\n");
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

