package io.github.raisenorth.studentsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import io.github.raisenorth.excel.CreateExcel;

public class StudentSort {
  public static void main(String[] args) {
    System.out.println("请输入姓名 学号 分数，以空格隔开，输入OK并回车以结束输入。\n");
    List<Student> listS = new ArrayList<Student>();
    String name, input;
    Integer id, score;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 999; i++) {// 学号三位数，上限999人
      input = sc.nextLine();// 获取用户输入
      if (input.equals("ok") || input.equals("OK")) {// 输入ok或OK就终止输入
        break;
      }
      String[] strArr = input.split(" ");// 将用户输入以字符串的形式保存到数组
      name = strArr[0];
      try {
        id = Integer.parseInt(strArr[1]);
      } catch (ArrayIndexOutOfBoundsException e1) {// 下面是可能遇到的两种异常的处理，均为continue循环
        i--;
        continue;
      } catch (NumberFormatException e2) {
        i--;
        continue;
      }
      try {
        score = Integer.parseInt(strArr[2]);
      } catch (ArrayIndexOutOfBoundsException e3) {
        i--;
        continue;
      } catch (NumberFormatException e4) {
        i--;
        continue;
      }
      listS.add(new Student(name, id, score));// 装入集合
    }
    sc.close();

    Collections.sort(listS);// list中的对象实现Comparable接口
    System.out.println("排名  学号 姓名                          分数");
    for (int i = 0; i < listS.size(); i++)
      System.out.printf("%4d %s\n", i + 1, listS.get(i));
    CreateExcel.ListInExcel(listS);//生成excel文件，去掉则不生成。
  }
}