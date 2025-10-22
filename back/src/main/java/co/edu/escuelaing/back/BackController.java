package co.edu.escuelaing.back;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackController {

    

    //Controladores para calcular el número catalan Cn
    @GetMapping("/catalan")
    public ResponseEntity<Map<String, Object>> getCatalan(@RequestParam(name = "value") int value) {
        List<BigInteger> listCatalan = new ArrayList<>();

        for(int i = 1; i <= value; i++){
            listCatalan.add(calculateCatalan(i));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("operation", "factors");
        response.put("input", value);
        response.put("output", listCatalan);

        return ResponseEntity.ok(response);
    }

    

    
}
