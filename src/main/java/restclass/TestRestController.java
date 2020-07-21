package restclass;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
    public static class RestResponse{
        private String size;
        private String coust;

        public String getCoust() {
            return coust;
        }

        public void setCoust(String coust) {
            this.coust = coust;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }
    }
    @RequestMapping(value  = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse restMethod(String name){
        RestResponse result = new RestResponse();
        result.setSize("100");
        result.setCoust(name);
        return result;
        //hi
    }
    @RequestMapping(value  = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse restMethod2(String name){
        RestResponse result = new RestResponse();
        result.setSize("220");
        result.setCoust(name);
        return result;
    }

}
