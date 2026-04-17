package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.LineDTOF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class apiService {

    public List<LineDTOF> connection() {
        try {
            URL url = new URL("http://localhost:8080/lines");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(response.toString(), new TypeReference<List<LineDTOF>>() {}
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
