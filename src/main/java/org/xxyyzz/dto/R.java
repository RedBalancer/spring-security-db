package org.xxyyzz.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.xxyyzz.constants.Status;

/**
 * @author Chunlong Zhang
 * @version 1.0.0
 * @ClassName R.java
 * @Description @TODO
 * @createTime 2022年12月27日 15:31:00
 */
@Data
public class R<T> {
    private Status status;
    private T data;


    private R(Status status) {
        this.status = status;
    }

    protected R(Status status, T data) {
        this.status = status;
        this.data = data;
    }

    public static R ok() {
        return new R<>(Status.OK);
    }

    public static <T> R ok(T data) {
        return new R<>(Status.OK, data);
    }

    public static R fail(Status status) {
        return new R<>(status);
    }

    public static R fail() {
        return new R<>(Status.ERROR);
    }
}