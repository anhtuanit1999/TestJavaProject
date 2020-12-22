package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.GiaoVien;
import entity.LuanVan;
import entity.SinhVien;

public class GhiFileDao {
	public static final int COLUMN_INDEX_STT        		= 0;
	public static final int COLUMN_INDEX_MASINHVIEN 		= 1;
	public static final int COLUMN_INDEX_HOTEN      		= 2;
	public static final int COLUMN_INDEX_NGAYSINH      		= 3;
	public static final int COLUMN_INDEX_SODIENTHOAI   		= 4;
	public static final int COLUMN_INDEX_DIACHI      		= 5;
	public static final int COLUMN_INDEX_KHOATRUCTHUOC 		= 6;
	public static final int COLUMN_INDEX_NAMVAOTRUONG  		= 7;
	public static final int COLUMN_INDEX_NAMTOTNGHIEP		= 8;
	public static final int COLUMN_INDEX_MANHOM    			= 9;
	
	public static final int COLUMN_INDEX_MAGIAOVIEN 		= 1;
	public static final int COLUMN_INDEX_CHUCDANH 			= 3;
	public static final int COLUMN_INDEX_LINHVUCCONGTAC		= 4;
	public static final int COLUMN_INDEX_DONVICONGTAC 		= 5;
	public static final int COLUMN_INDEX_KHOACONGTAC 		= 6;
	
	public static final int COLUMN_INDEX_MALUANVAN		 	= 1;
	public static final int COLUMN_INDEX_TENLUANVAN		 	= 2;
	public static final int COLUMN_INDEX_LINHVUCNGHIENCUU 	= 3;
	public static final int COLUMN_INDEX_NGAYLAP	 		= 4;
	public static final int COLUMN_INDEX_MOTA 				= 5;
	public static final int COLUMN_INDEX_MAGIAOVIENRADE 	= 6;
	public static final int COLUMN_INDEX_SONHOMTOIDA 		= 7;
	private static CellStyle cellStyleFormatNumber = null;
	
//	public static void main(String[] args) throws IOException, ParseException {
//		GhiFileDao ghiFileDao = new GhiFileDao();
//		Database.getInstance().connec();
//		SinhVienDao sinhVienDao = new SinhVienDao();
//		GiaoVienDao giaoVienDao = new GiaoVienDao();
//		LuanVanDao luanVanDao = new LuanVanDao();
//		String fileName = "C:\\Users\\AnhTuanIT\\Desktop\\test.xlsx";
//		ghiFileSinhVien(sinhVienDao.docTuBang(), "C:\\Users\\AnhTuanIT\\Desktop\\testSV.xlsx");
//		ghiFileGiaoVien(giaoVienDao.docTuBang(), "C:\\Users\\AnhTuanIT\\Desktop\\testGV.xlsx");
//		ghiFileLuanVan(luanVanDao.docTuBang(), "C:\\Users\\AnhTuanIT\\Desktop\\testLV.xlsx");
//	}
	
	public List<LuanVan> docFileLuanVan(String excelFilePath) throws IOException, ParseException {
		List<LuanVan> list = new ArrayList<>();
 
		// Get file
		InputStream inputStream = new FileInputStream(new File(excelFilePath));
 
		// Get workbook
		Workbook workbook = getWorkbook(inputStream, excelFilePath);
 
		// Get sheet
		Sheet sheet = workbook.getSheetAt(0);
 
		// Get all rows
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				// Ignore header
				if(!kiemTraFileLuanVan(nextRow)) {
					return list;
				}
				continue;
			}
 
			// Get all cells
			Iterator<Cell> cellIterator = nextRow.cellIterator();
 
