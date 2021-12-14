package com.kkulkkeog.delivery.v1.domain;

import com.kkulkkeog.delivery.v1.api.DeliveryState;
import com.kkulkkeog.delivery.v1.api.DeliveryType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_DELIVERY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
@EntityListeners(AuditingEntityListener.class)
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryNo;

    private String deliveryAddress;

    private String deliveryDescription;

    private Long orderNo;

    private Long memberNo;

    private Long shopNo;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    @Enumerated(EnumType.STRING)
    private DeliveryState deliveryState;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    private Boolean deleted;

}
