package ink.lichenliang.pdf2md;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDF2MD {

    public static void main(String[] args) throws IOException {

        // 加载PDF文件
        PDDocument document = PDDocument.load(new File("E:\\Work\\github\\PDF2MD\\src\\test\\resources\\test.pdf"));

        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        System.out.println(text);

    }

}
