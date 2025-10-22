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

    Map<Integer,BigInteger> memoCatalan = new HashMap<>();

    //Controladores para calcular el número catalan Cn
    @GetMapping("/catalan")
    public ResponseEntity<Map<String, Object>> getCatalan(@RequestParam(name = "value") int value) {
        List<BigInteger> listCatalan = new ArrayList<>();

        for(int i = 0; i <= value; i++){
            listCatalan.add(calculateCatalan(i));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("operation", "Secuencia de Catalan");
        response.put("input", value);
        response.put("output", listCatalan);

        System.out.println("Hiciste la petición desde el backend 1");

        return ResponseEntity.ok(response);
    }


    //calcular catalan recursivo

    private BigInteger calculateCatalan(int num){
        if(num == 0){
            if(!memoCatalan.containsKey(num)){
                BigInteger nume = BigInteger.valueOf(1L);
                memoCatalan.put(num, nume);
                return nume;
            }else{
                return memoCatalan.get(num);
            }
        } else {
            if(!memoCatalan.containsKey(num)){
                BigInteger sumatoria = BigInteger.ZERO;
                for(int j = 0; j < num; j ++){
                    sumatoria = sumatoria.add(calculateCatalan(j).multiply(calculateCatalan(num - 1 - j)));
                }
                memoCatalan.put(num, sumatoria);
                return sumatoria;
            }else{
                return memoCatalan.get(num);
            }
        }
    }

    

    
}
