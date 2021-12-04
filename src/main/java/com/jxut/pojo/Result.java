package com.jxut.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private boolean flag;
    private Object data;
    private String msg;

    public Result(boolean flag) {
        this.flag = flag;
    }

    public Result(String msg) {
        this.flag = false;
        this.msg = msg;
    }

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
