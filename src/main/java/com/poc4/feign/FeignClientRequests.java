package com.poc4.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.poc4.entity.Address;

@FeignClient(name = "addAddress",url = "http://localhost:9000/address")
public interface FeignClientRequests {
@PostMapping("/addAddress")
public void addAddress(@RequestBody Address address);
}
