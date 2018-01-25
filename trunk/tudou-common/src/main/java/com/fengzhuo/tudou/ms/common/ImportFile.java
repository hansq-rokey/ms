package com.fengzhuo.tudou.ms.common;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsq 16:58 2018/1/23
 * 批量导入demo
 */
public class ImportFile {
    /**
     * @param cell 一个单元格的对象
     * @return 返回该单元格相应的类型的值
     */
    public static String getRightTypeCell(Cell cell){
        cell.setCellType(Cell.CELL_TYPE_STRING);
        return cell.getStringCellValue();
    }
    /**
     * 读取出filePath中的所有数据信息
     * @param filePath excel文件的绝对路径
     */
    public static void getDataFromExcel2(String filePath,Person person){
        //判断是否为excel类型文件
        if(!filePath.endsWith(".xls")&&!filePath.endsWith(".xlsx")){
            System.out.println("文件不是excel类型");
        }
        FileInputStream fis =null;
        Workbook wookbook = null;
        int lineNum = 0;
        Sheet sheet = null;
        try{
            //获取一个绝对地址的流
            fis = new FileInputStream(filePath);
            //2003版本的excel，用.xls结尾, 2007版本以.xlsx
            if(filePath.endsWith(".xls")){
                wookbook = new HSSFWorkbook(fis);//得到工作簿
            }else{
                wookbook = new XSSFWorkbook(fis);//得到工作簿
            }
            //得到一个工作表
            sheet = wookbook.getSheetAt(0);
            //获得表头
            Row rowHead = sheet.getRow(0);
            //列数
            int rows = rowHead.getPhysicalNumberOfCells();
            //行数
            lineNum = sheet.getLastRowNum();
            if(0 == lineNum){
                System.out.println("Excel内没有数据！");
            }
            getData(sheet, lineNum, rows, person);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static  void  getData(Sheet sheet, int lineNum, int rowNum, Person person){
        //获得所有数据
        for(int i = 1; i <= lineNum; i++){
            //获得第i行对象
            Row row = sheet.getRow(i);
            List<String> list = new ArrayList<>();
            for(int j=0; j<rowNum; j++){
                String str = getRightTypeCell(row.getCell(j));
                list.add(str);
            }
            person.setName(list.get(0));
            person.setAge(Integer.valueOf(list.get(1)));
            person.setPwd(list.get(2));
            System.out.println(person.toString());
        }
    }
    public static void main(String[] arg){
        Person person = new Person();
        getDataFromExcel2("E:\\sss.xlsx", person);
    }
}
