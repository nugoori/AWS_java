package ch16_lombok;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor // - final 변수와 세트
@Data
public class Slave {

	private final String name;
	private int age;
	
	
	
	
	
}
