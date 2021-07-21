package com.example.Eridanus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class EridanusErrorController implements ErrorController {

    private static final Logger LOGGER= LoggerFactory.getLogger(EridanusErrorController.class);

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        LOGGER.error("Error detected. STATUS: " + status);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                LOGGER.info("Diverted to error-404");
                return "error-404";
            } else {
                return "error";
            }
        }
        LOGGER.info("Error handling didn't enter if statement");
        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
