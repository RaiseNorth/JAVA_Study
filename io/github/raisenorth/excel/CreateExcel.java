package io.github.raisenorth.excel;

import java.util.List;
import java.io.File;
//import java.util.Date;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import io.github.raisenorth.studentsort.*;
//import jxl.write.Number;
//import jxl.write.DateTime;

//注意：因为我偷懒，该类只可配合io.github.raisenorth.studentsort.StudentSort使用
//需要外部包jxl，具体下载地址请百度
public class CreateExcel {
    public static int ListInExcel(List<Student> listS) {
        try {
            // 打开文件
            WritableWorkbook book = Workbook.createWorkbook(new File("Student.xls"));
            // 生成名为“sheet1”的工作表，参数0表示这是第一页
            WritableSheet sheet = book.createSheet("sheet1", 0);
            // 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string
            Label label = new Label(0, 0, "排名");
            // 将定义好的单元格添加到工作表中
            sheet.addCell(label);
            Label label1 = new Label(1, 0, "学号");
            sheet.addCell(label1);
            Label label2 = new Label(2, 0, "姓名");
            sheet.addCell(label2);
            Label label3 = new Label(3, 0, "分数");
            sheet.addCell(label3);
            for (int i = 0; i < listS.size(); i++) {
                Label l1 = new Label(0, i + 1, String.format("%4d", i + 1));
                sheet.addCell(l1);
                Label l2 = new Label(1, i + 1, String.format("%03d", listS.get(i).getId()));
                sheet.addCell(l2);
                Label l3 = new Label(2, i + 1, listS.get(i).getName());
                sheet.addCell(l3);
                Label l4 = new Label(3, i + 1, String.format("%3d", listS.get(i).getScore()));
                sheet.addCell(l4);
            }
            book.write();
            book.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

}