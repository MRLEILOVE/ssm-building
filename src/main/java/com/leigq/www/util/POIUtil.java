package com.leigq.www.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * POI工具类
 * 参考:
 * <ul>
 * <li>
 * <a href='https://blog.csdn.net/SmileorSilence/article/details/80535853'>Spring Boot 学习笔记 9 : EasyPoi</a>
 * </li>
 * <li>
 * <a href='https://blog.csdn.net/qq_37598011/article/details/80918565'>SpringBoot集成EsayPoi(Excel导入导出)</a>
 * </li>
 * <li>
 * <a href='http://easypoi.mydoc.io/'>官方教程</a>
 * </li>
 * </ul>
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-11-16 13:19 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
public class POIUtil {
    /**
     * 导出Excel
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-16 14:06
     * <br>
     *
     * @param list           待导出的数据
     * @param pojoClass      实体类名称,对应list中的实体
     * @param fileName       Excel文件名
     * @param title          表头
     * @param sheetName      文档sheet的名字
     * @param isCreateHeader 是否创建表头
     * @param response       response对象
     */
    public static void exportExcel(List<?> list, Class<?> pojoClass, String fileName, String title, String sheetName,
                                   boolean isCreateHeader, HttpServletResponse response) {
        ExportParams exportParams = getExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);
    }

    /**
     * 导出Excel
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-16 14:06
     * <br>
     *
     * @param list      待导出的数据
     * @param pojoClass 实体类名称,对应list中的实体
     * @param fileName  Excel文件名
     * @param title     标题
     * @param sheetName 文档sheet的名字
     * @param response  response对象
     */
    public static void exportExcel(List<?> list, Class<?> pojoClass, String fileName, String title, String sheetName,
                                   HttpServletResponse response) {
        defaultExport(list, pojoClass, fileName, response, getExportParams(title, sheetName));
    }

    /**
     * 导出Excel
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-16 14:06
     * <br>
     *
     * @param list     待导出的数据,接收Map<String, Object>
     * @param fileName Excel文件名
     * @param response response对象
     */
    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        defaultExport(list, fileName, response);
    }

    /**
     * <br>创建人： 获得导出参数
     * <br>创建时间： 2018-11-24 13:50
     * <br>
     *
     * @param title     标题
     * @param sheetName 文档sheet的名字
     * @return
     */
    private static ExportParams getExportParams(String title, String sheetName) {
        return new ExportParams(title, sheetName);
    }

    /**
     * 默认导出方法,在此方法基础上可以实现不同需求的导出
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-16 14:12
     * <br>
     *
     * @param list         待导出的数据
     * @param pojoClass    实体类名称,对应list中的实体
     * @param fileName     Excel文件名
     * @param response     response对象
     * @param exportParams 导出参数
     */
    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName,
                                      HttpServletResponse response, ExportParams exportParams) {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        downLoadExcel(fileName, response, workbook);
    }

    /**
     * 下载Excel
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-16 14:11
     * <br>
     *
     * @param fileName 文件名
     * @param response response对象
     * @param workbook workbook
     */
    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            // 设置响应实体的编码格式
            response.setCharacterEncoding("UTF-8");
            // 通知浏览器使用什么软件可以打开此文件
            response.setHeader("content-Type", "application/vnd.ms-excel");
            // 下载文件的默认名称
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 默认导出方法,在此方法基础上可以实现不同需求的导出
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-16 14:12
     * <br>
     *
     * @param list     待导出的数据,接受Map<String, Object>
     * @param fileName Excel文件名
     * @param response response对象
     */
    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        downLoadExcel(fileName, response, workbook);
    }

    /**
     * 导入Excel
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-16 14:16
     * <br>
     *
     * @param filePath   文件路径
     * @param titleRows  标题行数
     * @param headerRows 表头行数
     * @param pojoClass  实体对象
     * @param <T>实体对象
     * @return 导入的数据
     */
    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("模板不能为空");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

    /**
     * 导入Excel
     * <br>创建人： leigq
     * <br>创建时间： 2018-11-16 14:16
     * <br>
     *
     * @param file       上传的文件
     * @param titleRows  标题行数
     * @param headerRows 表头行数
     * @param pojoClass  实体对象
     * @param <T>实体对象
     * @return 导入的数据
     */
    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("excel文件不能为空");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }
}
