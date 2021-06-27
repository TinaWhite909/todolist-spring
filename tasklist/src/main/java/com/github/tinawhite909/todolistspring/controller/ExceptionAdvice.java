package com.github.tinawhite909.todolistspring.controller;

import com.github.tinawhite909.todolistspring.bean.Response;
import com.github.tinawhite909.todolistspring.exception.TaskServiceRuntimeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TaskServiceRuntimeException.class)
    public String handleException(TaskServiceRuntimeException e, Model model) {
        Response response = new Response(e.getMessage());
        model.addAttribute("except", e.getMessage());
        return "exception";
    }
}

