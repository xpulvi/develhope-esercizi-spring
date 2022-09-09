package middleware.e_interceptor02.interseptor;

import middleware.e_interceptor02.controlers.MonthController;
import middleware.e_interceptor02.entity.Month;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

   public static List<Month> monthList = new ArrayList<>(Arrays.asList(
      new Month(1,"January","gennaio","Januar"),
      new Month(2,"February","febraio","Februar"),
      new Month(3,"March","marzo","Marsch"),
      new Month(4,"April","aprile","April"),
      new Month(5,"May","maggio","Kann"),
      new Month(6,"June","giugno","Juni")
   ));


   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

      String monthNumber = request.getHeader("monthNumber");
      if (monthNumber == null || monthNumber.isBlank()){
         response.setStatus(HttpStatus.BAD_REQUEST.value());
         return false;
      }
      int monthN; try {
         monthN = Integer.parseInt(monthNumber);
      }catch (NumberFormatException e){
         response.setStatus(HttpStatus.BAD_REQUEST.value());
         return false;
      }
      for (Month e: monthList) {
         if (monthN == e.getMonthNumber()){
            request.setAttribute("month",e);
         return true;
         }
      }
      request.setAttribute("month", new Month(0,"not","not","not"));
      return true;
   }

   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

   }

   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

   }

}
