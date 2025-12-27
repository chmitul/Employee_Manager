package org.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmployeeDto
{
	private Integer id;

	private String firstName;

	private String lastName;

	private String managerId;

	private String city;

	private Long phoneNumber;

	private BigDecimal salary;

	private LocalDateTime joiningDate;
}
