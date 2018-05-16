package com.gy.shop.shopapi.exception;
import com.gy.shop.shopapi.utils.response.BaseResponse;
import com.gy.shop.shopapi.utils.response.HttpResponseAndStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author yuit
 * @date 2018/2/23
 * @description 异常统一处理
 */

@ControllerAdvice
public class ExceptionAdviceHandler {

    private Logger logger = Logger.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse unKnowExceptionHandler(Exception ex) {

        ex.printStackTrace();
        logger.info("------------->" + ex.getClass());
        return HttpResponseAndStatus.baseResponse(1001, ex.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public BaseResponse runtimeExceptionHandler(RuntimeException ex) {
        ex.printStackTrace();
        logger.info("---------->" + ex.getLocalizedMessage());
        return HttpResponseAndStatus.baseResponse(1002, ex.getMessage());
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public BaseResponse nullPointerExceptionHandler(NullPointerException ex) {
        ex.printStackTrace();
        return HttpResponseAndStatus.baseResponse(1004, ex.getMessage());
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public BaseResponse classCastExceptionHandler(ClassCastException ex) {
        ex.printStackTrace();
        return HttpResponseAndStatus.baseResponse(1003, ex.getMessage());
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public BaseResponse iOExceptionHandler(IOException ex) {
        ex.printStackTrace();
        return HttpResponseAndStatus.baseResponse(1005, ex.getMessage());
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public BaseResponse noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        ex.printStackTrace();
        return HttpResponseAndStatus.baseResponse(1006, ex.getMessage());
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public BaseResponse indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        ex.printStackTrace();
        return HttpResponseAndStatus.baseResponse(1007, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public BaseResponse requestNotReadable(HttpMessageNotReadableException ex) {
        ex.printStackTrace();
        return HttpResponseAndStatus.baseResponse(400, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public BaseResponse requestTypeMismatch(TypeMismatchException ex) {
        ex.printStackTrace();
        return HttpResponseAndStatus.baseResponse(400, ex.getMessage());
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public BaseResponse requestMissingServletRequest(MissingServletRequestParameterException ex) {
        ex.printStackTrace();
        return HttpResponseAndStatus.baseResponse(400, null);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        return HttpResponseAndStatus.baseResponse(400, ex.getMessage());
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public BaseResponse request405() {
        return HttpResponseAndStatus.baseResponse(405);
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public BaseResponse request406() {
        return HttpResponseAndStatus.baseResponse(406);
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseBody
    public BaseResponse server500(HttpMessageNotWritableException ex) {

        logger.info("---------->:"+ex.getMessage());

        return HttpResponseAndStatus.baseResponse(406);
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public BaseResponse httpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException ex) {
        return HttpResponseAndStatus.baseResponse(415, ex.getMessage());
    }


    @ExceptionHandler(value = ArgumentsException.class)
    @ResponseBody
    public BaseResponse argsErrorExceptionHandler(ArgumentsException ex) {
        return HttpResponseAndStatus.baseResponse(400, ex.getMessage());
    }

    @ExceptionHandler(value = ServerErrorException.class)
    @ResponseBody
    public BaseResponse serverErrorExceptionHandler(ServerErrorException ex) {
        return HttpResponseAndStatus.baseResponse(500, ex.getMessage());
    }
}
