package ss16_io_text_file.excercise.read_file_csv.service;

import ss16_io_text_file.excercise.read_file_csv.model.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryService {
    public static List<Country> readFile(String filePath) throws IOException {
        List<Country> countryList = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] info;
        Country country;
        while ((line = bufferedReader.readLine()) != null) {
            info = line.split(",");
//            country=new Country(Integer.parseInt(info[0]),info[1],info[2]);
            country = new Country();
            country.setId(Integer.parseInt(info[0]));
            country.setCode(info[1]);
            country.setName(info[2]);
            countryList.add(country);
        }
        bufferedReader.close();
        return countryList;
    }

    public static void infoCountry(List<Country> countryList) {
        System.out.println("Tên các Quốc Gia!");

        for (Country country : countryList) {
            System.out.println(country.getId() +" : "+ country.getName());
        }
    }
}
