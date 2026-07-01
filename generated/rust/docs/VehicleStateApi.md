# \VehicleStateApi

All URIs are relative to *http://localhost:8080/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_vehicle_state**](VehicleStateApi.md#get_vehicle_state) | **GET** /vehicle/state | Get current AD stack state relevant to order execution



## get_vehicle_state

> models::VehicleState get_vehicle_state()
Get current AD stack state relevant to order execution

Returns the vehicle's current position and AD stack readiness, useful for clients deciding whether/where to submit a new order. 

### Parameters

This endpoint does not need any parameter.

### Return type

[**models::VehicleState**](VehicleState.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

