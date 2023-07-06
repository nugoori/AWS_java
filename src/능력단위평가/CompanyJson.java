package 능력단위평가;

import com.google.gson.Gson;

import com.google.gson.JsonObject;

class CompanyJson {

    public static void main(String[] args) {



        Gson gson = new Gson();

        Company company = Company.builder()

            .companyId(100)

            .companyName("Apple")

            .address("Apple Computer Inc. 1 infinite Loop")

            .city("CuperTino")

            .state("CA")

            .zipCode("95014")

            .build();

        String companyData = gson.toJson(company);

        System.out.println(companyData);

    }

}
