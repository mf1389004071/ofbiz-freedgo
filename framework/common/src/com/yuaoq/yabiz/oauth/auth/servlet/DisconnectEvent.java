package com.yuaoq.yabiz.oauth.auth.servlet;

import com.yuaoq.yabiz.oauth.auth.AuthenticationHelper;
import com.yuaoq.yabiz.oauth.broker.servlet.ServletRequestResponseBroker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class DisconnectEvent {
    
     
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    public  static String  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        return "success";
    }
    
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    public  static String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthenticationHelper ah = new AuthenticationHelper(new ServletRequestResponseBroker(request, response));
        ah.handleDisconnect();
        return "success";
    }
}
