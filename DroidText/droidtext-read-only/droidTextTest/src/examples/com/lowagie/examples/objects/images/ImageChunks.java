/*
 * $Id: ImageChunks.java 3373 2008-05-12 16:21:24Z xlv $
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://itextdocs.lowagie.com/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */
package com.lowagie.examples.objects.images;

import harmony.java.awt.Color;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import net.neiti.droidtext.PdfTestRunner;
import net.neiti.droidtext.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Wrapping Images in a Chunk.
 */
public class ImageChunks {
	/**
	 * Images wrapped in a Chunk.
	 * 
	 * @param args
	 *            no arguments needed
	 */
	public static void main(String[] args) {
		Document.compress = false;
		System.out.println("images wrapped in a Chunk");
		// step 1: creation of a document-object
		Document document = new Document();
		try {
			// step 2:
			// we create a writer that listens to the document
			// and directs a PDF-stream to a file
			PdfWriter.getInstance(document, new FileOutputStream(android.os.Environment.getExternalStorageDirectory() + java.io.File.separator + "droidtext" + java.io.File.separator + "imageChunks.pdf"));
			// step 3: we open the document
			document.open();
			// step 4: we create a table and add it to the document
			//Can't use filename => use byte[] instead
			//Image img = Image.getInstance("pngnow.png");
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			Bitmap bitmap = BitmapFactory.decodeResource(PdfTestRunner.getActivity().getResources(), R.drawable.pngnow);
			bitmap.compress(Bitmap.CompressFormat.PNG /* FileType */,
			                        100 /* Ratio */, stream);
			Image img = Image.getInstance(stream.toByteArray());
			img.scalePercent(70);
			Chunk ck = new Chunk(img, 0, -5);
			PdfPTable table = new PdfPTable(3);
			PdfPCell cell = new PdfPCell();
			cell.addElement(new Chunk(img, 5, -5));
			cell.setBackgroundColor(new Color(0xC0, 0xC0, 0xC0));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell("I see an image\non my right");
			table.addCell(cell);
			table.addCell("I see an image\non my left");
			table.addCell(cell);
			table.addCell("I see images\neverywhere");
			table.addCell(cell);
			table.addCell("I see an image\non my right");
			table.addCell(cell);
			table.addCell("I see an image\non my left");

			Phrase p1 = new Phrase("This is an image ");
			p1.add(ck);
			p1.add(" just here.");
			document.add(p1);
			document.add(p1);
			document.add(p1);
			document.add(p1);
			document.add(p1);
			document.add(p1);
			document.add(p1);
			document.add(table);
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		// step 5: we close the document
		document.close();
	}
}
