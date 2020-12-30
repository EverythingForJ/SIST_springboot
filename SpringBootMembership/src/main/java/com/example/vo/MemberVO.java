package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private String userid;
	private String passwd;
	private String name;
	private int age;
	private String gender;
	private String city;
}
