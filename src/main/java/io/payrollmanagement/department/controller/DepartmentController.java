 package io.payrollmanagement.department.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.payrollmanagement.department.Department;
import io.payrollmanagement.dto.Request;
import io.payrollmanagement.dto.Response;
import io.payrollmanagement.service.DepartmentService;

@RestController
public class DepartmentController  {
		@Autowired
		private DepartmentService departmentService;

		@RequestMapping("/departments")
		public List<Response> getalldepartments()
		{
			return departmentService.getAllDepartment();
		}
		
		@RequestMapping("/department/{id}")
		public Response getDepartment(@PathVariable String id) {
			return departmentService.getDepartment(id);
		}
		
		@RequestMapping(method=RequestMethod.POST,value="/department")
		public void addDepartment(@RequestBody Request R)
		{
			//company.setCompany(new Company());
			departmentService.addDepartment(R);
		}
		
		@RequestMapping(method=RequestMethod.PUT,value="/department/{id}")
		public void updateDepartment(@RequestBody Request R,@PathVariable String id)
		{
			departmentService.updateDepartment(R,id);
		}
		
		@RequestMapping(method=RequestMethod.PUT,value="/department/{id}/delete")
		public void delDepartment(@PathVariable String id) {
			departmentService.delDepartment(id);
		}
		@RequestMapping("/activedepartments")
		public List<Response> getActiveDepartment() {
		return departmentService.getActiveDepartment();
		}
		
}

