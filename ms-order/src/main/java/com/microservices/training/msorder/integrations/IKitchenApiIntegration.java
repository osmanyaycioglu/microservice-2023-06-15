package com.microservices.training.msorder.integrations;

import com.microservices.training.mskitchen.rest.IKitchenReservationController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "KITCHEN",contextId = "kitchen1")
public interface IKitchenApiIntegration extends IKitchenReservationController {
}
