package org.manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmployeeDto
{
	private Integer id;

	@NotBlank(message = "First Name cannot be blank")
	@Size(min = 3,
				max = 25,
				message = "First Name length should be between 3 and 25")
	private String firstName;

	@NotBlank(message = "First Name cannot be blank")
	private String lastName;

	@NotNull(message = "First Name cannot be blank")
	private String managerId;

	@NotBlank(message = "City cannot be blank")
	private String city;

	@NotNull(message = "PhoneNumber is mandatory")
	@Positive(message = "Phone number should be greater than Zero")
	private Long phoneNumber;

	@NotNull(message = "Salary cannot be zero")
	@Positive(message = "Phone number should be greater than Zero")
	private BigDecimal salary;

	private LocalDateTime joiningDate;
}
