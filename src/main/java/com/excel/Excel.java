package com.excel;

import com.pojo.User;
import com.service.UserService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class Excel {

    @Autowired
    private UserService userService;

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


    @RequestMapping("/exportUserList")
    public void exportUserList(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=export.xls");
        //得到数据
        List<User> list = userService.selectUserList();
        //创建excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = workbook.createSheet("sheet0");
        //创建title
        HSSFRow row = sheet.createRow(0);
        for(int i=0;i<title.length;i++){
            row.createCell(i).setCellValue(title[i]);
        }
        //追加数据
        for(int i=0;i<list.size();i++){
            HSSFRow row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(list.get(i).getId());
            row1.createCell(1).setCellValue(list.get(i).getName());
            row1.createCell(2).setCellValue(list.get(i).getAge());
            row1.createCell(3).setCellValue(list.get(i).getBirthday());
            row1.createCell(4).setCellValue(list.get(i).getAddress());
            row1.createCell(5).setCellValue(list.get(i).getDesc());
        }
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
