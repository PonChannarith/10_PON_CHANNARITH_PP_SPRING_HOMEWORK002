package org.ksga._10_pon_channarith_pp.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateRequest {
    private String studentName;
    @Schema(defaultValue = "example@gmail.com")
    private String email;
    private String phoneNumber;
    private List<Integer> courses;
}
