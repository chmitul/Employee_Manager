package org.employee.repository;

import org.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	@Query(value = "Select * from employee  where phone_Number = :phoneNumber",
				 nativeQuery = true)
	Employee getEmployeeByPhoneNumber(@Param("phoneNumber") Long phoneNumber);

	@Query("Select e from Employee e where e.lastName = :lastName")
	Employee getEmployeeByLastName(@Param("lastName") String lastName);
}


