# \OrdersApi

All URIs are relative to *http://localhost:8080/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cancel_order**](OrdersApi.md#cancel_order) | **POST** /orders/{orderId}/cancel | Cancel a ride order
[**create_order**](OrdersApi.md#create_order) | **POST** /orders | Submit a new ride order
[**get_active_order**](OrdersApi.md#get_active_order) | **GET** /orders/active | Get the currently active order, if any
[**get_order**](OrdersApi.md#get_order) | **GET** /orders/{orderId} | Get a specific ride order
[**list_orders**](OrdersApi.md#list_orders) | **GET** /orders | List ride orders



## cancel_order

> models::RideOrder cancel_order(order_id, cancel_order_request)
Cancel a ride order

Requests cancellation of an active (accepted or in-progress) order. Cancellation is not guaranteed to be immediate; the AD stack must bring the vehicle to a safe stop before the order transitions to `cancelled`. 

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

> models::RideOrder create_order(ride_order_request)
Submit a new ride order

Creates a new ride order instructing the AD stack to drive the vehicle from its current position to the specified target location. The AD stack evaluates feasibility and responds with the created order, which may already be in a rejected state if infeasible. 

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**ride_order_request** | [**RideOrderRequest**](RideOrderRequest.md) |  | [required] |

### Return type

[**models::RideOrder**](RideOrder.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## get_active_order

> models::RideOrder get_active_order()
Get the currently active order, if any

Convenience endpoint returning the single order currently being executed or pending execution by the AD stack (status `accepted` or `in_progress`). 

### Parameters

This endpoint does not need any parameter.

### Return type

[**models::RideOrder**](RideOrder.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
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

> models::ListOrders200Response list_orders(status, limit, offset)
List ride orders

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**status** | Option<[**OrderStatus**](OrderStatus.md)> | Filter by order status |  |
**limit** | Option<**i32**> |  |  |[default to 50]
**offset** | Option<**i32**> |  |  |[default to 0]

### Return type

[**models::ListOrders200Response**](listOrders_200_response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

