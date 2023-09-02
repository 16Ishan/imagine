package com.imagine.book.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "order", schema = "imagine")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Integer orderId;

    private Integer userId;

    private List<Integer> bookIdList;
}
