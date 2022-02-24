package io.payrollmanagement.department;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class Department{
       
	    @Id
		private String did;
		private String department_name;
		private String department_HOD;
		private String department_timeStamp;
		private int deleted;
		
}