package co.edu.escuelaing.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxiController {

    private static final String USER_AGENT = "Mozilla/5.0";
    private int currentIndex = 0;
    private static String serversDsiponibles[] = {
        "http://54.234.97.50:8081/",
        "http://54.173.200.148:8081/"};

    @GetMapping("/catalan")
    public String getCatalan(@RequestParam(name = "value") int value) throws IOException {
        int responseCode;
        URL obj;
        HttpURLConnection con;
        try {
            System.out.println("Consulta a server: " + serversDsiponibles[currentIndex]);
            String url = serversDsiponibles[currentIndex] + "catalan?value=" + value;
            obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            System.out.println("Hice bien con con httpurl: ");
            con.setRequestMethod("GET");
            System.out.println("Hice bien get: ");

            con.setRequestProperty("User-Agent", USER_AGENT);
            System.out.println("Hice bien userAgent: ");

            

            
            responseCode = con.getResponseCode();
        } catch (Exception e) {
            System.out.println("Hice mal getResponseCode pues fallo este server, debo cambairlo: ");
            System.out.println("El server " + serversDsiponibles[currentIndex] + " fallo, debo cambiar al otro server ya mismooo");
            currentIndex++;
            System.out.println("Ahora consulta a server: " + serversDsiponibles[currentIndex % serversDsiponibles.length]);
            String url = serversDsiponibles[currentIndex % serversDsiponibles.length] + "catalan?value=" + value;
            obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            responseCode = con.getResponseCode();
        }
        System.out.println("Hice bien getResponseCode: ");

        System.out.println("GET Response Code :: " + responseCode);
        System.out.println(responseCode == HttpURLConnection.HTTP_OK);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new java.io.BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println("Response from server: " + response.toString());
            return response.toString();
        } else {
            System.out.println("El server " + serversDsiponibles[currentIndex] + " fallo, debo cambiar al otro server ya mismooo");
            System.out.println("Consulta a server: " + serversDsiponibles[currentIndex]);
            currentIndex++;
            System.out.println("Ahora consulta a server: " + serversDsiponibles[currentIndex % serversDsiponibles.length]);
            String url1 = serversDsiponibles[currentIndex % serversDsiponibles.length] + "catalan?value=" + value;
            URL obj1 = new URL(url1);
            HttpURLConnection con1 = (HttpURLConnection) obj1.openConnection();
            con1.setRequestMethod("GET");
            con1.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode1 = con1.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode1);
            if (responseCode1 == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new java.io.BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println("Response from server: " + response.toString());
                return response.toString();
            } else {
                return "None of the servers works";
            }
        }
    }
}
