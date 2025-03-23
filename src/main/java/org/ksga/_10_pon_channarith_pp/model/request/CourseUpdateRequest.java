package org.ksga._10_pon_channarith_pp.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ksga._10_pon_channarith_pp.model.Instructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseUpdateRequest {
    private String courseName;
    private String description;
    private Integer instructor;
}
