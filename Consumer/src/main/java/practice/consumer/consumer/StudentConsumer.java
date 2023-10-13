package practice.consumer.consumer;

import jakarta.annotation.PostConstruct;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import practice.consumer.Student;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class StudentConsumer {

    @PostConstruct
    public void consumer(){
        String url = "http://localhost:8012/getStudent";
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Student>> responseEntity =template.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Student>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });

        List<Student> list= responseEntity.getBody();
        System.out.println("Size: "+list.size());
        if (list.size()>=0){
            for (Student element:list) {
                System.out.println("Id : "+element.getIdStudent()+
                                    "Student Name: "+element.getNameStudent()+
                                    "Student Email "+element.getEmailStudent());
            }
        }
    }
}
