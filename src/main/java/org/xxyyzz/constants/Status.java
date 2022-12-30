package org.xxyyzz.constants;

import lombok.Data;


/**
 * @author Wesley
 * @create 2019-09-25 15:10
 */
@Data
public class Status {
    public static final Status OK = new Status(200, "ok");
    public static final Status ERROR = new Status(500, "internal error");

    public static final Status USER_NOT_FOUND = new Status( "User is not found!" );

//    @ApiModelProperty(example = "200")
    private final int code;
//    @ApiModelProperty(example = "ok")
    private final String message;

    public Status(String message) {
        this(400, message);
    }

    public Status(int code, String message) {
        this.code = code;
        this.message = message;
    }
}