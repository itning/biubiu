package sl.itcast.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileUpDownLoadUtils {
    private static FileItemFactory factory = new DiskFileItemFactory();

    public static Map<String,String> FileUpLoad(HttpServletRequest request,String id) {
        Map<String,String> map=new LinkedHashMap<>();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> list = upload.parseRequest(request);
                for (FileItem item : list) {
                    if (item.isFormField()){
                        map.put(item.getFieldName(), item.getString());
                    }else  {
                        String name = item.getName();
                        System.out.println(name);
                        String[] split =name.split("\\.");
                        //String split = name.substring(name.lastIndexOf(".")+1);
                        int length = split.length;
                        name=id+"."+split[length-1];
                        map.put(item.getFieldName(),name);
                        String path="D:\\img";
                        File file = new File(path,name);
                        // 工具类，文件上传
                        item.write(file);
                        item.delete();   //删除系统产生的临时文件
                        System.out.println();
                    }
                }
                return map;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("不是表单元素！");
        }
        return null;
    }
}
