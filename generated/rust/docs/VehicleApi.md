# \VehicleApi

All URIs are relative to *http://localhost:8080/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_component_list**](VehicleApi.md#get_component_list) | **GET** /vehicle/components | Get software component inventory
[**get_vehicle_status**](VehicleApi.md#get_vehicle_status) | **GET** /vehicle/status | Get current vehicle status



## get_component_list

> models::ComponentList get_component_list()
Get software component inventory

Returns the list of all software components running in the AD stack, including their names, versions, and current health status. 

### Parameters

This endpoint does not need any parameter.

### Return type

[**models::ComponentList**](ComponentList.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## get_vehicle_status

> models::VehicleStatus get_vehicle_status()
Get current vehicle status

Returns a snapshot of current vehicle state: AD stack mode, position, kinematics (speed, heading), and battery status. This is the same data structure published on the MQTT /vehicle/status topic. 

### Parameters

This endpoint does not need any parameter.

### Return type

[**models::VehicleStatus**](VehicleStatus.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

