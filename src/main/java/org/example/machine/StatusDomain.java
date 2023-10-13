package org.example.machine;

import com.alibaba.cola.domain.Entity;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
public class StatusDomain {
    private String originalStatus;
    private String toStatus;
}
