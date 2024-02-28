package com.proxy.ta;


import static org.junit.jupiter.api.Assertions.assertEquals;
import com.proxy.ta.config.jwt.LoginReq;
import com.proxy.ta.entity.UserEntity;
import com.proxy.ta.repository.UserRepository;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @LocalServerPort
  private int localServerPort;

  @AfterAll
  public void cleanUp() {
    userRepository.deleteAll(entitiesFromTest);
  }

  public final static String LOCALHOST = "http://localhost:";
  public final static String API_V1_BASE = "/api/v1/";
  public final static String LOGIN = "auth/login";


  private final List<UserEntity> entitiesFromTest = new ArrayList<>();

  @Test
  public void ShouldReturnStatusCode200ForLoginRequest() throws URISyntaxException, JSONException {
    String baseUrl = LOCALHOST + localServerPort + API_V1_BASE + LOGIN;

    UserEntity userEntity = createUser();
    LoginReq loginReqBody = new LoginReq(userEntity.getEmail(), userEntity.getPassword());


    ResponseEntity<String> result = PostRequest(baseUrl, loginReqBody);

    assertEquals(200, result.getStatusCodeValue());
    assertEquals(userEntity.getEmail(), parseJson(result.getBody()));
  }

  @Test
  public void ShouldReturnStatusCode400ForNotExistingUser() throws URISyntaxException {
    String baseUrl = LOCALHOST + localServerPort + API_V1_BASE + LOGIN;

    LoginReq loginReqBody = new LoginReq(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    ResponseEntity<String> result = PostRequest(baseUrl, loginReqBody);

    assertEquals(400, result.getStatusCodeValue());
  }

  private UserEntity createUser() {
    UserEntity user = userRepository.save(UserEntity.builder()
        .email(UUID.randomUUID().toString())
        .password(UUID.randomUUID().toString())
        .firstName(UUID.randomUUID().toString())
        .lastName(UUID.randomUUID().toString())
        .build());
    entitiesFromTest.add(user);
    return user;
  }

  private ResponseEntity<String> PostRequest(String baseUrl, LoginReq loginReq) throws URISyntaxException {
    HttpEntity<LoginReq> request = new HttpEntity<>(loginReq);
    return restTemplate.postForEntity(new URI(baseUrl), request, String.class);
  }

  private String parseJson(String jsonString) throws JSONException {
    JSONObject jsonObject = new JSONObject(jsonString);
    return jsonObject.getString("email");
  }




}
