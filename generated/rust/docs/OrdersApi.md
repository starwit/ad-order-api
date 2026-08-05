# \OrdersApi

All URIs are relative to *http://localhost:8080/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cancel_order**](OrdersApi.md#cancel_order) | **POST** /orders/{orderId}/cancel | Cancel a ride order
[**create_order**](OrdersApi.md#create_order) | **POST** /orders | Create a new ride order
[**get_order**](OrdersApi.md#get_order) | **GET** /orders/{orderId} | Get a specific ride order
[**list_orders**](OrdersApi.md#list_orders) | **GET** /orders | List all ride orders
[**update_order**](OrdersApi.md#update_order) | **PATCH** /orders/{orderId} | Update a ride order



## cancel_order

> models::RideOrder cancel_order(order_id, cancel_order_request)
Cancel a ride order

Requests cancellation of an active order. The AD stack brings the vehicle to a safe stop before transitioning the order to `cancelled`, so the transition is asynchronous. 

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**order_id** | **uuid::Uuid** | Unique identifier of the ride order | [required] |
**cancel_order_request** | Option<[**CancelOrderRequest**](CancelOrderRequest.md)> |  |  |

### Return type

[**models::RideOrder**](RideOrder.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## create_order

> models::RideOrder create_order(create_order_request)
Create a new ride order

Submits a new ride order to the AD stack. The stack evaluates feasibility immediately; the returned order may already be in `rejected` state if the request cannot be fulfilled. 

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**create_order_request** | [**CreateOrderRequest**](CreateOrderRequest.md) |  | [required] |

### Return type

[**models::RideOrder**](RideOrder.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## get_order

> models::RideOrder get_order(order_id)
Get a specific ride order

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**order_id** | **uuid::Uuid** | Unique identifier of the ride order | [required] |

### Return type

[**models::RideOrder**](RideOrder.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## list_orders

> models::OrderList list_orders(status, limit, offset)
List all ride orders

Returns all orders, optionally filtered by status.

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**status** | Option<[**OrderStatus**](OrderStatus.md)> | Filter by order status |  |
**limit** | Option<**i32**> |  |  |[default to 50]
**offset** | Option<**i32**> |  |  |[default to 0]

### Return type

[**models::OrderList**](OrderList.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## update_order

> models::RideOrder update_order(order_id, update_order_request)
Update a ride order

Updates a pending or accepted order. Only `stops`, `priority`, and `constraints` may be updated. Updates to an `in_progress` order are limited to appending new stops; changes to already-reached stops or the priority of an active drive are rejected with 409. 

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**order_id** | **uuid::Uuid** | Unique identifier of the ride order | [required] |
**update_order_request** | [**UpdateOrderRequest**](UpdateOrderRequest.md) |  | [required] |

### Return type

[**models::RideOrder**](RideOrder.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

