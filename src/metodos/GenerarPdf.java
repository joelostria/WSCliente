/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author joel
 */
public class GenerarPdf {
    private Font fuentebold=new Font(Font.FontFamily.COURIER,6,Font.BOLD);
    private Font fuentenormal=new Font(Font.FontFamily.COURIER,3,Font.NORMAL);
    private Font fuenteitalic=new Font(Font.FontFamily.COURIER,5,Font.ITALIC);
    
    public void generarPDF(String header,String info,String foot,String salida){
        try {
            Document document=new Document(PageSize.A7,26,26,10,10);
            PdfWriter.getInstance(document, new FileOutputStream(salida));
            document.open();
            document.add(getHeader(header));
            /*Image imagen=Image.getInstance(img);
            imagen.scaleAbsolute(100, 100);
            imagen.setAlignment(Element.ALIGN_CENTER);*/
            //document.add(imagen);
            document.add(getInfo(info));
            document.add(getFoot(foot));
            document.close();
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    
    public void generarfacturasim(String header,String info,String foot,String img,String salida,String numero){
        try {
            Document document=new Document(PageSize.A7,26,26,10,10);
            PdfWriter.getInstance(document, new FileOutputStream(salida));
            document.open();
            Image imagen=Image.getInstance(img);
            imagen.scaleAbsolute(100, 70);
            imagen.setAlignment(Element.ALIGN_CENTER);
            document.add(imagen);
            document.add(getHeader(header));
            document.add(getnum(numero));
            document.add(getinfo2(foot));
            document.add(getInfo(info));
            document.add(getFoot("Gracias por su compra"));
            document.close();
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    
    public void generarfactura(String header,String info,String foot,String img,String salida,String numero){
        try {
            Document document=new Document(PageSize.A7,26,26,10,10);
            PdfWriter.getInstance(document, new FileOutputStream(salida));
            document.open();
            Image imagen=Image.getInstance(img);
            imagen.scaleAbsolute(100, 70);
            imagen.setAlignment(Element.ALIGN_CENTER);
            document.add(imagen);
            document.add(getHeader(header));
            document.add(getnum(numero));
            document.add(getdireccion(""));
            document.add(getinfo2(foot));
            document.add(getInfo(info));
            document.close();
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    
    private Paragraph getdireccion(String Texto){
        Paragraph g=new Paragraph();
        Chunk c=new Chunk();
        g.setAlignment(Element.ALIGN_LEFT);
        c.append("Domicilio fiscal\n Blvd Enrique segoviano \n Col.Aquiles Serdan \n Tel.5567844567 \n Pachuca Hgo \n RFC MOOJ9567HJU");
        c.setFont(fuentenormal);
        g.add(c);
        return g;
    }
    
    private Paragraph getinfo2(String Texto){
        Paragraph g=new Paragraph();
        Chunk c=new Chunk();
        g.setAlignment(Element.ALIGN_CENTER);
        c.append("Factura Smplificada \n Fecha: "+Texto);
        c.setFont(fuentebold);
        g.add(c);
        return g;
    }
    
    private Paragraph getnum(String Texto){
        Paragraph g=new Paragraph();
        Chunk c=new Chunk();
        g.setAlignment(Element.ALIGN_CENTER);
        c.append(Texto);
        c.setFont(fuentebold);
        g.add(c);
        return g;
    }
    
    private Paragraph getHeader(String Texto){
        Paragraph g=new Paragraph();
        Chunk c=new Chunk();
        g.setAlignment(Element.ALIGN_CENTER);
        c.append(Texto);
        c.setFont(fuentebold);
        g.add(c);
        return g;
    }
    
    private Paragraph getInfo(String Texto){
        Paragraph g=new Paragraph();
        Chunk c=new Chunk();
        g.setAlignment(Element.ALIGN_JUSTIFIED);
        c.append(Texto);
        c.setFont(fuentenormal);
        g.add(c);
        return g;
    }
    
    private Paragraph getFoot(String Texto){
        Paragraph g=new Paragraph();
        Chunk c=new Chunk();
        g.setAlignment(Element.ALIGN_RIGHT);
        c.append(Texto);
        c.setFont(fuenteitalic);
        g.add(c);
        return g;
    }
    
}
