package cdu.zch.exception;

import cdu.zch.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author Zch
 * @data 2023/6/13
 **/
@Data
public class SelfException extends RuntimeException{

    private Integer code;

    private String message;

    /**
     * 通过状态码和错误消息创建异常对象
     * @param code
     * @param message
     */
    public SelfException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public SelfException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "SelfException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }

}
