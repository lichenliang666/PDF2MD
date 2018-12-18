package ink.lichenliang.pdf2md;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class PDF2MD {

    public static void main(String[] args) throws IOException {

        // 加载PDF文件
        PDDocument document = PDDocument.load(new File("E:\\Work\\github\\PDF2MD\\src\\test\\resources\\test.pdf"));

        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        System.out.println(text);

        document.getDocumentCatalog();

        PDDocumentCatalog pdDocumentCatalog = document.getDocumentCatalog();

        // 获取大纲（书签），具体可参看 github 上的 pdfbox源码 org.apache.pdfbox.examples.pdmodel.PrintBookmarks
        PDDocumentOutline outline = pdDocumentCatalog.getDocumentOutline();

        PDResources pdResources = document.getPage(0).getResources();

        COSDictionary cosDictionary = document.getPage(0).getCOSObject();

        Iterator<PDStream> pdStreamIterator = document.getPage(0).getContentStreams();

        while (pdStreamIterator.hasNext()){
            PDStream pdStream = pdStreamIterator.next();
            System.out.println(pdStream);
        }

        document.close();

    }

}
