package de.starwit.adorder.impl.service;

import de.starwit.adorder.model.*;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Holds the current vehicle state snapshot.
 * In a real AD stack integration, this would be populated from internal
 * vehicle bus data (e.g. CAN, ROS topics, or internal sensor fusion output).
 * Here it provides a realistic static/simulated state for demonstration.
 */
@Service
public class VehicleStateService {

    private VehicleStatus currentStatus = buildInitialStatus();

    public VehicleStatus getCurrentStatus() {
        // Refresh timestamp on every read to reflect "live" data
        currentStatus.setTimestamp(OffsetDateTime.now());
        return currentStatus;
    }

    public void updateStatus(VehicleStatus status) {
        this.currentStatus = status;
    }

    public ComponentList getComponentList() {
        ComponentList list = new ComponentList();
        list.setTimestamp(OffsetDateTime.now());
        list.setComponents(List.of(
                component("perception-module", "2.4.1", "git-a3f9c12",
                        SoftwareComponent.StatusEnum.RUNNING,
                        "LiDAR-based obstacle detection pipeline"),
                component("path-planner", "1.9.3", "git-b22d441",
                        SoftwareComponent.StatusEnum.RUNNING,
                        "Global and local path planning module"),
                component("vehicle-controller", "3.1.0", "git-c91f003",
                        SoftwareComponent.StatusEnum.RUNNING,
                        "Low-level drive-by-wire controller"),
                component("localization", "2.0.5", "git-d77e110",
                        SoftwareComponent.StatusEnum.RUNNING,
                        "GPS/IMU sensor fusion and map matching"),
                component("ad-order-server", "0.0.1-SNAPSHOT", "dev",
                        SoftwareComponent.StatusEnum.RUNNING,
                        "REST/MQTT order interface (this service)")
        ));
        return list;
    }

    // -------------------------------------------------------------------------
    // Helpers
    // -------------------------------------------------------------------------

    private static VehicleStatus buildInitialStatus() {
        VehicleKinematics kinematics = new VehicleKinematics();
        kinematics.setSpeedKph(0.0);
        kinematics.setHeadingDegrees(0.0);
        kinematics.setAccelerationMps2(0.0);

        GeoPoint position = new GeoPoint();
        position.setLatitude(52.4226);
        position.setLongitude(10.7865);
        position.setHeadingDegrees(0.0);
        position.setLabel("Depot");

        BatteryStatus battery = new BatteryStatus();
        battery.setStateOfChargePercent(87.5);
        battery.setEstimatedRangeKm(210.0);
        battery.setCharging(false);
        battery.setHealthPercent(98.2);

        VehicleStatus status = new VehicleStatus();
        status.setAdStackMode(AdStackMode.IDLE);
        status.setAdStackReady(true);
        status.setKinematics(kinematics);
        status.setPosition(position);
        status.setBattery(battery);
        status.setTimestamp(OffsetDateTime.now());
        return status;
    }

    private static SoftwareComponent component(String name, String version, String buildId,
                                                SoftwareComponent.StatusEnum status, String description) {
        SoftwareComponent c = new SoftwareComponent();
        c.setName(name);
        c.setVersion(version);
        c.setBuildId(buildId);
        c.setStatus(status);
        c.setDescription(description);
        return c;
    }
}
