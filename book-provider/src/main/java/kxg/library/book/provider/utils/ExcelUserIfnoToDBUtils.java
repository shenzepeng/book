package kxg.library.book.provider.utils;


import kxg.library.book.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: mbp
 * @Date: 2019-09-04 13:41
 * @Description: 导入信息
 */
@Slf4j
public class ExcelUserIfnoToDBUtils {
    public static synchronized List<UserDto> getExcelToDb(MultipartFile multipartFile) {
        List<UserDto> userInfoBoList = new ArrayList<>();
        try {
            //原文件名
            String fileName = multipartFile.getOriginalFilename();
            InputStream inputStream = multipartFile.getInputStream();
            List<List<Cell>> bankListByExcel = ImportExcelUtil.getBankListByExcel(inputStream, fileName);
            if (!CollectionUtils.isEmpty(bankListByExcel)) {
                for (List<Cell> cellList : bankListByExcel) {
                    UserDto userInfoBo = cellListToExcelBo(cellList);
                    if (!StringUtils.isEmpty(userInfoBo.getChiinsesName()) &&
                            !StringUtils.isEmpty(userInfoBo.getWorkId()) &&
                            !StringUtils.isEmpty(userInfoBo.getPhoneNumber())) {
                        userInfoBoList.add(userInfoBo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfoBoList;
    }

    private static UserDto cellListToExcelBo(List<Cell> cellList) {
        UserDto userInfoBo = new UserDto();
        Cell cell = null;
        Cell cell1 = null;
        Cell cell2 = null;
        Cell cell3 = null;
        Cell cell4 = null;
        Cell cell5 = null;

        Cell cell6 = null;
        Cell cell7= null;
        Cell cell8 = null;

        Cell cell9 = null;
        Cell cell11 = null;
        Cell cell12 = null;

        try {
            cell = cellList.get(0);
            cell1 = cellList.get(1);
            cell2 = cellList.get(2);
             cell3 = cellList.get(3);
             cell4 = cellList.get(4);
             cell5 = cellList.get(5);

             cell6 = cellList.get(6);
             cell7= cellList.get(7);
             cell8 = cellList.get(8);

             cell9 = cellList.get(9);
             cell11 = cellList.get(10);
            log.info("cell-{},cell1-{},cell2-{}",JsonUtils.objectToJson(cell.toString()), JsonUtils.objectToJson(cell1.toString()),JsonUtils.objectToJson(cell2.toString()));
        } catch (Exception e) {
            log.info("该信息没有相关内容----{}", e.getMessage());
            throw new RuntimeException("该信息没有相关内容"+ e.getMessage());
        }

//        if (cell != null) {
//            //如何防止数字变成科学计数法的形式
//            DecimalFormat df = new DecimalFormat("0");
//            String whatYourWant = df.format(cell.getNumericCellValue());
//            userInfoBo.setNumber(whatYourWant);
//        }
        if (cell != null) {
            userInfoBo.setFirstMajor(CleanLinefeedUtils.replaceBlank(cell.toString()));
        }
        if (cell1 != null) {
            userInfoBo.setSecondMajor(CleanLinefeedUtils.replaceBlank(cell1.toString()));
        }
        if (cell2 != null) {
            DecimalFormat df = new DecimalFormat("0");
            String whatYourWant = df.format(cell2.getNumericCellValue());
            userInfoBo.setWorkId(whatYourWant);
         }
        if (cell3 != null) {
            userInfoBo.setPhoneNumber(CleanLinefeedUtils.replaceBlank(cell3.toString()));
        }
        if (cell4 != null) {
            userInfoBo.setImgUrl(CleanLinefeedUtils.replaceBlank(cell4.toString()));
        }
        if (cell5 != null) {
            userInfoBo.setChiinsesName(CleanLinefeedUtils.replaceBlank(cell5.toString()));
        }
        if (cell6 != null) {
            userInfoBo.setType(CleanLinefeedUtils.replaceBlank(cell6.toString()));
        }
        if (cell7 != null) {
            userInfoBo.setSex(CleanLinefeedUtils.replaceBlank(cell7.toString()));
        }
        if (cell8 != null) {
            userInfoBo.setIdNumber(CleanLinefeedUtils.replaceBlank(cell8.toString()));
        }
        if (cell9 != null) {
            userInfoBo.setPassword(CleanLinefeedUtils.replaceBlank(cell9.toString()));
        }
        if (cell11 != null) {
            userInfoBo.setDepartment(CleanLinefeedUtils.replaceBlank(cell11.toString()));
        }

        log.info("userInfoBo-{}",JsonUtils.objectToJson(userInfoBo));
        return userInfoBo;
    }
}
