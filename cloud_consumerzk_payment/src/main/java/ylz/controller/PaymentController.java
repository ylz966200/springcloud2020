package ylz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String url="http://cloud-provider-payment";

    @GetMapping("/payment")
    public String getInfo(){
        ResponseEntity<String> resBody=  this.restTemplate.getForEntity(url+"/port",String.class);
        return resBody.getBody();
    }
}
