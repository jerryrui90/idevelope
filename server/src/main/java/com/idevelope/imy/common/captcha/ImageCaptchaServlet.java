package com.idevelope.imy.common.captcha;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.idevelope.imy.util.VerifyCodeUtils;

public class ImageCaptchaServlet extends HttpServlet
{
    private static final long serialVersionUID = 8321760575924218218L;
    
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
        throws ServletException, IOException
    {
        // 禁止图像缓存
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0L);
        httpServletResponse.setContentType("image/jpeg");
        
        // 将图像输出到Servlet输出流中
        OutputStream outputStream = httpServletResponse.getOutputStream();
        
        String verfiyCode = VerifyCodeUtils.generateVerifyCode(4);
        HttpSession session = httpServletRequest.getSession(true);
        
        VerifyCodeUtils.outputImage(200, 80, outputStream, verfiyCode);
        outputStream.flush();
        outputStream.close();
    }
}