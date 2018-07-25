package com.liyz.common.system.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.io.PrintWriter;
import java.io.StringWriter;

public class CustomExceptionMapper implements ExceptionMapper<Exception> {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionMapper.class);

    @Override
    public Response toResponse(Exception e) {
        logger.error(getStackTrace(e));
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Sorry! the requested resource has exceprion:" + getStackTrace(e)).type("text/plain").build();
    }

    private static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
