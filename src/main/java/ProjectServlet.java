import course.Project;
import db_connection.Connector;
import db_connection.CourseDatabase;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/create-project")
public class ProjectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        String path = "C:\\Users\\Sibonelo Njokweni\\IdeaProjects\\ukzn-projects-management-and-allocation\\uploads\\";
        try {
            List<FileItem> files = fileUpload.parseRequest(req);

            for (FileItem item : files) {
                item.write(new File(path + item.getName()));
            }
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String moduleName = req.getParameter("moduleName");
        String description = req.getParameter("description");

        CourseDatabase _db = new CourseDatabase(Connector.getConnection());

        Project project = new Project(moduleName, path, description);
        if(_db.addProject(project)){
            resp.sendRedirect("success.jsp");
        }else{
            resp.sendRedirect("create-project.jsp");
        }
    }
}
