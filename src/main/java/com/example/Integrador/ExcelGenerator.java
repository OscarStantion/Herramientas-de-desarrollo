package com.example.Integrador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {

    // Recibe una matriz de String (primer fila para cabeceras y las siguientes para los datos)
    public static byte[] generateExcel(String[][] tableData) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Registro de Pago");

        // Llena la hoja con los datos
        for (int i = 0; i < tableData.length; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < tableData[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(tableData[i][j]);
            }
        }

        // Ajusta automáticamente el tamaño de las columnas
        for (int i = 0; i < tableData[0].length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        workbook.close();
        return baos.toByteArray();
    }
}