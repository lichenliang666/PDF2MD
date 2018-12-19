package ink.lichenliang.pdf2md;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * 好文章：PDF文件分析 http://blog.51cto.com/antivirusjo/2054410
 */
public class PDF2MD {

    public static void main(String[] args) throws IOException {

        //读取pdf文件
        PdfReader reader = new PdfReader("E:\\Work\\github\\PDF2MD\\src\\test\\resources\\test.pdf");
        //获得pdf文件的页数
        int sumPage = reader.getNumberOfPages();

        PdfDictionary dictionary = reader.getCatalog();

        PdfDictionary pdfDictionary = reader.getPageN(1);

        Set<PdfName> set = pdfDictionary.getKeys();

        int i = 0;
        for (Iterator<PdfName> iterator = set.iterator(); iterator.hasNext(); ) {
            PdfName pdfName =  iterator.next();
            PdfObject pdfObject = pdfDictionary.getDirectObject(pdfName);
            System.out.println( i + " " + pdfName);
            System.out.println(pdfObject);
            i++;
        }

        // 获取个页面
        Rectangle rectangle = reader.getPageSize(1);

        String s = PdfTextExtractor.getTextFromPage(reader, 1);

        System.out.println(s);

    }
}
