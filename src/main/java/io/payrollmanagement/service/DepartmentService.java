package io.payrollmanagement.service;
import java.util.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.payrollmanagement.department.Department;
import io.payrollmanagement.dto.Request;
import io.payrollmanagement.dto.Response;
import io.payrollmanagement.repository.DepartmentRepository;


@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	public List<Response> getAllDepartment(){
		List <Department> departments=new ArrayList<>();
		departmentRepository.findAll()
		.forEach(departments::add);
		List<Response> result = new ArrayList<>();
		for (int i=0;i<departments.size();i++)
		{
			Department d=departments.get(i);
			result.add(Response.builder()
					.did(d.getDid())
					.department_name(d.getDepartment_name())
					.department_HOD(d.getDepartment_HOD())
					.department_timeStamp(d.getDepartment_timeStamp())
					.deleted(d.getDeleted())
					.build());
					}
		return result;
}

	
	public Response getDepartment(String Id)
	{
		Department d= departmentRepository.findAllBydid(Id);
		return (Response.builder().did(d.getDid())
				.department_name(d.getDepartment_name())
				.department_HOD(d.getDepartment_HOD())
				.department_timeStamp(d.getDepartment_timeStamp())
				.deleted(d.getDeleted())
				.build());
	}

	public void addDepartment(Request R) {
		String UUID1;
		UUID uuid = UUID.randomUUID();
		UUID1= uuid.toString();
		while (departmentRepository.existsById(UUID1)) {
			UUID uui = UUID.randomUUID();
			UUID1= uui.toString();
		}
	    R.setDid(UUID1);
		R.setDeleted(0);
		Date date= new Date();
		R.setDepartment_timeStamp(date.toString());
		departmentRepository.save(Department.builder()
				.did(R.getDid())
				.department_name(R.getDepartment_name())
				.department_HOD(R.getDepartment_HOD())
				.deleted(R.getDeleted())
				.department_timeStamp(R.getDepartment_timeStamp())
				.build());
		
	}

	public void updateDepartment(Request R, String id) {
		Date date= new Date();
		R.setDepartment_timeStamp(date.toString());
		R.setDeleted(0);
		departmentRepository.save(Department.builder()
				.did(R.getDid())
				.department_name(R.getDepartment_name())
				.department_HOD(R.getDepartment_HOD())
				.deleted(R.getDeleted())
				.department_timeStamp(R.getDepartment_timeStamp())
				.build());
		
	}

	public void delDepartment(String id) {
		Department d= departmentRepository.findAllBydid(id);
		d.setDeleted(1);
		departmentRepository.save(d);
		//topics.removeIf(t -> t.getId().equals(id)); 
	}
	public List<Response> getActiveDepartment() {
		List<Department> activeDepartmentList = departmentRepository.findAllByDeleted(0);
		List<Response> result = new ArrayList<>();
		for (int i=0;i<activeDepartmentList.size();i++)
		{
			Department d=activeDepartmentList.get(i);
			result.add(Response.builder()
					.did(d.getDid())
					.department_name(d.getDepartment_name())
					.department_HOD(d.getDepartment_HOD())
					.department_timeStamp(d.getDepartment_timeStamp())
					.deleted(d.getDeleted())
					.build());
					}
		return result;
}
}