package io.payrollmanagement.department.proxy;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.payrollmanagement.dto.Response;
@EnableFeignClients("io.payrollmanagement.employeeservice")
@FeignClient(name="employee",url="localhost:8080//department-feign/{id}")
public interface DepartmentProxy {
	
	  @RequestMapping("/employee/{id}")
	  public Response getEmployee
	  (@PathVariable String id);
	  

}
