package com.tutorial.Springproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long departmentId;

	//javax validations
	@NotBlank(message = "please add Department name")

	/*@Length(max = 5, min = 1,message = "")
	@Size(max = 10, min=0)
	@Email(regexp = "")

	//related to number
	@Positive
	@Negative
	@PositiveOrZero
	@NegativeOrZero

	//reletead to date
	@Future
	@FutureOrPresent
    @Past
	@PastOrPresent*/
	public String departmentName;
	public String departmentAddress;
	public String departmentCode;


}
