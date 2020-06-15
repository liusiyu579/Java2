package liusiyu.servlet;

import liusiyu.exception.BaseException;
import liusiyu.model.Result;
import liusiyu.uti.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractBaseServlet extends HttpServlet {

    public static final ConcurrentMap<String,Integer> MAP = new ConcurrentHashMap<>();

    public static final ConcurrentMap<String, AtomicInteger> MAP2 = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");

        // 前端约定好统一返回的json数据格式
        Result result = new Result();
        try {
            // 正确返回业务数据
            Object data = process(req,resp);
            result.setSuccess(true);
            result.setData(data);
        }catch (Exception e){
            if(e instanceof BaseException){
                BaseException be = (BaseException) e;
                result.setMessage("错误码："+be.getCode()+"错误信息："+be.getMessage());
            }else {
                result.setMessage("服务器异常：未知错误");
            }
            // 捕获到异常 需要设置前端需要错误信息和堆栈信息
            StringWriter sw = new StringWriter();
            PrintWriter epw = new PrintWriter(sw);
            e.printStackTrace(epw);
            result.setStackTrace(sw.toString());
        }

        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(result));
        pw.flush();

        // 方法一：通过加锁保证线程安全
        synchronized (MAP) {
            String path = req.getServletPath();
            Integer count = MAP.get(path);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            MAP.put(path, count);
        }

        // 方法二：通过 AtomicInteger结合 ConcurrentHashMap保证线程安全
        String path = req.getServletPath();
        AtomicInteger count = MAP2.putIfAbsent(path,new AtomicInteger(1));
        if(count != null) {
            count.incrementAndGet();
        }

    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    public static ConcurrentMap<String, Integer> getMAP() {
        return MAP;
    }

    public static ConcurrentMap<String, AtomicInteger> getMAP2() {
        return MAP2;
    }
}
