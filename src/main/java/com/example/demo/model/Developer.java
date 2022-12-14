package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Developer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "sex", nullable = false)
	private String sex;
	
	@Column(name = "developer_type", nullable = false)
	private String developerType;

	@Column(name = "performed_tests")
	private List<String> performedTests;

	@Column(name = "seniority", nullable = false)
	private String seniority;

	@Column(name = "technologies")
	private List<String> technologies;
	
	@Column(name = "experience", nullable = false)
	private String experience;
}
