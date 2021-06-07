package com.chen.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenhongchang
 * @date 2021/6/4 0004 - 下午 4:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T> {

    // 404 Not Found
    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
