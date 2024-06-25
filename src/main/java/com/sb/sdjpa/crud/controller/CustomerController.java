package com.sb.sdjpa.crud.controller;

import com.sb.sdjpa.crud.request.CustomerRequest;
import com.sb.sdjpa.crud.response.APIResponse;
import com.sb.sdjpa.crud.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * create a customer, in case of post mapping this method will get invoked.
     *
     * @param request customer request
     * @return response entity object
     */
    @PostMapping("/create")
    @Operation(
            summary = "Registration",
            description = "Register the customer using the input request object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<APIResponse> createCustomer(@RequestBody CustomerRequest request) {
        return customerService.createCustomer(request);
    }

    /**
     * get all the customer from the database, in case of get mapping with /getAll endpoint this method will get invoked.
     *
     * @return response entity object
     */
    @GetMapping("/getAll")
    @Operation(
            summary = "Fetch All",
            description = "Fetch all the customer from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<APIResponse> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    /**
     * get a specific customer from the database, in case of get mapping with /getById endpoint this method will get invoked.
     *
     * @param customerId customer id
     * @return response entity object
     */
    @GetMapping("/getById/{customerId}")
    @Operation(
            summary = "Fetch By Id",
            description = "Fetch a customer using id from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<APIResponse> getByCustomerId(@PathVariable long customerId) {
        return customerService.getByCustomerId(customerId);
    }

    /**
     * delete a specific customer from the database, in case of delete mapping this method will get invoked.
     *
     * @param customerId customer id
     * @return response entity object
     */
    @DeleteMapping("/deleteById/{customerId}")
    @Operation(
            summary = "Delete By Id",
            description = "Delete a customer using id from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<APIResponse> deleteByCustomerId(@PathVariable long customerId) {
        return customerService.deleteByCustomerId(customerId);
    }

    /**
     * update a specific customer, in case of put mapping this method will get invoked.
     *
     * @param customerId customer id
     * @param request customer request object
     * @return response entity object
     */
    @PutMapping("/update/{customerId}")
    @Operation(
            summary = "Update",
            description = "Update customer details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public ResponseEntity<APIResponse> updateCustomer(@PathVariable long customerId, @RequestBody CustomerRequest request) {
        return customerService.updateCustomerDetails(customerId, request);
    }
}