			// Read cells and set value for book object
			LuanVan lv = new LuanVan();
			while (cellIterator.hasNext()) {
				//Read cell
				Cell cell = cellIterator.next();
				Object cellValue = getCellValue(cell);
				if (cellValue == null || cellValue.toString().isEmpty()) {
					continue;
				}
				// Set value for book object
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex) {
				case COLUMN_INDEX_MALUANVAN:
					lv.setMaLuanVan(cellValue + "");
					break;
                case COLUMN_INDEX_TENLUANVAN:
                	lv.setTenLuanVan(cellValue + "");
                	break;
                case COLUMN_INDEX_LINHVUCNGHIENCUU:
                    lv.setLinhVucNghienCuu(cellValue + "");
                    break;
                case COLUMN_INDEX_NGAYLAP:
                    lv.setNgayLap(new SimpleDateFormat("yyyy-MM-dd").parse(cellValue + ""));
                    break;
                case COLUMN_INDEX_MOTA:
                    lv.setMoTa(cellValue + "");
                    break;
                case COLUMN_INDEX_MAGIAOVIENRADE:
                    lv.setMaGiaoVien(cellValue + "");
                    break;
                case COLUMN_INDEX_SONHOMTOIDA:
                    lv.setSoNhomThamGiaToiDa(new BigDecimal((double) cellValue).intValue());
                    break;
                default:
                	break;
				}
			}
			list.add(lv);
		}
 
		workbook.close();
		inputStream.close();
 
		return list;
	}
	
	public List<GiaoVien> docFileGiaoVien(String excelFilePath) throws IOException {
		List<GiaoVien> list = new ArrayList<>();
 
		// Get file
		InputStream inputStream = new FileInputStream(new File(excelFilePath));
 
		// Get workbook
		Workbook workbook = getWorkbook(inputStream, excelFilePath);
 
		// Get sheet
		Sheet sheet = workbook.getSheetAt(0);
 
		// Get all rows
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				// Ignore header
				if(!kiemTraFileGiaoVien(nextRow)) {
					return list;
				}
				continue;
			}
 
			// Get all cells
			Iterator<Cell> cellIterator = nextRow.cellIterator();
 
			// Read cells and set value for book object
			GiaoVien gv = new GiaoVien();
			while (cellIterator.hasNext()) {
				//Read cell
				Cell cell = cellIterator.next();
				Object cellValue = getCellValue(cell);
				if (cellValue == null || cellValue.toString().isEmpty()) {
					continue;
				}
				// Set value for book object
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex) {
				case COLUMN_INDEX_MAGIAOVIEN:
					gv.setMaGiaoVien(cellValue + "");
					break;
                case COLUMN_INDEX_HOTEN:
                	gv.setHoTen(cellValue + "");
                	break;
                case COLUMN_INDEX_CHUCDANH:
                    gv.setChucDanh(cellValue + "");
                    break;
                case COLUMN_INDEX_LINHVUCCONGTAC:
                    gv.setLinhVucCongTac(cellValue + "");
                    break;
                case COLUMN_INDEX_DONVICONGTAC:
                    gv.setDonViCongTac(cellValue + "");
                    break;
                case COLUMN_INDEX_KHOACONGTAC:
                    gv.setKhoaCongTac(cellValue + "");
                    break;
                default:
                	break;
				}
 
			}
			list.add(gv);
		}
 
		workbook.close();
		inputStream.close();
 
		return list;
	}
	
	public List<SinhVien> docFileSinhVien(String excelFilePath) throws IOException {
		List<SinhVien> list = new ArrayList<>();
 
		// Get file
		InputStream inputStream = new FileInputStream(new File(excelFilePath));
 
		// Get workbook
		Workbook workbook = getWorkbook(inputStream, excelFilePath);
 
		// Get sheet
		Sheet sheet = workbook.getSheetAt(0);
 
		// Get all rows
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				// Ignore header
				if(!kiemTraFileSinhVien(nextRow)) {
					return list;
				}
				continue;
			}
 
			// Get all cells
			Iterator<Cell> cellIterator = nextRow.cellIterator();
 
			// Read cells and set value for book object
			SinhVien sv = new SinhVien();
			while (cellIterator.hasNext()) {
				//Read cell
				Cell cell = cellIterator.next();
				Object cellValue = getCellValue(cell);
				if (cellValue == null || cellValue.toString().isEmpty()) {
					continue;
				}
				// Set value for book object
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex) {
				case COLUMN_INDEX_MASINHVIEN:
					sv.setMaSinhVien(cellValue + "");
					break;
                case COLUMN_INDEX_HOTEN:
                	sv.setHoTen(cellValue + "");
                	break;
                case COLUMN_INDEX_NGAYSINH:
                    sv.setNgaySinh(cellValue + "");
                    break;
                case COLUMN_INDEX_SODIENTHOAI:
                    sv.setSoDienThoai(cellValue + "");
                    break;
                case COLUMN_INDEX_DIACHI:
                    sv.setDiaChi(cellValue + "");
                    break;
                case COLUMN_INDEX_KHOATRUCTHUOC:
                    sv.setKhoaTrucThuoc(cellValue + "");
                    break;
                case COLUMN_INDEX_NAMVAOTRUONG:
                    sv.setNamVaoTruong(new BigDecimal((double) cellValue).intValue());
                    break;
                case COLUMN_INDEX_NAMTOTNGHIEP:
                    sv.setNamTotNghiep(new BigDecimal((double) cellValue).intValue());
                    break;
                default:
                	break;
				}
 
			}
			sv.setMaNhom(null);
			list.add(sv);
		}
 
		workbook.close();
		inputStream.close();
 
		return list;
	}
 
	// Get Workbook
	private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;
		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}
 
		return workbook;
	}
 
	// Get cell value
	private static Object getCellValue(Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		Object cellValue = null;
		switch (cellType) {
		case BOOLEAN:
			cellValue = cell.getBooleanCellValue();
			break;
		case FORMULA:
			Workbook workbook = cell.getSheet().getWorkbook();
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			cellValue = evaluator.evaluate(cell).getNumberValue();
			break;
		case NUMERIC:
			cellValue = cell.getNumericCellValue();
			break;
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case _NONE:
		case BLANK:
		case ERROR:
			break;
		default:
			break;
		}
 
		return cellValue;
	}
	
	public static void ghiFileLuanVan(List<LuanVan> list, String excelFilePath) throws IOException {
		// Create Workbook
		Workbook workbook = getWorkbook(excelFilePath);
	
		// Create sheet
		Sheet sheet = workbook.createSheet("Test"); // Create sheet with sheet name
	 
		int rowIndex = 0;
		
		// Write header
		writeHeaderLV(sheet, rowIndex);
	 
		// Write data
		rowIndex++;
		for (LuanVan lv : list) {
		// Create row
		Row row = sheet.createRow(rowIndex);
		// Write data on row
		ghiLuanVan(lv, row);
		rowIndex++;
		}
		
		// Write footer
//		writeFooter(sheet, rowIndex);
	 
		// Auto resize column witdth
		int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
		autosizeColumn(sheet, numberOfColumn);
	 
		// Create file excel
		createOutputFile(workbook, excelFilePath);
		System.out.println("Done!!!");
	}
	
	public static void ghiFileGiaoVien(List<GiaoVien> list, String excelFilePath) throws IOException {
		// Create Workbook
		Workbook workbook = getWorkbook(excelFilePath);
	
		// Create sheet
		Sheet sheet = workbook.createSheet("Test"); // Create sheet with sheet name
	 
		int rowIndex = 0;
		
		// Write header
		writeHeaderGV(sheet, rowIndex);
	 
		// Write data
		rowIndex++;
		for (GiaoVien gv : list) {
		// Create row
		Row row = sheet.createRow(rowIndex);
		// Write data on row
		ghiGiaoVien(gv, row);
		rowIndex++;
		}
		
		// Write footer
//		writeFooter(sheet, rowIndex);
	 
		// Auto resize column witdth
		int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
		autosizeColumn(sheet, numberOfColumn);
	 
		// Create file excel
		createOutputFile(workbook, excelFilePath);
		System.out.println("Done!!!");
	}
	
	 public static void ghiFileSinhVien(List<SinhVien> list, String excelFilePath) throws IOException {
		// Create Workbook
		Workbook workbook = getWorkbook(excelFilePath);
	
		// Create sheet
		Sheet sheet = workbook.createSheet("Test"); // Create sheet with sheet name
	 
		int rowIndex = 0;
		
		// Write header
		writeHeaderSV(sheet, rowIndex);
	 
		// Write data
		rowIndex++;
		for (SinhVien sv : list) {
		// Create row
		Row row = sheet.createRow(rowIndex);
		// Write data on row
		ghiSinhVien(sv, row);
		rowIndex++;
		}
		
		// Write footer
//		writeFooter(sheet, rowIndex);
	 
		// Auto resize column witdth
		int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
		autosizeColumn(sheet, numberOfColumn);
	 
		// Create file excel
		createOutputFile(workbook, excelFilePath);
		System.out.println("Done!!!");
	}
	// Create workbook
	private static Workbook getWorkbook(String excelFilePath) throws IOException {
		Workbook workbook = null;
		 
		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}
		return workbook;
	}
	
	public boolean kiemTraFileLuanVan(Row row) {
		// Get all cells
		Iterator<Cell> cellIterator = row.cellIterator();
		
		while (cellIterator.hasNext()) {
			//Read cell
			Cell cell = cellIterator.next();
			Object cellValue = getCellValue(cell);
			if (cellValue == null || cellValue.toString().isEmpty()) {
				continue;
			}
			// Set value for book object
			int columnIndex = cell.getColumnIndex();
			switch (columnIndex) {
			case COLUMN_INDEX_MALUANVAN:
				if(!cellValue.toString().equals("Mã luận văn")) {
					return false;
				}
				break;
			case COLUMN_INDEX_TENLUANVAN:
				if(!cellValue.toString().equals("Tên luận văn")) {
					return false;
				}
				break;
			case COLUMN_INDEX_LINHVUCNGHIENCUU:
				if(!cellValue.toString().equals("Lĩnh vực nghiên cứu")) {
					return false;
				}
				break;
			case COLUMN_INDEX_NGAYLAP:
				if(!cellValue.toString().equals("Ngày lập")) {
					return false;
				}
				break;
			case COLUMN_INDEX_MOTA:
				if(!cellValue.toString().equals("Mô tả")) {
					return false;
				}
				break;
			case COLUMN_INDEX_MAGIAOVIENRADE:
				if(!cellValue.toString().equals("Mã giáo viên ra đề tài")) {
					return false;
				}
				break;
			case COLUMN_INDEX_SONHOMTOIDA:
				if(!cellValue.toString().equals("Số nhóm tham gia tối đa")) {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return true;
	}
	
	// Write header with format
	private static void writeHeaderLV(Sheet sheet, int rowIndex) {
		// create CellStyle
		CellStyle cellStyle = createStyleForHeader(sheet);
		
		// Create row
		Row row = sheet.createRow(rowIndex);
		
		// Create cells
		Cell cell = row.createCell(COLUMN_INDEX_STT);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("STT");
		
		cell = row.createCell(COLUMN_INDEX_MALUANVAN);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Mã luận văn");
 
		cell = row.createCell(COLUMN_INDEX_TENLUANVAN);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Tên luận văn");
 
		cell = row.createCell(COLUMN_INDEX_LINHVUCNGHIENCUU);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Lĩnh vực nghiên cứu");

		cell = row.createCell(COLUMN_INDEX_NGAYLAP);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Ngày lập");
		
		cell = row.createCell(COLUMN_INDEX_MOTA);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Mô tả");
		
		cell = row.createCell(COLUMN_INDEX_MAGIAOVIENRADE);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Mã giáo viên ra đề tài");
		
		cell = row.createCell(COLUMN_INDEX_SONHOMTOIDA);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Số nhóm tham gia tối đa");
	}
	
	public boolean kiemTraFileGiaoVien(Row row) {
		// Get all cells
		Iterator<Cell> cellIterator = row.cellIterator();
		
		while (cellIterator.hasNext()) {
			//Read cell
			Cell cell = cellIterator.next();
			Object cellValue = getCellValue(cell);
			if (cellValue == null || cellValue.toString().isEmpty()) {
				continue;
			}
			// Set value for book object
			int columnIndex = cell.getColumnIndex();
			switch (columnIndex) {
			case COLUMN_INDEX_MAGIAOVIEN:
				if(!cellValue.toString().equals("Mã giáo viên")) {
					return false;
				}
				break;
			case COLUMN_INDEX_HOTEN:
				if(!cellValue.toString().equals("Họ tên")) {
					return false;
				}
				break;
			case COLUMN_INDEX_CHUCDANH:
				if(!cellValue.toString().equals("Chức danh")) {
					return false;
				}
				break;
			case COLUMN_INDEX_LINHVUCCONGTAC:
				if(!cellValue.toString().equals("Lĩnh vực công tác")) {
					return false;
				}
				break;
			case COLUMN_INDEX_DONVICONGTAC:
				if(!cellValue.toString().equals("Đơn vị công tác")) {
					return false;
				}
				break;
			case COLUMN_INDEX_KHOACONGTAC:
				if(!cellValue.toString().equals("Khoa công tác")) {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return true;
	}
	
	private static void writeHeaderGV(Sheet sheet, int rowIndex) {
		// create CellStyle
		CellStyle cellStyle = createStyleForHeader(sheet);
		
		// Create row
		Row row = sheet.createRow(rowIndex);
		
		// Create cells
		Cell cell = row.createCell(COLUMN_INDEX_STT);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("STT");
		
		cell = row.createCell(COLUMN_INDEX_MAGIAOVIEN);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Mã giáo viên");
 
		cell = row.createCell(COLUMN_INDEX_HOTEN);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Họ tên");
 
		cell = row.createCell(COLUMN_INDEX_CHUCDANH);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Chức danh");

		cell = row.createCell(COLUMN_INDEX_LINHVUCCONGTAC);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Lĩnh vực công tác");
		
		cell = row.createCell(COLUMN_INDEX_DONVICONGTAC);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Đơn vị công tác");
		
		cell = row.createCell(COLUMN_INDEX_KHOACONGTAC);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Khoa công tác");
	}
	
	public boolean kiemTraFileSinhVien(Row row) {
		// Get all cells
		Iterator<Cell> cellIterator = row.cellIterator();
		
		while (cellIterator.hasNext()) {
			//Read cell
			Cell cell = cellIterator.next();
			Object cellValue = getCellValue(cell);
			if (cellValue == null || cellValue.toString().isEmpty()) {
				continue;
			}
			// Set value for book object
			int columnIndex = cell.getColumnIndex();
			switch (columnIndex) {
			case COLUMN_INDEX_MASINHVIEN:
				if(!cellValue.toString().equals("Mã sinh viên")) {
					return false;
				}
				break;
			case COLUMN_INDEX_HOTEN:
				if(!cellValue.toString().equals("Họ tên")) {
					return false;
				}
				break;
			case COLUMN_INDEX_NGAYSINH:
				if(!cellValue.toString().equals("Ngày sinh")) {
					return false;
				}
				break;
			case COLUMN_INDEX_SODIENTHOAI:
				if(!cellValue.toString().equals("Số điện thoại")) {
					return false;
				}
				break;
			case COLUMN_INDEX_DIACHI:
				if(!cellValue.toString().equals("Địa chỉ")) {
					return false;
				}
				break;
			case COLUMN_INDEX_KHOATRUCTHUOC:
				if(!cellValue.toString().equals("Khoa trực thuộc")) {
					return false;
				}
				break;
			case COLUMN_INDEX_NAMVAOTRUONG:
				if(!cellValue.toString().equals("Năm vào trường")) {
					return false;
				}
				break;
			case COLUMN_INDEX_NAMTOTNGHIEP:
				if(!cellValue.toString().equals("Năm tốt nghiệp")) {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return true;
	}
	
	private static void writeHeaderSV(Sheet sheet, int rowIndex) {
		// create CellStyle
		CellStyle cellStyle = createStyleForHeader(sheet);
		
		// Create row
		Row row = sheet.createRow(rowIndex);
		
		// Create cells
		Cell cell = row.createCell(COLUMN_INDEX_STT);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("STT");
 
		cell = row.createCell(COLUMN_INDEX_MASINHVIEN);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Mã sinh viên");
 
		cell = row.createCell(COLUMN_INDEX_HOTEN);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Họ tên");
 
		cell = row.createCell(COLUMN_INDEX_NGAYSINH);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Ngày sinh");

		cell = row.createCell(COLUMN_INDEX_SODIENTHOAI);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Số điện thoại");
		
		cell = row.createCell(COLUMN_INDEX_DIACHI);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Địa chỉ");
		
		cell = row.createCell(COLUMN_INDEX_KHOATRUCTHUOC);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Khoa trực thuộc");
		
		cell = row.createCell(COLUMN_INDEX_NAMVAOTRUONG);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Năm vào trường");
		
		cell = row.createCell(COLUMN_INDEX_NAMTOTNGHIEP);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Năm tốt nghiệp");
		
		cell = row.createCell(COLUMN_INDEX_MANHOM);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Mã Nhóm");
	}
	
	// Write data
	private static void ghiLuanVan(LuanVan lv, Row row) {
		if (cellStyleFormatNumber == null) {
			// Format number
			short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
			// DataFormat df = workbook.createDataFormat();
			// short format = df.getFormat("#,##0");
			
			//Create CellStyle
			Workbook workbook = row.getSheet().getWorkbook();
			cellStyleFormatNumber = workbook.createCellStyle();
			cellStyleFormatNumber.setDataFormat(format);
		}
		
		Cell cell = row.createCell(COLUMN_INDEX_STT);
		cell.setCellValue(row.getRowNum());
		
		cell = row.createCell(COLUMN_INDEX_MALUANVAN);
		cell.setCellValue(lv.getMaLuanVan());
 
		cell = row.createCell(COLUMN_INDEX_TENLUANVAN);
		cell.setCellValue(lv.getTenLuanVan());
 
		cell = row.createCell(COLUMN_INDEX_LINHVUCNGHIENCUU);
		cell.setCellValue(lv.getLinhVucNghienCuu());

		cell = row.createCell(COLUMN_INDEX_NGAYLAP);
		cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(lv.getNgayLap()));
		
		cell = row.createCell(COLUMN_INDEX_MOTA);
		cell.setCellValue(lv.getMoTa());
		
		cell = row.createCell(COLUMN_INDEX_MAGIAOVIENRADE);
		cell.setCellValue(lv.getMaGiaoVien());
		
		cell = row.createCell(COLUMN_INDEX_SONHOMTOIDA);
		cell.setCellValue(lv.getSoNhomThamGiaToiDa());
	}
	private static void ghiGiaoVien(GiaoVien gv, Row row) {
		if (cellStyleFormatNumber == null) {
			// Format number
			short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
			// DataFormat df = workbook.createDataFormat();
			// short format = df.getFormat("#,##0");
			
			//Create CellStyle
			Workbook workbook = row.getSheet().getWorkbook();
			cellStyleFormatNumber = workbook.createCellStyle();
			cellStyleFormatNumber.setDataFormat(format);
		}
		
		Cell cell = row.createCell(COLUMN_INDEX_STT);
		cell.setCellValue(row.getRowNum());
		
		cell = row.createCell(COLUMN_INDEX_MAGIAOVIEN);
		cell.setCellValue(gv.getMaGiaoVien());
 
		cell = row.createCell(COLUMN_INDEX_HOTEN);
		cell.setCellValue(gv.getHoTen());
 
		cell = row.createCell(COLUMN_INDEX_CHUCDANH);
		cell.setCellValue(gv.getChucDanh());

		cell = row.createCell(COLUMN_INDEX_LINHVUCCONGTAC);
		cell.setCellValue(gv.getLinhVucCongTac());
		
		cell = row.createCell(COLUMN_INDEX_DONVICONGTAC);
		cell.setCellValue(gv.getDonViCongTac());
		
		cell = row.createCell(COLUMN_INDEX_KHOACONGTAC);
		cell.setCellValue(gv.getKhoaCongTac());
	}
	private static void ghiSinhVien(SinhVien sv, Row row) {
		if (cellStyleFormatNumber == null) {
			// Format number
			short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
			// DataFormat df = workbook.createDataFormat();
			// short format = df.getFormat("#,##0");
			
			//Create CellStyle
			Workbook workbook = row.getSheet().getWorkbook();
			cellStyleFormatNumber = workbook.createCellStyle();
			cellStyleFormatNumber.setDataFormat(format);
		}
		
		Cell cell = row.createCell(COLUMN_INDEX_STT);
		cell.setCellValue(row.getRowNum());
 
		cell = row.createCell(COLUMN_INDEX_MASINHVIEN);
		cell.setCellValue(sv.getMaSinhVien());
 
		cell = row.createCell(COLUMN_INDEX_HOTEN);
		cell.setCellValue(sv.getHoTen());
 
		cell = row.createCell(COLUMN_INDEX_NGAYSINH);
		cell.setCellValue(sv.getNgaySinh());

		cell = row.createCell(COLUMN_INDEX_SODIENTHOAI);
		cell.setCellValue(sv.getSoDienThoai());
		
		cell = row.createCell(COLUMN_INDEX_DIACHI);
		cell.setCellValue(sv.getDiaChi());
		
		cell = row.createCell(COLUMN_INDEX_KHOATRUCTHUOC);
		cell.setCellValue(sv.getKhoaTrucThuoc());
		
		cell = row.createCell(COLUMN_INDEX_NAMVAOTRUONG);
		cell.setCellValue(sv.getNamVaoTruong());
		
		cell = row.createCell(COLUMN_INDEX_NAMTOTNGHIEP);
		cell.setCellValue(sv.getNamTotNghiep());
		
		cell = row.createCell(COLUMN_INDEX_MANHOM);
		cell.setCellValue(sv.getMaNhom());
	}
	
	// Create CellStyle for header
	private static CellStyle createStyleForHeader(Sheet sheet) {
		// Create font
		Font font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman"); 
		font.setBold(true);
		font.setFontHeightInPoints((short) 14); // font size
		font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
		// Create CellStyle
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		return cellStyle;
	}
	
	// Auto resize column width
	private static void autosizeColumn(Sheet sheet, int lastColumn) {
		for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
			sheet.autoSizeColumn(columnIndex);
		}
	}
	
	// Create output file
	private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
		try (OutputStream os = new FileOutputStream(excelFilePath)) {
			workbook.write(os);
		}
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 20-12-2020
* @version: 1.0
*/
