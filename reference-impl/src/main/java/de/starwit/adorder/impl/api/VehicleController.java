package de.starwit.adorder.impl.api;

import de.starwit.adorder.impl.service.VehicleStateService;
import de.starwit.adorder.model.ComponentList;
import de.starwit.adorder.model.VehicleStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleStateService vehicleStateService;

    public VehicleController(VehicleStateService vehicleStateService) {
        this.vehicleStateService = vehicleStateService;
    }

    @GetMapping("/status")
    public ResponseEntity<VehicleStatus> getVehicleStatus() {
        return ResponseEntity.ok(vehicleStateService.getCurrentStatus());
    }

    @GetMapping("/components")
    public ResponseEntity<ComponentList> getComponentList() {
        return ResponseEntity.ok(vehicleStateService.getComponentList());
    }
}
