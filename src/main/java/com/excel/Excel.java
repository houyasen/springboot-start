package com.excel;

import com.pojo.User;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class Excel {

    private static final String[] title = {"id","name","age","birthday","address","desc"};

    private static final List<User> list = new ArrayList<>();

    @RequestMapping("/jxlWriteExcel")
    public static void main(String[] args) {
        //创建Excel文件
        File file = new File("D:/test.xls");
        try {
            file.createNewFile();
            //创建工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            //创建sheet
            WritableSheet sheet1 = workbook.createSheet("sheet1", 0);
            //创建表title
            Label label = null;
            for(int i=0;i<title.length;i++){
                label = new Label(i,0,title[i]);
                sheet1.addCell(label);
            }
            //追加数据
            for(int i=1;i<11;i++){
                list.add(new User(i,"hys"+i,i,new Date(),"运城"+i,"太帅"+i));
            }
            for(int i=0;i<list.size();i++){
                label = new Label(0,i+1,list.get(i).getId()+"");
                sheet1.addCell(label);
                label = new Label(1,i+1,list.get(i).getName());
                sheet1.addCell(label);
                label = new Label(2,i+1,list.get(i).getAge()+"");
                sheet1.addCell(label);
                label = new Label(3,i+1,list.get(i).getBirthday()+"");
                sheet1.addCell(label);
                label = new Label(4,i+1,list.get(i).getAddress());
                sheet1.addCell(label);
                label = new Label(5,i+1,list.get(i).getDesc());
                sheet1.addCell(label);
            }
            //写入数据
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
