package 능력단위평가;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Company {
    private int companyId;

    private String companyName;

    private String address;

    private String city;

    private String state;

    private String zipCode;

}

