package com.dongchanglong.cloudalibabacommons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {

    private Integer code;
    private T data;

}