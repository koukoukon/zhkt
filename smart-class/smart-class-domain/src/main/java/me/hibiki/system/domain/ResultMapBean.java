package me.hibiki.system.domain;

import lombok.Data;

import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/6/15 9:28
 */
@Data
public class ResultMapBean {
    private Integer code = 1;
    private String msg = "";
    private Long count;
    private List data;
}
