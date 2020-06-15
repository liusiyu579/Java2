package liusiyu.servlet;

import liusiyu.dao.ArticleDAO;
import liusiyu.exception.BusinessException;
import liusiyu.model.Article;
import liusiyu.uti.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // 文章修改：包含id content userAccount
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is,Article.class);
        System.out.println("==========================================\n"+article);
        int num = ArticleDAO.insert(article);
        if(num != 1){
            throw new BusinessException("001","插入文章错误");
        }
        // 模拟数据库插入数据操作

        return null;
    }
}
