package com.gupao.student.delegate.mvc;

import com.gupao.student.delegate.mvc.controller.MemberController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhuochen
 * Date: 2019/3/15
 * Time: 21:24
 * Description:
 */
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handerMapping = new ArrayList<Handler>();

    @Override
    public void init() throws ServletException {

        Class<?> memberControllerClass = MemberController.class;
        try {
            handerMapping.add(new Handler().setController(memberControllerClass.newInstance()).
                    setMethod(memberControllerClass.getMethod("getMember", new Class[]{String.class}))
                    .setUrl("/web/getMember.json"));
        } catch (InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doDispatch(req, resp);

    }

    private void doDispatch(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 获取用户传递的url
        // 每个url对应一个Servlet，url由浏览器输入
        String uri = request.getRequestURI();

        // Servlet拿到url后，要做权衡
        //根据url 找到对应的java方法。
        //通过拿到的url去hangdlerMapping（我们把他认为是策略常量）
        Handler handler = null;
        for(Handler h : handerMapping){
            if(uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }
        // 将具体的任务分发给Method（通过反射去调用对应的方法）
        Object object = null;
        try {
            object = handler.getMethod().invoke(handler.getController(), request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 获取到Method执行的结果，通过Response返回出去
        response.getWriter().write("访问的如何?");
    }

    class Handler{

        private Object controller;

        private Method method;

        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
