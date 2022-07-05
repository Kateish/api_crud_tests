package co.agoraworld.tests.entities;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserDTO {
    private String username;
    private String name;
    private String email;
    private String phone;
    private String bio;
    private String birthday;
    private List<Groups> groups;

}
