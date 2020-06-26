package kxg.library.book.provider.utils;

import kxg.library.book.dto.BookDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.security.acl.LastOwnerException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2020/4/1 13:56
 * @Description: 题目信息导入？
 * */
@Slf4j
@Component
public class ExcelBookInfoToDBUtils {
    public static  List<BookDto> getExcelToDb(MultipartFile multipartFile) {
        List<BookDto> bookDtoList = new ArrayList<>();
        try {
            //原文件名
            String fileName = multipartFile.getOriginalFilename();
            InputStream inputStream = multipartFile.getInputStream();
            List<List<Cell>> bankListByExcel = ImportExcelUtil.getBankListByExcel(inputStream, fileName);
            log.info("bankListByExcel {}" ,bankListByExcel.size());
            if (!CollectionUtils.isEmpty(bankListByExcel)){
                for (List<Cell> cellList:bankListByExcel){
                    BookDto bookDto = cellListToExcelBo(cellList);
                    if (!StringUtils.isEmpty(bookDto.getBookName())&&
                    !StringUtils.isEmpty(bookDto.getAuthor())) {
                        bookDtoList.add(bookDto);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookDtoList;
    }


    private static BookDto cellListToExcelBo(List<Cell> cellList){
        log.info("cell info {}",cellList);
        BookDto bookDto=new BookDto();
        try {
            Cell cell = null;
            Cell cell1 = null;
            Cell cell2=null;
            Cell cell3=null;
            Cell cell4=null;
            Cell cell5=null;
            Cell cell6=null;
            Cell cell7=null;
            Cell cell8=null;
            try  {
                cell = cellList.get(0);
                cell1 = cellList.get(1);
                cell2=cellList.get(2);
                cell3=cellList.get(3);
                cell4=cellList.get(4);
                cell5=cellList.get(5);
                cell6=cellList.get(6);
                cell7=cellList.get(7);
                cell8=cellList.get(8);
            }catch (Exception e){
                log.info("该信息没有相关内容----{}",e.getMessage());
                throw new RuntimeException("该信息没有相关内容"+ e.getMessage());
            }

            if (cell!=null){
                bookDto.setBookName(CleanLinefeedUtils.replaceBlank(cell.toString()));
            }
            if (cell1!=null){
                System.out.println(cell1);
                double parseDouble = Double.parseDouble(cell1.toString());
                System.out.println(parseDouble);
                bookDto.setBookSize((int)(parseDouble));
            }
            if (cell2!=null){
                bookDto.setBookGrades(CleanLinefeedUtils.replaceBlank(cell2.toString()));
            }
            if (cell3!=null){
                bookDto.setHabbitType(CleanLinefeedUtils.replaceBlank(cell3.toString()));
            }
            if (cell4!=null){
                bookDto.setSupportMajor(CleanLinefeedUtils.replaceBlank(cell4.toString()));
            }
            if (cell5!=null){
                bookDto.setAuthor(CleanLinefeedUtils.replaceBlank(cell5.toString()));
            }
            if (cell6!=null){
                bookDto.setLanguage(CleanLinefeedUtils.replaceBlank(cell6.toString()));
            }
            if (cell7!=null){
                bookDto.setImgUrl(CleanLinefeedUtils.replaceBlank(cell7.toString()));
            }
            if (cell8!=null){
                bookDto.setPreice(CleanLinefeedUtils.replaceBlank(cell8.toString()));
            }
            log.info("bookDto-{}",JsonUtils.objectToJson(bookDto));
        }catch (Exception e){
            log.info("excel exception {}",e);
        }

        return bookDto;
    }
}
